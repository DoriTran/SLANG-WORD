package Dictionary;

import java.io.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;

public class Dictionary {
    private static HashMap<String,String> slang_word = new HashMap<String,String>();
    private static HashMap<String,String> reverse_word = new HashMap<String,String>();
    private static LinkedList<String> history = new LinkedList<String>();

    // Database
    public static void LoadData() throws IOException {
        FileReader reader;
    
        // Check file if it exists
        try {
            reader = new FileReader("slang_data.txt");
        } 
        catch (IOException e) {
            System.out.println("Unable to open file");
            return;
        }
    
        // Load data from file
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] word = line.split("`");

            // Slang word to definition
            slang_word.put(word[0], word[1]);

            // Definition to Slang word
            if (reverse_word.containsKey(word[1])) {
                reverse_word.put(word[1], reverse_word.get(word[1]) + "\n" + word[0]);
            } 
            else {
                reverse_word.put(word[1], word[0]);
            }

        }
    
        reader.close();      
    }
    public static void SaveData() throws IOException {
        FileWriter writer = new FileWriter("slang_data.txt");

        // Write data to file
        for (String key : slang_word.keySet()) {
            writer.write(key + "`" + slang_word.get(key) + "\n");
        }

        writer.close();
    }
    
    public static void LoadHistory() throws IOException {
        FileReader reader;
    
        // Check file if it exists
        try {
            reader = new FileReader("history.txt");
        } 
        catch (IOException e) {
            System.out.println("Unable to open file");
            return;
        }
    
        // Load data from file
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            // Slang word to definition
            history.addFirst(line);
        }
    
        reader.close();
    }
    public static void SaveHistory() throws IOException {
        FileWriter writer = new FileWriter("history.txt");

        // Write data to file
        for (String line : history) {
            writer.write(line + "\n");
        }

        writer.close();
    }
    
    public static Integer size()  {
        return slang_word.size();
    }


    // 1. Chức năng tìm kiếm theo slang word.
    public static String findByKey (String key) {
        return slang_word.get(key);
    }

    // 2. Chức năng tìm kiếm theo definition, hiển thị ra tất cả các slang words mà trong defintion có chứa keyword gõ vào.
    public static String findByExactMatchDefinition (String definition) {
        return reverse_word.get(definition);
    }
    public static HashMap<String, String> findByDefinition (String definition) {
        HashMap<String, String> search_result = new HashMap<String, String>();

        for (Map.Entry<String, String> element : slang_word.entrySet()) {
            if (element.getValue().contains(definition)) {
                search_result.put(element.getKey(), element.getValue());
            }
        }
        return search_result;
    }

    // 3. Chức năng hiển thị history, danh sách các slang word đã tìm kiếm.
    public static void addHistory(String search_keyword, String result, boolean isSearchByDefinition) {
        String newHistory = (!isSearchByDefinition ? "Search by slang_word\t" : "Search by definition\t") 
                        + search_keyword + " : " 
                        + result;
        history.addFirst(newHistory);
    }
    public static void printHistory() {
        for (String h : history) {
            System.out.println("> " + h);
        }
    }

    // 4. Chức năng add 1 slang words mới.
    public static void addNewSlangWord(String newSlangWord, String newDefinition) {
        slang_word.put(newSlangWord, newDefinition);
        reverse_word.put(newDefinition, newSlangWord);
    }

    // 5. Chức năng edit 1 slang word.
    public static boolean isExist(String slangword) {
        return slang_word.containsKey(slangword);
    }
    public static void editSlangWord(String slangword, String newSlangword) {
        reverse_word.put(slang_word.get(slangword), newSlangword);
        slang_word.put(newSlangword, slang_word.get(slangword));
        slang_word.remove(slangword);
    }
    public static void editDefinition(String slangword, String newDefinition) {
        reverse_word.put(newDefinition, slangword);
        reverse_word.remove(slang_word.get(slangword));
        slang_word.put(slangword, newDefinition);
    }
    
    // 6. Chức năng delete 1 slang word. Confirm trước khi xoá.
    public static void removeSlangWord(String slangword) {
        reverse_word.remove(slang_word.get(slangword));
        slang_word.remove(slangword);
    }

    // 7. Chức năng reset danh sách slang words gốc.
    public static void resetDatabase()  throws IOException {
        // Empty 2 hashmap
        slang_word.clear();
        reverse_word.clear();

        // Read from back up database
        FileReader reader;
    
        // Check file if it exists
        try {
            reader = new FileReader("slang_backup.txt");
        } 
        catch (IOException e) {
            System.out.println("Unable to open file");
            return;
        }
    
        // Load data from file
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] word = line.split("`");

            // Slang word to definition
            slang_word.put(word[0], word[1]);

            // Definition to Slang word
            if (reverse_word.containsKey(word[1])) {
                reverse_word.put(word[1], reverse_word.get(word[1]) + "\n" + word[0]);
            } 
            else {
                reverse_word.put(word[1], word[0]);
            }

        }
    
        reader.close();   
    }

    // 8. Chức năng random 1 slang word (On this day slang word).

    // 9. Chức năng đố vui, chương trình hiển thị 1 random slang word, với 4 đáp án cho người dùng chọn.

    // 10. Chức năng đố vui, chương trình hiển thị 1 definition, với 4 slang words đáp án cho người dùng chọn.

}
