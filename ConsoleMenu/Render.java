package ConsoleMenu;

public class Render {
    public static void clearConsole()
    {
        try
        {	
            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        } catch(Exception E)
		{
			System.out.println(E);
		}
    }
}
