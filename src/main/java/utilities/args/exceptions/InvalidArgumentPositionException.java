package utilities.args.exceptions;

import org.jetbrains.annotations.NotNull;

public class InvalidArgumentPositionException extends ArgsException {
    public InvalidArgumentPositionException() { super(); }

    public InvalidArgumentPositionException(@NotNull Throwable cause) { super(cause); }

    public InvalidArgumentPositionException(int errorArgumentId) {
        super();
        setErrorArgumentId(errorArgumentId);
    }

    public InvalidArgumentPositionException(int errorArgumentId, @NotNull Throwable cause) {
        super(cause);
        setErrorArgumentId(errorArgumentId);
    }

    @Override
    protected void updateMessage() {
        if (isArgumentIdChar()) message = String.format("'%c' is not in position.", errorArgumentId);
        else message = String.format("%d is not in position.", errorArgumentId);
    }
}
