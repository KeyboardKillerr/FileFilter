package utilities.args.exceptions;

import org.jetbrains.annotations.NotNull;

public class UnexpectedArgumentException extends ArgsException {
    public UnexpectedArgumentException() { super(); }

    public UnexpectedArgumentException(@NotNull Throwable cause) { super(cause); }

    public UnexpectedArgumentException(int errorArgumentId) {
        super();
        setErrorArgumentId(errorArgumentId);
    }

    public UnexpectedArgumentException(int errorArgumentId, @NotNull Throwable cause) {
        super(cause);
        setErrorArgumentId(errorArgumentId);
    }

    @Override
    protected void updateMessage() {
        if (isArgumentIdChar()) message = String.format("Argument -%c unexpected.", errorArgumentId);
        else message = String.format("Argument %d unexpected.", errorArgumentId);
    }
}