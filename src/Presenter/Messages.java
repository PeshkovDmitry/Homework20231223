package Presenter;

public interface Messages {

    public static String MAIN_MENU = "Программа-реестр животных:\n\r"
            + "1) Показать список всех животных\n\r"
            + "2) Добавить животное в реестр\n\r"
            + "3) Найти животное по кличке\n\r"
            + "4) Обучить животное новой команде\n\r"
            + "5) Выход\n\r";

    public static String SELECT = "Ваш выбор -> ";

    public static String SHOW_ALL = "В реестре записаны следующие животные:";

    public static String NEW_ANIMAL = "Запись нового животного в реестр";

    public static String GET_NAME = "Введите имя -> ";

    public static String GET_BIRTHDAY = "Введите дату рождения (ГГГГ-ММ-ДД) -> ";

    public static String GET_COMMANDS = "Введите команды через запятую -> ";

    public static String GET_TYPE = "Укажите вид животного:";
 }
