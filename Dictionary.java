import java.io.*;
import java.io.IOException;
import java.util.HashMap;

public class Dictionary {
    HashMap<String,String> slang_word;
    HashMap<String,String> reverse_word;

    public Dictionary() throws IOException {
        slang_word = new HashMap<String,String>();
        reverse_word = new HashMap<String,String>();
        this.LoadData();
    }

    public void LoadData() throws IOException {     
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
            if (!this.slang_word.containsKey(word[0])) {
                this.slang_word.put(word[0], word[1]);
                this.reverse_word.put(word[1], word[0]);
            }
        }
    
        reader.close();      
    }
}
