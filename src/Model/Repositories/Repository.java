package Model.Repositories;

import Exceptions.DatabaseFileErrorException;
import Model.Entities.Animal;

import java.util.List;

public interface Repository {

    void create(Animal animal);

    List<Animal> readAll() throws DatabaseFileErrorException;

    Animal readByName(String name) throws DatabaseFileErrorException;

    void update(Animal animal) throws DatabaseFileErrorException;

    void delete(Animal animal) throws DatabaseFileErrorException;

}
