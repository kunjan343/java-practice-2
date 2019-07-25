/*
 * PrintWriterTesting.java
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public class PrintWriterTesting 
{
    public static void main(String[] args) 
    {

        File file = new File("C:/temp/info.txt");
        PrintWriter printWriter = null;
        try
        {
            printWriter = new PrintWriter(file);
            printWriter.println("hello");
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if ( printWriter != null ) 
            {
                printWriter.close();
                System.out.println("Writing completed. Check the file content");
            }
                  
        }
    }
}

