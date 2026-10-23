package Homework.Homework_week5.Phan_2.Bai_4;

import java.io.*;
import java.util.*;

<<<<<<< HEAD:Phan_2/Bai_4/Main.java
class Student implements Serializable {
=======
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
>>>>>>> e7d5c5502c9da89a37ea960c67957b9746cfd09f:Phan_2/Bai_4/Student.java

    public String id;
    public String name;
    public double gpa;

    public Student(String id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return id + " - " + name + " - " + gpa;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String path = "Java_programming/Homework/Homework_week5/Phan_2/Bai_4/students.dat";
        List<Student> list = new ArrayList<>();

        while (true) {
            System.out.print("Nhap id (go END de ket thuc): ");
            String id = sc.nextLine().trim();
            if (id.equalsIgnoreCase("END")) {
                break;
            }
            System.out.print("Nhap ten: ");
            String name = sc.nextLine().trim();

            double gpa;
            try {
                System.out.print("Nhap gpa: ");
                gpa = Double.parseDouble(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("GPA khong hop le, bo qua sinh vien nay!");
                continue;
            }
            list.add(new Student(id, name, gpa));
        }

        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(path));
            for (Student s : list) {
                oos.writeObject(s);
            }
            System.out.println("Da ghi " + list.size() + " sinh vien vao " + path);
        } catch (FileNotFoundException e) {
            System.out.println("Cannot create file: " + e.getMessage());
            return;
        } catch (IOException e) {
            System.out.println("I/O error: " + e.getMessage());
            return;
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    System.out.println("Loi dong file ghi: " + e.getMessage());
                }
            }
        }

        ObjectInputStream ois = null;
        int count = 0;
        try {
            ois = new ObjectInputStream(new FileInputStream(path));
            System.out.println("Danh sach sinh vien:");
            while (true) {
                Student s = (Student) ois.readObject();
                System.out.println(s);
                count++;
            }
        } catch (EOFException e) {
            System.out.println("Het file, doc duoc " + count + " sinh vien");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O error: " + e.getMessage());
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    System.out.println("Loi dong file doc: " + e.getMessage());
                }
            }
        }
    }
}