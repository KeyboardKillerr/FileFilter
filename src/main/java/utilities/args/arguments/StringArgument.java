package utilities.args.arguments;

import org.jetbrains.annotations.*;
import utilities.args.exceptions.*;
import utilities.iter.CurrentIterator;

import java.util.*;

public class StringArgument extends Argument {
    public StringArgument() { super(); }

    public StringArgument(char key) { super(key); }

    public void set(@NotNull CurrentIterator<String> currentArgument) {
        if (!currentArgument.hasNext()) throw new MissingStringException();
        value = currentArgument.next();
    }
}
