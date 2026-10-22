package Homework.Homework_week5.Phan_2.Bai_3;
import java.util.*;
import java.io.*;
public class numbers {

}
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DataOutputStream dos = null;
        DataInputStream dis = null;
        try {
            int n;
            n = sc.nextInt();
            dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Java_programming\\Homework\\Homework_week5\\Phan_2\\Bai_3\\numbers.bin")));
            for(int i=0; i<n; i++) {
                dos.writeInt(sc.nextInt());
            }
        } catch(InputMismatchException e) {
            System.out.println("Phai nhap so nguyen!");
            return;
        } catch(IOException e) {
            System.out.println("I/O error: " + e.getMessage());
        } finally {
            if (dos != null) {
                try {
                    dos.close();
                } catch(IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        try {
            dis = new DataInputStream(new BufferedInputStream(new FileInputStream("Java_programming\\Homework\\Homework_week5\\Phan_2\\Bai_3\\numbers.bin")));
            while(true) {
                System.out.println(dis.readInt());
            } 
        } catch(EOFException e) {
            System.out.println("Het File");
        } catch(IOException e) {
            System.out.println("I/O error " + e.getMessage());
        } finally {
            if(dis != null) {
                try {
                    dis.close();
                } catch(IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}

