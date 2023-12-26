package Model;

import Model.Entities.*;
import Presenter.AnimalType;
import Presenter.BirthdayParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class RegistryModel implements Model {



    @Override
    public void add(Animal animal) {

    }

    @Override
    public List<Animal> getAll() {
        List<Animal> list = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("Animals.csv"));
            String str = "";
            while ((str = bufferedReader.readLine()) != null) {
                String[] data = str.split(";");
                String name = data[0];
                AnimalType type = AnimalType.valueOf(data[1]);
                Date bithday = BirthdayParser.parse(data[2]);
                List<String> commands = Arrays.asList(data[3].split(","));
                Animal animal = null;
                switch (type) {
                    case CAT:
                        animal = new Cat(name, bithday, commands);
                        break;
                    case DOG:
                        animal = new Dog(name, bithday, commands);
                        break;
                    case HUMSTER:
                        animal = new Humster(name, bithday, commands);
                        break;
                    case HORSE:
                        animal = new Horse(name, bithday, commands);
                        break;
                    case CAMEL:
                        animal = new Camel(name, bithday, commands);
                        break;
                    case DONKEY:
                        animal = new Donkey(name, bithday, commands);
                        break;
                }
                list.add(animal);
            }
        }
        catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public List<Animal> getByName(String name) {
        return null;
    }

    @Override
    public void addCommand(String command, Animal animal) {

    }
}
