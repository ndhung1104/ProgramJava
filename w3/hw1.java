// package w3;
import java.io.*;
import java.util.Arrays;

public class hw1 {
    public static void main(String args[])
    {
        FileInputStream fin;
        int[] arr;
        int n;
        try
        {
            fin = new FileInputStream("a.inp");
            n = fin.read();
            arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = fin.read();
            Arrays.sort(arr);
            FileOutputStream fout = new FileOutputStream("a.out");
            fout.write(n);
            for (int i = 0; i < n; i++)
                fout.write(arr[i]);
        }
        catch (IOException e)
        {
            System.err.println("Send halp!");
        }
    }
}
