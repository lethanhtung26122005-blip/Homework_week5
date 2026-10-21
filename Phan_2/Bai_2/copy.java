package Homework.Homework_week5.Phan_2.Bai_2;
import java.util.*;
import java.io.*;
public class copy {

}
class main {
    public static void main(String[] args) {
        String a;
        String b;
        Scanner sc = new Scanner(System.in);
        a = sc.next();
        b = sc.next();
        BufferedReader br = null;
        PrintWriter pw = null;
        int count = 0;
        try {
            br = new BufferedReader((new FileReader(a)));
            pw = new PrintWriter(new FileWriter(b));
            String line;
            while((line = br.readLine()) != null) {
                pw.println(line);
                count++;
            }
        } catch(FileNotFoundException e) {
            System.out.println("Source file not found !");
        } catch(IOException e) {
            System.out.println("I/O error");
        } finally {
        if (pw != null) pw.close();
        if (br != null) {
        try { 
            br.close(); 
        } catch (IOException e) {}
        }
        }
        System.out.println(count);
    }
}