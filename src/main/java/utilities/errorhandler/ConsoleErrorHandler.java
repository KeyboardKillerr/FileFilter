package utilities.errorhandler;

import org.jetbrains.annotations.NotNull;

public class ConsoleErrorHandler implements ErrorHandler {
    public void Handle(@NotNull Throwable e) {
        System.err.println(e.getMessage());
    }
}
