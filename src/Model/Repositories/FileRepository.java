package Model.Repositories;

import Exceptions.DatabaseFileErrorException;
import Model.AnimalFactory;
import Model.Entities.Animal;
import Presenter.AnimalType;
import Presenter.BirthdayParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileRepository implements Repository{

    @Override
    public void create(Animal animal) {

    }

    @Override
    public List<Animal> readAll() throws DatabaseFileErrorException {
        List<Animal> list = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("Animals.csv"));
            String str = "";
            while ((str = bufferedReader.readLine()) != null) {
                String[] data = str.split(";");
                list.add(AnimalFactory.get(
                        AnimalType.valueOf(data[1].toUpperCase()),
                        data[0],
                        BirthdayParser.parse(data[2]),
                        Arrays.asList(data[3].split(","))
                ));
            }
            bufferedReader.close();
        }
        catch (IOException e) {
            throw new DatabaseFileErrorException("Невозможно прочитать файл данных", "Animals.csv");
        }
        return list;
    }

    @Override
    public Animal readByName(String name) throws DatabaseFileErrorException {
        for (Animal animal: readAll()) {
            if (animal.getName().equals(name)) {
                return animal;
            }
        }
        return null;
    }

    @Override
    public void update(Animal animal) throws DatabaseFileErrorException {
        List<Animal> list = readAll();
        try (FileWriter fileWriter = new FileWriter("Animals.csv")) {
            for (Animal a: list) {
                if (a.getName().equals(animal.getName())) {
                    fileWriter.write(animal.getCSV());
                } else {
                    fileWriter.write(a.getCSV());
                }
            }
            fileWriter.flush();
        } catch (IOException e) {
            throw new DatabaseFileErrorException("Невозможно записать в файл данных", "Animals.csv");
        }
    }

    @Override
    public void delete(Animal animal) throws DatabaseFileErrorException {
        List<Animal> list = readAll();
        try (FileWriter fileWriter = new FileWriter("Animals.csv")) {
            for (Animal a: list) {
                if (!a.equals(animal)) {
                    fileWriter.write(animal.getCSV());
                }
            }
            fileWriter.flush();
        } catch (IOException e) {
            throw new DatabaseFileErrorException("Невозможно записать в файл данных", "Animals.csv");
        }
    }
}
