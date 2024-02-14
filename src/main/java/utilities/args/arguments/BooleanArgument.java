package utilities.args.arguments;

import org.jetbrains.annotations.*;
import utilities.iter.CurrentIterator;

import java.util.*;

public class BooleanArgument extends Argument {
    public BooleanArgument() { super(); }

    public BooleanArgument(char key) { super(key); }

    public void set(@NotNull CurrentIterator<String> currentArgument) { value = true; }
}
