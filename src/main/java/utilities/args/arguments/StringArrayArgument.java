package utilities.args.arguments;

import org.jetbrains.annotations.NotNull;
import utilities.args.exceptions.MissingStringException;
import utilities.args.exceptions.PrefixNotSetException;
import utilities.iter.CurrentIterator;

import java.util.*;

public class StringArrayArgument extends Argument {
    public StringArrayArgument() { super(); }

    public StringArrayArgument(char key) { super(key); }

    public void set(@NotNull CurrentIterator<String> currentArgument) {
        if (prefix == null) throw new PrefixNotSetException();
        List<String> outArgs = new ArrayList<>();
        boolean isFirst = true;
        do {
            String arg;
            if (isFirst) {
                arg = currentArgument.current();
                isFirst = false;
            }
            else arg = currentArgument.next();
            if (!arg.startsWith(prefix.toString())) outArgs.add(arg);
            else {
                currentArgument.previous();
                break;
            }
        } while (currentArgument.hasNext());
        //currentArgument.previous();
        if (outArgs.isEmpty()) throw new MissingStringException();
        value = outArgs.toArray(new String[0]);
    }
}
