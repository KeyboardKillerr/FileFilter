package utilities.iter.Exceptions;

import org.jetbrains.annotations.NotNull;

public class IteratorException extends RuntimeException {
    public IteratorException() {}

    public IteratorException(@NotNull String message) { super(message); }

    public IteratorException(@NotNull Throwable cause) { super(cause); }

    public IteratorException(@NotNull String message, @NotNull Throwable cause) { super(message, cause); }
}
