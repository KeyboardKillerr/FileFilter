package utilities.args.exceptions;

import org.jetbrains.annotations.NotNull;

public class InvalidArgumentNameException extends ArgsException {
    public InvalidArgumentNameException() { super(); }

    public InvalidArgumentNameException(@NotNull Throwable cause) { super(cause); }

    public InvalidArgumentNameException(int errorArgumentId) {
        super();
        setErrorArgumentId(errorArgumentId);
    }

    public InvalidArgumentNameException(int errorArgumentId, @NotNull Throwable cause) {
        super(cause);
        setErrorArgumentId(errorArgumentId);
    }

    @Override
    protected void updateMessage() {
        if (isArgumentIdChar()) message = String.format("'%c' is not a valid argument name.", errorArgumentId);
        else message = String.format("%d is not a valid argument id.", errorArgumentId);
    }
}
