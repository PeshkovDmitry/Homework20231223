package Model;

import Model.Entities.Animal;

import java.util.List;

public interface Model {

    public void add(Animal animal);

    public List<Animal> getAll();

    public List<Animal> getByName(String name);

    public void addCommand(String command, Animal animal);

}
