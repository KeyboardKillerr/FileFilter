package utilities.args.exceptions;

import org.jetbrains.annotations.NotNull;

public class MissingStringException extends ArgsException {
    public MissingStringException() { super(); }

    public MissingStringException(@NotNull Throwable cause) { super(cause); }

    public MissingStringException(int errorArgumentId) {
        super();
        setErrorArgumentId(errorArgumentId);
    }

    public MissingStringException(int errorArgumentId, @NotNull Throwable cause) {
        super(cause);
        setErrorArgumentId(errorArgumentId);
    }

    @Override
    protected void updateMessage() {
        if (isArgumentIdChar()) message = String.format("Could not find string parameter for -%c.", errorArgumentId);
        else message = String.format("Could not find string parameter for %d.", errorArgumentId);
    }
}
