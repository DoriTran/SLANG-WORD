package Dictionary;

import java.io.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.LinkedList;
import java.util.ArrayList;

public class Dictionary {
    private static HashMap<String,String> slang_word = new HashMap<String,String>();
    private static HashMap<String,String> reverse_word = new HashMap<String,String>();
    private static LinkedList<String> history = new LinkedList<String>();
    private static Random generator = new Random();

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

    // 1. Ch???c n??ng t??m ki???m theo slang word.
    public static String findByKey (String key) {
        return slang_word.get(key);
    }

    // 2. Ch???c n??ng t??m ki???m theo definition, hi???n th??? ra t???t c??? c??c slang words m?? trong defintion c?? ch???a keyword g?? v??o.
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

    // 3. Ch???c n??ng hi???n th??? history, danh s??ch c??c slang word ???? t??m ki???m.
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

    // 4. Ch???c n??ng add 1 slang words m???i.
    public static void addNewSlangWord(String newSlangWord, String newDefinition) {
        slang_word.put(newSlangWord, newDefinition);
        reverse_word.put(newDefinition, newSlangWord);
    }

    // 5. Ch???c n??ng edit 1 slang word.
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
    
    // 6. Ch???c n??ng delete 1 slang word. Confirm tr?????c khi xo??.
    public static void removeSlangWord(String slangword) {
        reverse_word.remove(slang_word.get(slangword));
        slang_word.remove(slangword);
    }

    // 7. Ch???c n??ng reset danh s??ch slang words g???c.
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

    // 8. Ch???c n??ng random 1 slang word (On this day slang word).
    public static ArrayList<String> getRandomSlangWord_and_ItsDefinition() {
        ArrayList<String> slang = new ArrayList<String>(slang_word.keySet());
        
        ArrayList<String> result = new ArrayList<String>();
        result.add(slang.get(generator.nextInt(slang.size())));
        result.add(slang_word.get(result.get(0)));
        return result;
    }

    // 9. Ch???c n??ng ????? vui, ch????ng tr??nh hi???n th??? 1 random slang word, v???i 4 ????p ??n cho ng?????i d??ng ch???n.
    public static ArrayList<String> getRandomSlangWord(int numberOfSlangWords) {
        ArrayList<String> keySet = new ArrayList<String>(slang_word.keySet());

        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < numberOfSlangWords; i++) {
            result.add(keySet.get(generator.nextInt(keySet.size())));
        }
        return result;
    }

    // 10. Ch???c n??ng ????? vui, ch????ng tr??nh hi???n th??? 1 definition, v???i 4 slang words ????p ??n cho ng?????i d??ng ch???n.
    public static ArrayList<String> getRandomDefinition(int numberOfDefinitions) {
        ArrayList<String> values = new ArrayList<String>(slang_word.values());

        ArrayList<String> result = new ArrayList<String>();
        for (int i = 0; i < numberOfDefinitions; i++) {
            result.add(values.get(generator.nextInt(values.size())));
        }
        return result;

    }
}
