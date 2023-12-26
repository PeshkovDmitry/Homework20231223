package Model.Entities;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Humster extends Pet {

    public Humster(String name, Date birthday, List<String> commands) {
        super(name, birthday, commands);
    }

    @Override
    public String toString() {
        return "Хомяк " + name
                + ", дата рождения " + birthday
                + ", знает команды " + commands;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Humster)) return false;
        Humster humster = (Humster) o;
        return Objects.equals(getName(), humster.getName())
                && Objects.equals(getBirthday(), humster.getBirthday())
                && Objects.equals(getCommands(), humster.getCommands());
    }

}
