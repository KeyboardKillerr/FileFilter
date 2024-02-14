package utilities.args.arguments;

public class EmptyKeyId {
    private static int currentId = 127;

    public static int getId() {
        currentId++;
        return currentId;
    }
}
