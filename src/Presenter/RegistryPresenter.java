package Presenter;

import Exceptions.AnimalTypeParseException;
import Exceptions.BirthdayParseException;
import Exceptions.DatabaseException;
import Exceptions.EmptyNameException;
import Model.Entities.Animal;
import Model.Model;
import View.View;
import Model.AnimalFactory;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class RegistryPresenter implements Presenter {

    private Model model;

    private View view;

    public RegistryPresenter(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void onButtonClicked() {
        view.show(null, Messages.MAIN_MENU);
        while (true) {
            String answer = view.get(Messages.SELECT);
            switch (answer.trim()) {
                case "1":
                    try {
                        view.show(
                                model.getAll().stream().map(Animal::toString).collect(Collectors.toList()),
                                Messages.SHOW_ALL);
                    } catch (DatabaseException | BirthdayParseException e) {
                        view.show(null, e.getMessage() + " " + e.getText());
                    }
                    break;
                case "2":
                    try {
                        view.show(null, Messages.NEW_ANIMAL);
                        view.show(AnimalType.asList(), Messages.GET_TYPE);
                        AnimalType type = AnimalTypeParser.parse(view.get(Messages.SELECT));
                        String name = view.get(Messages.GET_NAME);
                        if (name.isBlank()) {
                            throw new EmptyNameException("Введено пустое имя","");
                        }
                        Date bithday = BirthdayParser.parse(view.get(Messages.GET_BIRTHDAY));
                        List<String> commands = Arrays.asList(view.get(Messages.GET_COMMANDS).split("\\,"));
                        Animal animal = AnimalFactory.get(type, name, bithday, commands);
                        System.out.println(animal);
                        model.add(animal);
                    } catch (DatabaseException | BirthdayParseException | EmptyNameException | AnimalTypeParseException e) {
                        view.show(null, e.getMessage() + " " + e.getText());
                    }
                    break;
                case "3":
                    break;
                case "4":
                    return;
            }
        }

    }

}
