package utilities.args.exceptions;

import org.jetbrains.annotations.NotNull;

public class MultiplePossibleNonKeyArgumentsException extends ArgsException {
    public MultiplePossibleNonKeyArgumentsException() { super(); }

    public MultiplePossibleNonKeyArgumentsException(@NotNull Throwable cause) { super(cause); }

    public MultiplePossibleNonKeyArgumentsException(int errorArgumentId) {
        super();
        setErrorArgumentId(errorArgumentId);
    }

    public MultiplePossibleNonKeyArgumentsException(int errorArgumentId, @NotNull Throwable cause) {
        super(cause);
        setErrorArgumentId(errorArgumentId);
    }

    @Override
    protected void updateMessage() {
        message = String.format("There were at least one non-key argument with id %d " +
                        "in a set of multiple possible arguments.", errorArgumentId);
    }
}
