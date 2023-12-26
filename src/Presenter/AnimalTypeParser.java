package Presenter;

public class AnimalTypeParser {

    public static AnimalType parse(String num) {
        return AnimalType.values()[Integer.parseInt(num)];
    }
}
