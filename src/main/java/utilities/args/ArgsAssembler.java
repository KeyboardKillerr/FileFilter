package utilities.args;

import org.jetbrains.annotations.NotNull;
import utilities.args.arguments.PossibleArguments;
import utilities.collections.setlikes.PseudoSet;
import utilities.args.arguments.Argument;
import utilities.args.exceptions.*;
import utilities.collections.setlikes.SetWithGet;
import utilities.iter.CurrentIterator;
import java.util.*;

public class ArgsAssembler {
    private final Set<Integer> argsFound = new HashSet<>();
    private final Map<Integer, Argument> nonKeyArgsPositions = new HashMap<>();
    private final Map<Argument, Integer> keyArgsPositions = new HashMap<>();
    private final SetWithGet<Argument> supportedArguments = new PseudoSet<>();
    private final CurrentIterator<String> currentArgument;
    private final Character argPrefix;
    private int currentArgumentPosition = 0;

    public ArgsAssembler(char argPrefix, @NotNull String[] stringArgs, PossibleArguments... supportedArguments) {
        this.argPrefix = argPrefix;
        this.currentArgument = new CurrentIterator<>(Arrays.asList(stringArgs));
        getArguments(supportedArguments);
        parseArguments();
    }

    public Object getParameterValue(char parameter) {
        return supportedArguments.get(parameter).getValue();
    }

    public Object getParameterValue(int parameterId) {
        return supportedArguments.get(parameterId).getValue();
    }

    public Object getParameterValueAtPosition(int pos) {
        if (nonKeyArgsPositions.containsKey(pos)) return nonKeyArgsPositions.get(pos).getValue();
        for (var arg : keyArgsPositions.keySet()) {
            if (keyArgsPositions.get(arg) == pos) return arg.getValue();
        }
        throw new ArgumentNotFoundException(pos);
    }

    public boolean has(char parameter) {
        return argsFound.contains(Character.getNumericValue(parameter));
    }

    public boolean has(int parameter) {
        return argsFound.contains(parameter);
    }

    public boolean hasAtPosition(int pos) {
        return nonKeyArgsPositions.containsKey(pos) || keyArgsPositions.containsValue(pos);
    }

    private void getArguments(@NotNull PossibleArguments[] supportedArguments) {
        int argumentIndex = 0;
        for (var possibleArguments : supportedArguments) {
            for (var argument : possibleArguments.getArguments()) {
                this.supportedArguments.add(argument);
                if (argument.hasKey()) keyArgsPositions.put(argument, argumentIndex);
                else nonKeyArgsPositions.put(argumentIndex, argument);
            }
            argumentIndex++;
        }
    }

    private void parseArguments() {
        while (currentArgument.hasNext()) {
            String arg = currentArgument.next();
            arg = arg.substring(1);
            if (arg.length() != 1) parseNonKeyArgument(arg);
            else parseKeyArgument(arg.charAt(0));
        }
    }

    private void parseNonKeyArgument(@NotNull String arg) {
        if (!nonKeyArgsPositions.containsKey(currentArgumentPosition + 1))
            throw new InvalidArgumentFormatException(arg);
        currentArgumentPosition++;
        int argId = nonKeyArgsPositions.get(currentArgumentPosition).getId();
        Argument a = supportedArguments.get(argId);
        argsFound.add(argId);
        setArg(a, argId);
    }

    private void parseKeyArgument(char arg) {
        Argument a = supportedArguments.get(arg);
        if (a == null) throw new UnexpectedArgumentException(arg);
        if (keyArgsPositions.get(a) != currentArgumentPosition) {
            if (keyArgsPositions.get(a) - currentArgumentPosition == 1) currentArgumentPosition++;
            else throw new InvalidArgumentPositionException(arg);
        }
        argsFound.add(Character.getNumericValue(arg));
        setArg(a, arg);
    }

    private void setArg(@NotNull Argument a, int argId) {
        a.setPrefix(argPrefix);
        try {
            a.set(currentArgument);
        } catch (ArgsException e) {
            e.setErrorArgumentId(argId);
            throw e;
        }
    }
}
