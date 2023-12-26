package Presenter;

import java.util.ArrayList;
import java.util.List;

public enum AnimalType {
    CAT ("Кот"),
    DOG ("Собака"),
    HUMSTER ("Хомяк"),
    HORSE ("Лошадь"),
    CAMEL ("Верблюд"),
    DONKEY ("Осёл");

    private String title;

    AnimalType(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }

    public static List<String> asList() {
        List<String> list = new ArrayList<>();
        for (AnimalType type: AnimalType.values()) {
            list.add(type.toString());
        }
        return list;
    }

}
