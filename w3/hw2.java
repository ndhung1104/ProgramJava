import java.io.*;
import java.util.Arrays;

public class hw2 {
    public static void main(String args[])
    {
        int[] arr;
        int n;
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(br.readLine());
            Arrays.sort(arr);
            
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
            pw.println(n);
            for (int i = 0; i < n; i++)
                pw.println(arr[i]);
            pw.close();
            br.close();
        }
        catch (IOException e)
        {
            System.err.println("Send halp!");
        }
    }
}
