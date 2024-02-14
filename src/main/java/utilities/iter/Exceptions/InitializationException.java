package utilities.iter.Exceptions;

import org.jetbrains.annotations.NotNull;

public class InitializationException extends IteratorException {
    public InitializationException() { }

    public InitializationException(@NotNull Throwable cause) { super(cause); }

    @Override
    public String getMessage() {
        return "Provided list was null or empty.";
    }
}
