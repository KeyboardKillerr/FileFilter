package utilities.args.exceptions;

import org.jetbrains.annotations.NotNull;

public class ArgsException  extends RuntimeException {
    protected int errorArgumentId = 0;
    protected String errorParameter = "";
    protected String message = "";

    public ArgsException() {}

    public ArgsException(@NotNull String message) {
        super();
        this.message = message;
    }

    public ArgsException(@NotNull Throwable cause) { super(cause); }

    public ArgsException(@NotNull String message, @NotNull Throwable cause) {
        super(cause);
        this.message = message;
    }

    public int getErrorArgumentId() { return errorArgumentId; }

    public void setErrorArgumentId(int errorArgumentId) {
        this.errorArgumentId = errorArgumentId;
        updateMessage();
    }

    public String getErrorParameter() {
        return errorParameter;
    }

    public void setErrorParameter(@NotNull String errorParameter) {
        this.errorParameter = errorParameter;
        updateMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }

    protected boolean isArgumentIdChar() { return 0 <= errorArgumentId && errorArgumentId <= 127; }

    protected void updateMessage() {}
}