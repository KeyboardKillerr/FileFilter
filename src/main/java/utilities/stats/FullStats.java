package utilities.stats;

public class FullStats extends Stats {
    public final double doubleSum;
    public final double doubleMean;
    public final int doubleCount;
    public final int minimalInt;
    public final int maximalInt;
    public final int intCount;
    public final int minimalStringLength;
    public final int maximalStringLength;
    public final int stringCount;

    public FullStats(
            double doubleSum,
            double doubleMean,
            int doubleCount,
            int minimalInt,
            int maximalInt,
            int intCount,
            int minimalStringLength,
            int maximalStringLength,
            int stringCount) {
        this.doubleSum = doubleSum;
        this.doubleMean = doubleMean;
        this.doubleCount = doubleCount;
        this.minimalInt = minimalInt;
        this.maximalInt = maximalInt;
        this.intCount = intCount;
        this.minimalStringLength = minimalStringLength;
        this.maximalStringLength = maximalStringLength;
        this.stringCount = stringCount;
    }

    @Override
    public String toString() {
        return "Статистика:" + '\n' +
                "Количество целых чисел: " + intCount + '\n' +
                "Минимальное целое число: " + minimalInt + '\n' +
                "Максимальное целое число: " + maximalInt + '\n' +
                "Количество вещественных чисел: " + doubleCount + '\n' +
                "Сумма вещественных чисел: " + doubleSum + '\n' +
                "Среднее вещественных чисел: " + doubleMean + '\n' +
                "Количество строк: " + stringCount + '\n' +
                "Минимальная длина строки: " + minimalStringLength + '\n' +
                "Максимальная длина строки: " + maximalStringLength + '\n';
    }
}
