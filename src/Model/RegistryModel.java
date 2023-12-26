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
                list.add(AnimalFactory.get(
                        AnimalType.valueOf(data[1]),
                        data[0],
                        BirthdayParser.parse(data[2]),
                        Arrays.asList(data[3].split(","))
                ));
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
