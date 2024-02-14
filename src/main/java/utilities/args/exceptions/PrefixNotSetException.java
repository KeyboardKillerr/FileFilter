package utilities.args.exceptions;

import org.jetbrains.annotations.NotNull;

public class PrefixNotSetException extends ArgsException {
    public PrefixNotSetException() { super(); }

    public PrefixNotSetException(@NotNull Throwable cause) { super(cause); }

    @Override
    protected void updateMessage() {
        message = "Prefix was null.";
    }
}
