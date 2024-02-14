package utilities.args;

import org.jetbrains.annotations.NotNull;
import utilities.args.arguments.*;

import java.util.Collection;

public class FilterUtilityArgs {
    private static final char ARG_PREFIX = '-';
    private static final char SHORT_STATS_KEY = 's';
    private static final char FULL_STATS_KEY = 'f';
    private static final char APPEND_OPTION_KEY = 'a';
    private static final char FILE_PREFIX_OPTION_KEY = 'p';
    private static final char SAVE_PATH_OPTION_KEY = 'o';
    private static final int INPUT_FILES_ARG_POSITION = 1;
    private ArgsAssembler parsedArgs;


    public FilterUtilityArgs(String... args) { parseArgs(args); }

    public FilterUtilityArgs(@NotNull Collection<String> args) { parseArgs(args.toArray(new String[0])); }

    public void parseArgs(String[] args) {
        final Argument shortStats = new BooleanArgument(SHORT_STATS_KEY);
        final Argument fullStats = new BooleanArgument(FULL_STATS_KEY);
        final Argument appendOption = new BooleanArgument(APPEND_OPTION_KEY);
        final Argument filenamePrefix = new StringArgument(FILE_PREFIX_OPTION_KEY);
        final Argument savePath = new StringArgument(SAVE_PATH_OPTION_KEY);
        final Argument inputFiles = new StringArrayArgument();
        final PossibleArguments fileInputArea = new PossibleArguments(inputFiles);
        final PossibleArguments optionsArea = new PossibleArguments(
                shortStats,
                fullStats,
                appendOption,
                filenamePrefix,
                savePath
        );
        parsedArgs = new ArgsAssembler(ARG_PREFIX, args, optionsArea, fileInputArea);
    }

    public boolean isShortStat() { return parsedArgs.has(SHORT_STATS_KEY); }

    public boolean isFullStat() { return parsedArgs.has(FULL_STATS_KEY); }

    public boolean isAppend() { return parsedArgs.has(APPEND_OPTION_KEY); }

    public boolean hasPrefix() { return parsedArgs.has(FILE_PREFIX_OPTION_KEY); }

    public boolean hasNonDefaultSavePath() { return parsedArgs.has(SAVE_PATH_OPTION_KEY); }

    public boolean hasAnyFiles() { return parsedArgs.hasAtPosition(INPUT_FILES_ARG_POSITION); }

    public String getFilePrefix() {
        if (!hasPrefix()) return "";
        return (String) parsedArgs.getParameterValue(FILE_PREFIX_OPTION_KEY);
    }

    public String getSavePathOrDefault() {
        if (!hasNonDefaultSavePath()) return System.getProperty("user.dir");
        return (String) parsedArgs.getParameterValue(SAVE_PATH_OPTION_KEY);
    }

    public String[] getInputFiles() {
        if (!hasAnyFiles()) return new String[0];
        return (String[]) parsedArgs.getParameterValueAtPosition(INPUT_FILES_ARG_POSITION);
    }
}
