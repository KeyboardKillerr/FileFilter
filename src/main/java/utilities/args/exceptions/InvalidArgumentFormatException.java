package utilities.args.exceptions;

import org.jetbrains.annotations.NotNull;

public class InvalidArgumentFormatException extends ArgsException {
    public InvalidArgumentFormatException() { super(); }

    public InvalidArgumentFormatException(@NotNull Throwable cause) { super(cause); }

    public InvalidArgumentFormatException(@NotNull String errorParameter) {
        super();
        setErrorParameter(errorParameter);
    }

    public InvalidArgumentFormatException(@NotNull String errorParameter, @NotNull Throwable cause) {
        super(cause);
        setErrorParameter(errorParameter);
    }

    @Override
    protected void updateMessage() {
        message = String.format("'%s' is not a valid argument format.", errorParameter);
    }
}
