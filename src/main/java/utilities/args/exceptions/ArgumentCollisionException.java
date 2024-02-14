package utilities.args.exceptions;

import org.jetbrains.annotations.NotNull;

public class ArgumentCollisionException extends ArgsException {
    public ArgumentCollisionException() { super(); }

    public ArgumentCollisionException(@NotNull Throwable cause) { super(cause); }

    public ArgumentCollisionException(int errorArgumentId) {

        super();
        setErrorArgumentId(errorArgumentId);
    }

    public ArgumentCollisionException(int errorArgumentId, @NotNull Throwable cause) {
        super(cause);
        setErrorArgumentId(errorArgumentId);
    }

    @Override
    protected void updateMessage() {
        if (isArgumentIdChar()) message = String.format(
                "Two arguments with key '%c' were found in a single PossibleArgument.",
                errorArgumentId);
        else message = String.format(
                "Two arguments with key %d were found in a single PossibleArgument.",
                errorArgumentId);
    }
}
