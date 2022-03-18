package ConsoleMenu;

import Dictionary.Dictionary;

import java.util.Scanner;

public class Menu {
    private static char choice = '\0';
    private static Scanner scanner = new Scanner(System.in);
    private static Integer MenuPosition = -1;

    // Menu position
    public static void inputMenuPosition() {
        MenuPosition = scanner.nextInt();
        scanner.nextLine();
    }
    public static Integer getMenuPosition() {
        return MenuPosition;
    }

    // Get Keyboard Event
    public static String getChoice() {
        return scanner.nextLine().toLowerCase();
    }

    public static String getString() {
        return scanner.nextLine();
    }

    // Print Menu & Feature
    public static void printMenu() {
        Render.clearConsole();
        switch (MenuPosition) {
            // Index page
            case -1:
                System.out.println(">-----------------------------------------------<");
                System.out.println("|           << Slang word Dictionary >>         |");
                System.out.println("|-----------------------------------------------|");
                System.out.println("|                                               |");
                System.out.println("|   1. Search by slang word.                    |");
                System.out.println("|   2. Search by definition.                    |");
                System.out.println("|   3. Searching history.                       |");
                System.out.println("|   4. Add new slang word.                      |");
                System.out.println("|   5. Editing slang word.                      |");
                System.out.println("|   6. Deleting slang word.                     |");
                System.out.println("|   7. Reset slang word dictionary.             |");
                System.out.println("|   8. On this day slang word.                  |");
                System.out.println("|   9. Quiz: Random slang word -> Definition.   |");
                System.out.println("|  10. Quiz: Random definition -> Slang word.   |");
                System.out.println("|                                               |");
                System.out.println("|-----------------------------------------------|");
                System.out.println("|   0. Exit and Save Dictionary                 |");
                System.out.println(">-----------------------------------------------<");
                System.out.println("");
                System.out.print("-> Input Option: ");
                break;
            case 0:
                System.out.println(">-----------------------------------------------<");
                System.out.println("|           << Slang word Dictionary >>         |");
                System.out.println("|-----------------------------------------------|");
                System.out.println("|        Saving all new words and history       |");
                System.out.println("|            Good bye - See you again           |");
                System.out.println(">-----------------------------------------------<");
                break;
            // 1. Chức năng tìm kiếm theo slang word.
            case 1:
                System.out.println(">-----------------------------------------------<");
                System.out.println("|           << Slang word Dictionary >>         |");
                System.out.println("|-----------------------------------------------|");
                System.out.println("|               Search by slang word            |");
                System.out.println(">-----------------------------------------------<");
                System.out.println("");
                break;
            // 2. Chức năng tìm kiếm theo definition, hiển thị ra tất cả các slang words mà trong defintion có chứa keyword gõ vào.
            case 2:
                System.out.println(">-----------------------------------------------<");
                System.out.println("|           << Slang word Dictionary >>         |");
                System.out.println("|-----------------------------------------------|");
                System.out.println("|               Search by definition            |");
                System.out.println(">-----------------------------------------------<");
                System.out.println("");
                break;
            // 3. Chức năng hiển thị history, danh sách các slang word đã tìm kiếm.
            case 3:
                System.out.println(">-----------------------------------------------<");
                System.out.println("|           << Slang word Dictionary >>         |");
                System.out.println("|-----------------------------------------------|");
                System.out.println("|                Searching history              |");
                System.out.println(">-----------------------------------------------<");
                System.out.println("");
                break;
            // 4. Chức năng add 1 slang words mới.
            case 4:
                System.out.println(">-----------------------------------------------<");
                System.out.println("|           << Slang word Dictionary >>         |");
                System.out.println("|-----------------------------------------------|");
                System.out.println("|               Add new slang word              |");
                System.out.println(">-----------------------------------------------<");
                System.out.println("");
                break;
            // 5. Chức năng edit 1 slang word.
            case 5:
                System.out.println(">-----------------------------------------------<");
                System.out.println("|           << Slang word Dictionary >>         |");
                System.out.println("|-----------------------------------------------|");
                System.out.println("|                Editing slang word             |");
                System.out.println(">-----------------------------------------------<");
                System.out.println("");
                break;
            // 6. Chức năng delete 1 slang word. Confirm trước khi xoá.
            case 6:
                System.out.println(">-----------------------------------------------<");
                System.out.println("|           << Slang word Dictionary >>         |");
                System.out.println("|-----------------------------------------------|");
                System.out.println("|               Deleting slang word             |");
                System.out.println(">-----------------------------------------------<");
                System.out.println("");
                break;
            // 7. Chức năng reset danh sách slang words gốc.
            case 7:
                System.out.println(">-----------------------------------------------<");
                System.out.println("|           << Slang word Dictionary >>         |");
                System.out.println("|-----------------------------------------------|");
                System.out.println("|           Reset slang word dictionary         |");
                System.out.println(">-----------------------------------------------<");
                System.out.println("");
                break; 
            // 8. Chức năng random 1 slang word (On this day slang word).
            case 8:
                System.out.println(">-----------------------------------------------<");
                System.out.println("|           << Slang word Dictionary >>         |");
                System.out.println("|-----------------------------------------------|");
                System.out.println("|              On this day slang word           |");
                System.out.println(">-----------------------------------------------<");
                System.out.println("");
                break;
            // 9. Chức năng đố vui, chương trình hiển thị 1 random slang word, với 4 đáp án cho người dùng chọn.
            case 9:
                System.out.println(">-----------------------------------------------<");
                System.out.println("|           << Slang word Dictionary >>         |");
                System.out.println("|-----------------------------------------------|");
                System.out.println("|      Quiz: Random slang word -> Definition    |");
                System.out.println(">-----------------------------------------------<");
                System.out.println("");
                break;
            // 10. Chức năng đố vui, chương trình hiển thị 1 definition, với 4 slang words đáp án cho người dùng chọn.
            case 10:
                System.out.println(">-----------------------------------------------<");
                System.out.println("|           << Slang word Dictionary >>         |");
                System.out.println("|-----------------------------------------------|");
                System.out.println("|      Quiz: Random definition -> Slang word    |");
                System.out.println(">-----------------------------------------------<");
                System.out.println("");
                break;
        }
        
    }
    public static void printFeature() {
        switch (MenuPosition) {
            // None
            case 0: 
                break;

            // Menu Option Selection
            case -1:
            inputMenuPosition();
                break;

            // 1. Chức năng tìm kiếm theo slang word.
            case 1:
                printFeature_SearchByKeyword();
                break;
            // 2. Chức năng tìm kiếm theo definition, hiển thị ra tất cả các slang words mà trong defintion có chứa keyword gõ vào.
            case 2:
                printFeature_SearchByDefinition();
                break;
            // 3. Chức năng hiển thị history, danh sách các slang word đã tìm kiếm.
            case 3:

                break;
            // 4. Chức năng add 1 slang words mới.
            case 4:

                break;
            // 5. Chức năng edit 1 slang word.
            case 5:

                break;
            // 6. Chức năng delete 1 slang word. Confirm trước khi xoá.
            case 6:

                break;
            // 7. Chức năng reset danh sách slang words gốc.
            case 7:

                break; 
            // 8. Chức năng random 1 slang word (On this day slang word).
            case 8:

                break;
            // 9. Chức năng đố vui, chương trình hiển thị 1 random slang word, với 4 đáp án cho người dùng chọn.
            case 9:

                break;
            // 10. Chức năng đố vui, chương trình hiển thị 1 definition, với 4 slang words đáp án cho người dùng chọn.
            case 10:

                break;
        }
    }
    
    // Feature
    public static void printFeature_SearchByKeyword() {
        do {
            System.out.print("> Input slang word: ");
            String search_result = Dictionary.findByKey(scanner.nextLine());

            if (search_result != null) {
                System.out.println("--> Definition: " + search_result);
            }
            else {
                System.out.println("--> No definition found!");
            }

            System.out.print("<Continue?> (Y/N)(y/n): ");
            choice = scanner.nextLine().charAt(0);
            System.out.println("");
        } while (choice != 'N' && choice != 'n');
        MenuPosition = -1;
    }
    public static void printFeature_SearchByDefinition() {
        MenuPosition = -1;
    }
    public static void printFeature_3() {
        MenuPosition = -1;
    }
    public static void printFeature_4() {
        MenuPosition = -1;
    }
    public static void printFeature_5() {
        MenuPosition = -1;
    }
    public static void printFeature_6() {
        MenuPosition = -1;
    }
    public static void printFeature_7() {
        MenuPosition = -1;
    }
    public static void printFeature_8() {
        MenuPosition = -1;
    }
    public static void printFeature_9() {
        MenuPosition = -1;
    }
    public static void printFeature_10() {
        MenuPosition = -1;
    }


    // Close Menu
    public static void close() {
        scanner.close();
    }
}
