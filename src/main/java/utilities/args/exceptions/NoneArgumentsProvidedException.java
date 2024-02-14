package utilities.args.exceptions;

import org.jetbrains.annotations.NotNull;

public class NoneArgumentsProvidedException extends ArgsException {
    public NoneArgumentsProvidedException() { super(); }

    public NoneArgumentsProvidedException(@NotNull Throwable cause) { super(cause); }

    @Override
    protected void updateMessage() {
        message = "None of the arguments were provided.";
    }
}
