import utilities.args.FilterUtilityArgs;
import utilities.errorhandler.ConsoleErrorHandler;
import utilities.errorhandler.ErrorHandler;
import utilities.filters.StringFilter;
import utilities.io.FileSys;
import utilities.stats.Stats;
import utilities.stats.StatsGenerator;

import java.util.Arrays;

public class Main {
    private static final ErrorHandler errorHandler = new ConsoleErrorHandler();
    private static final StringFilter stringFilter = new StringFilter();
    private static FileSys fileSys;

    public static void main(String[] args) {
        try {
            var parsedArgs = new FilterUtilityArgs(args);
            fileSys = new FileSys(
                    Arrays.asList(parsedArgs.getInputFiles()),
                    parsedArgs.getSavePathOrDefault(),
                    parsedArgs.getFilePrefix(),
                    errorHandler
            );
            stringFilter.filter(fileSys.readAll());
            if (parsedArgs.isAppend()) append();
            else writeOver();
            var statsGenerator = new StatsGenerator(stringFilter);
            Stats stats = null;
            if (parsedArgs.isShortStat()) {
                stats = statsGenerator.getShortStats();
            }
            else if (parsedArgs.isFullStat()) {
                stats = statsGenerator.generateFullStatistics();
            }
            if (stats != null) System.out.println(stats);
        } catch (Throwable e) {
            errorHandler.Handle(e);
        }
    }

    private static void append() {
        if (!stringFilter.getDoubles().isEmpty()) fileSys.appendToDoubles(stringFilter.getDoubles());
        if (!stringFilter.getIntegers().isEmpty()) fileSys.appendToIntegers(stringFilter.getIntegers());
        if (!stringFilter.getStrings().isEmpty()) fileSys.appendToStrings(stringFilter.getStrings());
    }

    private static void writeOver() {
        if (!stringFilter.getDoubles().isEmpty()) fileSys.writeOverDoubles(stringFilter.getDoubles());
        if (!stringFilter.getIntegers().isEmpty()) fileSys.writeOverIntegers(stringFilter.getIntegers());
        if (!stringFilter.getStrings().isEmpty()) fileSys.writeOverStrings(stringFilter.getStrings());
    }
}