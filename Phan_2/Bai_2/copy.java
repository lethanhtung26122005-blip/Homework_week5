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
            try {
            br = new BufferedReader((new FileReader(a)));
            } catch(FileNotFoundException e) {
            System.out.println("Source file not found !");
            return;
            }
            try {
            pw = new PrintWriter(new FileWriter(b));
            } catch(FileNotFoundException e) {
            System.out.println("Cannot find destination file !");
            return;
            }
            String line;
            while((line = br.readLine()) != null) {
                pw.println(line);
                count++;
            }
            } catch(IOException e) {
            System.out.println("I/O error");
            e.printStackTrace();
            } finally {
                if (pw != null) pw.close();
                if (br != null) {
                    try { 
                        br.close(); 
                    } catch (IOException e) {
                        System.out.println("I/O error");
                        e.printStackTrace();
                    }
                }
            }
        System.out.println(count);
    }
}