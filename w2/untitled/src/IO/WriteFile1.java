package IO;
import java.io.*;

public class WriteFile1
{
    public void write1()
    {
        FileOutputStream fout;
        try
        {
            fout = new FileOutputStream("b.txt");
            fout.write(10);
            fout.write(20);
            fout.close();
        }
        catch (IOException e)
        {
            System.out.println("Error");
        }

    }
}
