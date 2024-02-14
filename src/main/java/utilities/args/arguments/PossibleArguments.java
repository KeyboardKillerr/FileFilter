package utilities.args.arguments;

import utilities.args.exceptions.ArgumentCollisionException;
import utilities.args.exceptions.MultiplePossibleNonKeyArgumentsException;
import utilities.args.exceptions.NoneArgumentsProvidedException;

import java.util.*;

public class PossibleArguments {
    private final Set<Argument> arguments;

    public PossibleArguments(Collection<Argument> arguments) {
        ValidateArguments(arguments);
        this.arguments = new HashSet<>(arguments);
    }

    public PossibleArguments(Argument... arguments) {
        ValidateArguments(Arrays.asList(arguments));
        this.arguments = new HashSet<>(Arrays.asList(arguments));
    }

    public Collection<Argument> getArguments() {
        return arguments;
    }

    private void ValidateArguments(Collection<Argument> arguments) {
        if (arguments.isEmpty()) throw new NoneArgumentsProvidedException();
        if (arguments.size() == 1) { return; }
        ArrayList<Integer> argsFound = new ArrayList<>();
        for (var arg : arguments) {
            if (!arg.hasKey()) throw new MultiplePossibleNonKeyArgumentsException(arg.hashCode());
            if (argsFound.contains(arg.hashCode())) throw new ArgumentCollisionException(arg.hashCode());
            argsFound.add(arg.hashCode());
        }
    }
}
