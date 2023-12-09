package org.example;

public class Main {
    public static void main(String[] args) {
        FileOperation fileOperation = new FileOperator("animals.txt", "fileCommands.txt");
        ReposInterface repos_Interface = new Repository(fileOperation);
        Controller controller = new Controller(repos_Interface);
        View view = new View(controller);
        view.run();
    }
}