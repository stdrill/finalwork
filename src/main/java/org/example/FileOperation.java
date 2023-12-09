package org.example;
import java.util.List;

public interface FileOperation {
    List<String> readAllLines();
    List<String> readCommand();

    void saveAllLines(List<String> lines);
    void  saveCommand(List <String> commands);
}
