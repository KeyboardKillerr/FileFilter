package utilities.filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import utilities.args.FilterUtilityArgs;

public class StringFilter {
    private final Collection<Integer> integers = new ArrayList<>();
    private final Collection<Double> doubles = new ArrayList<>();
    private final Collection<String> strings = new ArrayList<>();

    public Collection<Integer> getIntegers() { return new ArrayList<>(integers); }

    public Collection<Double> getDoubles() { return new ArrayList<>(doubles); }

    public Collection<String> getStrings() { return new ArrayList<>(strings); }

    public void filter(@NotNull String... stringsToParse) {
        for (var string : stringsToParse) {
            if (tryParseInt(string)) continue;
            if (tryParseDouble(string)) continue;
            strings.add(string);
        }
    }

    public void filter(@NotNull Collection<String> stringsToParse) {
        for (var string : stringsToParse) {
            if (tryParseInt(string)) continue;
            if (tryParseDouble(string)) continue;
            strings.add(string);
        }
    }

    private boolean tryParseInt(String string) {
        try {
            integers.add(Integer.parseInt(string));
            return true;
        } catch (NumberFormatException ignored) {
            return false;
        }
    }

    private boolean tryParseDouble(String string) {
        try {
            doubles.add(Double.parseDouble(string));
            return true;
        } catch (NumberFormatException ignored) {
            return false;
        }
    }
}