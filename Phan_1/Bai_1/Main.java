package Homework.Homework_week5.Phan_1.Bai_1;

import java.util.*;

public class Main {

    static long useString() {
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 100000; i++) {
            s += "Hello"; 
        }
        long end = System.currentTimeMillis();
        System.out.println("Do dai chuoi (String): " + s.length());
        return end - start;
    }

    static long useStringBuffer() {
        long start = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 100000; i++) {
            sb.append("Hello");
        }
        long end = System.currentTimeMillis();
        System.out.println("Do dai chuoi (StringBuffer): " + sb.length());
        return end - start;
    }

    static void contentAnalysis(String text) {
        int sentences = 0;
        boolean inEnd = false;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c == '.' || c == '?' || c == '!') {
                if (!inEnd) {
                    sentences++;
                    inEnd = true;
                }
            } else {
                inEnd = false;
            }
        }
        System.out.println("So cau: " + sentences);

        StringBuffer sb = new StringBuffer(text);
        String target = "Java";
        String replacement = "Python";
        int count = 0;
        int idx = sb.indexOf(target);
        while (idx != -1) {
            sb.replace(idx, idx + target.length(), replacement);
            count++;
            idx = sb.indexOf(target, idx + replacement.length());
        }
        System.out.println("Da thay " + count + " lan");
        System.out.println("Van ban sau khi thay:");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        System.out.println("Thoi gian useString: " + useString() + " ms");
        System.out.println("Thoi gian useStringBuffer: " + useStringBuffer() + " ms");
        System.out.println();

        String text = "Java is great! Do you like Java? I learn Java every day. "
                    + "Java is used for web, mobile... Really? Yes!";
        contentAnalysis(text);
    }
}