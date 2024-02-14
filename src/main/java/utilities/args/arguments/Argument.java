package utilities.args.arguments;

import org.jetbrains.annotations.NotNull;
import utilities.iter.CurrentIterator;

import java.util.*;

public abstract class Argument {
    private final Character key;
    private final Integer id;
    protected Character prefix;
    protected Object value = null;

    public Argument(char key) {
        this.key = key;
        id = null;
    }

    public Argument() {
        this.key = null;
        this.id = EmptyKeyId.getId();
    }

    @Override
    public int hashCode() { return getId(); }

    public int getId() {
        if (id != null) return id;
        return key;
    }

    public boolean hasKey() { return id == null; }

    public Object getValue() { return value; }

    public void setPrefix(char prefix) { this.prefix = prefix; }

    public abstract void set(@NotNull CurrentIterator<String> currentArgument);
}
