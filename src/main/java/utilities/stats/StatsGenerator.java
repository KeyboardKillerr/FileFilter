package utilities.stats;

import utilities.filters.StringFilter;

public class StatsGenerator {
    private final StringFilter filteredStrings;

    public StatsGenerator(StringFilter filteredStrings) { this.filteredStrings = filteredStrings; }

    public ShortStats getShortStats() {
        int stringCount = countStrings();
        int intCount = countIntegers();
        int doubleCount = countDoubles();
        return new ShortStats(stringCount + intCount + doubleCount);
    }

    public FullStats generateFullStatistics() {
        double doubleSum = filteredStrings.getDoubles().stream().mapToDouble(Double::doubleValue).sum();
        double doubleMean = filteredStrings.getDoubles().stream().mapToDouble(Double::doubleValue).average().orElse(0);
        int minInt = filteredStrings.getIntegers().stream().mapToInt(Integer::intValue).min().orElse(0);
        int maxInt = filteredStrings.getIntegers().stream().mapToInt(Integer::intValue).max().orElse(0);
        int minStrLength = filteredStrings.getStrings().stream().mapToInt(String::length).min().orElse(0);
        int maxStrLength = filteredStrings.getStrings().stream().mapToInt(String::length).max().orElse(0);
        int stringCount = countStrings();
        int intCount = countIntegers();
        int doubleCount = countDoubles();
        return new FullStats(
                doubleSum,
                doubleMean,
                doubleCount,
                minInt,
                maxInt,
                intCount,
                minStrLength,
                maxStrLength,
                stringCount
        );
    }

    private int countStrings() { return filteredStrings.getStrings().size(); }

    private int countIntegers() { return filteredStrings.getIntegers().size(); }

    private int countDoubles() { return filteredStrings.getDoubles().size(); }
}
