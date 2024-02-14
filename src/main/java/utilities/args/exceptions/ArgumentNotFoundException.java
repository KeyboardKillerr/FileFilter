package utilities.args.exceptions;

import org.jetbrains.annotations.NotNull;

public class ArgumentNotFoundException extends ArgsException {
    private int position;

    public ArgumentNotFoundException() { super(); }

    public ArgumentNotFoundException(@NotNull Throwable cause) { super(cause); }

    public ArgumentNotFoundException(int position) {
        super();
        setPosition(position);
    }

    public ArgumentNotFoundException(int position, @NotNull Throwable cause) {
        super(cause);
        setPosition(position);
    }

    private void setPosition(int position) {
        this.position = position;
        updateMessage();
    }

    @Override
    protected void updateMessage() {
        message = String.format("Argument in position %d not found.", position);
    }
}
