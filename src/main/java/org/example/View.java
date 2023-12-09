package org.example;
import org.example.Animals.Animals;
import org.example.Animals.Camels;
import org.example.Animals.Cats;
import org.example.Animals.Dogs;
import org.example.Animals.Donkey;
import org.example.Animals.Horses;
import org.example.Animals.Humsters;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {
    private final Controller controller;

    public View(Controller controller) {
        this.controller = controller;
    }

    public void run() {
        CommandsOfProgram com;
        navi();
        while (true) {
            try {
                String command = prompt("Введите команду: ");
                com = CommandsOfProgram.valueOf(command.toUpperCase());
                if (com == CommandsOfProgram.EXIT)
                    return;
                switch (com) {
                    case CREATE -> create();
                    case READ -> read();
                    case DEL -> delete();
                    case NAVI -> navi();
                    case SHOWALL -> showAll();
                    case TEACH -> teach();
                    case SHOWCOM -> showCom();
                    case TYPE -> typeOfAnimal();
                }
            } catch (Exception ex) {
                System.out.println("Произошла ошибка " + ex.getMessage());
            }
        }
    }

    private void read() throws Exception {
        String id = prompt("Идентификатор: ");
        Animals animal = controller.readAnimal(id);
        System.out.println(animal);
    }

    private void showAll() throws Exception {
        List<Animals> animals = controller.getAnimals();
        for (Animals item : animals) {
            System.out.println(item);
        }
    }

    private void showCom() throws Exception {
        String commandId = prompt("Команды какого животного хотите посмотреть?(введите ID) ");
        List commands = controller.getCommands();
        int index = 0;

        for (int i = 0; i < commands.size() - 1; i++) {    // пошли по циклу с конца
            if (commands.get(i).equals(commandId)) {    // встретили наш  ID
                index = i;
            }
        }

        System.out.printf("ID животного: %s\n", commands.get(index));    // покажем ID

        for (int i = index + 1; i < commands.size(); i++) {           //  пошли по циклу от него далее
            if (!(isNumeric((String) commands.get(i)))) {   // пока не встретим следующий id
                System.out.println(commands.get(i));
            } else {
                break;
            }
        }
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    private void delete() throws Exception {
        String animalid = prompt("Введите идентификатор  для удаления: ");
        System.out.println(controller.readAnimal(animalid));
        String yes = prompt("Подтвердите удалениe командой YES, а если передумали, то введите любой символ. ")
                .toUpperCase();
        if (yes.equals("YES")) {
            System.out.println("Происходит удаление записи...");
            controller.deleteAnimal(animalid); // включаем удаление в контроллере
        } else {
            System.out.println("Удаление отменено.");
        }
    }

    private void create() throws Exception {
        Counter counter = new Counter(0);
        while (true) {
            try (FileWriter fileWriter = new FileWriter("file.txt", true)) {

                String name = prompt("Имя: ");
                if (name.isEmpty()) throw new RuntimeException("Нужно ввести имя!");
                TypeVoice[] animalVoices = TypeVoice.values();

                System.out.println("Варианты звуков животных:");
                for (TypeVoice say : animalVoices) {
                    System.out.println(say);
                }

                String sound = prompt("Какой из вышеперечисленных звуков издает животное? ");
                if (sound.isEmpty()) throw new RuntimeException("Нужно ввести звук!");
                controller.saveAnimal(new Animals(name, sound));
                System.out.println("Поздравляем! Животное успешно созданно!");

                // счетчик
                int vari = counter.countVar(counter.getInternalVar());
                counter.setInternalVar(vari);
                String res = String.valueOf(vari);
                fileWriter.write(res);
                fileWriter.append('\n');
                fileWriter.flush();

            } catch (java.io.IOException e) {
                System.out.println(e.getMessage());
            }
            String theEnd = prompt("Вы закончили создание животных?(yes/enter): ");
            if (theEnd.equals("yes")) break;
        }
    }


    private void teach() throws Exception {
        String id = prompt("Введите id животного, которое хотите обучить: ");
        List<String> commands = new ArrayList<>(); // cписок команд животного
        commands.add(id); // добавляем в список сначала id
        while (true) {
            String commandOfAnimal = prompt("Команда, которую умеет животное(enter - завершить обучение): ");
            if (commandOfAnimal.equals("")) {
                break; // если ввести пустую строку цикл закончится
            } else commands.add(commandOfAnimal);
        }
        controller.saveCommands(commands);
        System.out.println("Животное обучено!");
    }

    private void typeOfAnimal() throws Exception {
        String id = prompt("Введите id животного, чтобы узнать его тип: ");
        String voice = controller.readAnimal(id).getSound();
        TypeVoice typeVoice = TypeVoice.valueOf(voice.toUpperCase());
        switch (typeVoice) {
            case GRR -> {
                Camels camel = new Camels(id, controller.readAnimal(id).getName(), controller.readAnimal(id).getSound());
                System.out.println(camel.getClass());
                System.out.println("Принадлежность вида: PackAnimals");
            }
            case MYAU -> {
                Cats cat = new Cats(id, controller.readAnimal(id).getName(), controller.readAnimal(id).getSound());
                System.out.println(cat.getClass());
                System.out.println("Принадлежность вида: HomeAnimals");
            }
            case GAV -> {
                Dogs dog = new Dogs(id, controller.readAnimal(id).getName(), controller.readAnimal(id).getSound());
                System.out.println(dog.getClass());
                System.out.println("Принадлежность вида: HomeAnimals");
            }
            case IAA -> {
                Donkey donkey = new Donkey(id, controller.readAnimal(id).getName(), controller.readAnimal(id).getSound());
                System.out.println(donkey.getClass());
                System.out.println("Принадлежность вида: PackAnimals");
            }
            case IGOGOO -> {
                Horses horse = new Horses(id, controller.readAnimal(id).getName(), controller.readAnimal(id).getSound());
                System.out.println(horse.getClass());
                System.out.println("Принадлежность вида: PackAnimals");
            }
            case CHIU -> {
                Humsters humster = new Humsters(id, controller.readAnimal(id).getName(), controller.readAnimal(id).getSound());
                System.out.println(humster.getClass());
                System.out.println("Принадлежность вида: HomeAnimals");
            }
        }
    }


    private void navi() {
        System.out.println("Список команд:");
        for (CommandsOfProgram c : CommandsOfProgram.values()) {
            System.out.println(c);
        }
    }

    public String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }
}
