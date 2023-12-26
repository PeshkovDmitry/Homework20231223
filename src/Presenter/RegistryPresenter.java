package Presenter;

import Model.Entities.Animal;
import Model.Model;
import View.View;

import java.util.ArrayList;
import java.util.Arrays;
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
                    view.show(model.getAll().stream().map(Animal::toString).collect(Collectors.toList()), Messages.SHOW_ALL);
                    break;
                case "2":
                    view.show(null, Messages.NEW_ANIMAL);
                    view.show(AnimalType.asList(),Messages.GET_TYPE);
                    String type = view.get(Messages.SELECT);
                    String name = view.get(Messages.GET_NAME);
                    String bithday = view.get(Messages.GET_BIRTHDAY);
                    String commands = view.get(Messages.GET_COMMANDS);

                    break;
                case "3":
                    break;
                case "4":
                    return;
            }
        }

    }

}
