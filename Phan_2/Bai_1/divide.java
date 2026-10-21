package Homework.Homework_week5.Phan_2.Bai_1;
import java.util.*;
public class divide {
    public int a;
    public int b;
    public divide(int a, int b) {
        this.a = a;
        this.b = b;
    }
    public int result() {
        return a/b;
    }
}
class Main {
    public static void main(String[] args) {
        int a;
        int b;
        int d;
        Scanner sc = new Scanner(System.in);
        try {
        a = sc.nextInt();
        b = sc.nextInt();
        divide c = new divide(a,b);
        d = c.result();
        } catch(InputMismatchException e) {
            System.out.println("Hay nhap lai dinh dang la kieu so nguyen");
            return;
        } catch(ArithmeticException e) {
            System.out.println("Phep tinh khong duoc chia cho 0");
            return;
        } finally {
            System.out.println("Program finished");
        }
        System.out.println(d);
        return;
    }
}
