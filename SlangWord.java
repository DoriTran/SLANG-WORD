import java.io.*;
import java.io.IOException;

public class SlangWord {
    // Menu Supporting
    static void clearConsole()
    {
        try
        {	
            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        } catch(Exception E)
		{
			System.out.println(E);
		}
    }

    // Main
    public static void main(String[] args) throws IOException {
        Dictionary dictionary = new Dictionary();

        dictionary.WriteData();
    }
}
