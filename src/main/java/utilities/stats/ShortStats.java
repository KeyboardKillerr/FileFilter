package utilities.stats;

public class ShortStats extends Stats {
    public final int elementCount;

    public ShortStats(int elementCount) { this.elementCount = elementCount; }

    @Override
    public String toString() { return String.format("Количество записанных элементов: %s", elementCount); }
}
