import java.io.*;
import java.io.IOException;
import java.util.HashMap;

public class Dictionary {
    HashMap<String,String> slang_word;
    HashMap<String,String> reverse_word;

    // Database
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
            if (word.length <= 1) continue;
            else if (!this.slang_word.containsKey(word[0])) {
                this.slang_word.put(word[0], word[1]);
                this.reverse_word.put(word[1], word[0]);
            }
        }
    
        reader.close();      
    }

    public void WriteData() throws IOException {
        FileWriter writer = new FileWriter("slang_data.txt");

        // Write data to file
        for (String key : slang_word.keySet()) {
            writer.write(key + "`" + slang_word.get(key) + "\n");
        }

        writer.close();
    }

    // 1. Chức năng tìm kiếm theo slang word.

    // 2. Chức năng tìm kiếm theo definition, hiển thị ra tất cả các slang words mà trong defintion có chứa keyword gõ vào.

    // 3. Chức năng hiển thị history, danh sách các slang word đã tìm kiếm.

    // 4. Chức năng add 1 slang words mới.

    // 5. Chức năng edit 1 slang word.

    // 6. Chức năng delete 1 slang word. Confirm trước khi xoá.

    // 7. Chức năng reset danh sách slang words gốc.

    // 8. Chức năng random 1 slang word (On this day slang word).

    // 9. Chức năng đố vui, chương trình hiển thị 1 random slang word, với 4 đáp án cho người dùng chọn.

    // 10. Chức năng đố vui, chương trình hiển thị 1 definition, với 4 slang words đáp án cho người dùng chọn.

}
