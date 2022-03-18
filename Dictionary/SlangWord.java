package Dictionary;

import java.io.IOException;

import ConsoleMenu.*;

public class SlangWord {
    // Main
    public static void main(String[] args) throws IOException {
        // Loading database before loop
        Dictionary.LoadData();

        // Main loop
        do {
            // Main content
            Menu.printMenu();
            Menu.printFeature();

        } while (!Menu.getMenuPosition().equals(0));

        // Saving database after loop
        Dictionary.WriteData();
        Menu.close();
    }
}
