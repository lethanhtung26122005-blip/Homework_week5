package Homework.Homework_week5.Phan_2.Bai_5;


import java.io.*;
import java.util.*;

class InvalidConfigException extends Exception {
    public InvalidConfigException(String message) {
        super(message);
    }
}

public class Main {

    static void validate(Map<String, String> config) throws InvalidConfigException {
        // username bắt buộc
        String username = config.get("username");
        if (username == null || username.isEmpty()) {
            throw new InvalidConfigException("Missing required key: username");
        }

        String timeout = config.get("timeout");
        if (timeout == null || timeout.isEmpty()) {
            throw new InvalidConfigException("Missing required key: timeout");
        }
        int t = Integer.parseInt(timeout);          // sai định dạng -> NumberFormatException
        if (t <= 0) {
            throw new InvalidConfigException("timeout must be greater than 0");
        }

        String maxConn = config.get("maxConnections");
        if (maxConn != null) {
            int m = Integer.parseInt(maxConn);
            if (m < 1) {
                throw new InvalidConfigException("maxConnections must be at least 1");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap duong dan file config: ");
        String path = sc.nextLine().trim().replace("\"", "");

        BufferedReader br = null;
        Map<String, String> config = new LinkedHashMap<>();

        try {
            br = new BufferedReader(new FileReader(path));

            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue; 
                }
                int idx = line.indexOf('=');
                if (idx <= 0) {
                    throw new InvalidConfigException("Bad line: " + line);
                }
                String key = line.substring(0, idx).trim();
                String value = line.substring(idx + 1).trim();
                config.put(key, value);
            }

            validate(config);

            for (Map.Entry<String, String> e : config.entrySet()) {
                System.out.println(e.getKey() + " = " + e.getValue());
            }
            System.out.println("Config loaded successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("Config file not found.");
        } catch (IOException e) {
            System.out.println("I/O error.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
        } catch (InvalidConfigException e) {
            System.out.println("Invalid config: " + e.getMessage());
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("I/O error.");
                    e.printStackTrace();
                }
            }
            System.out.println("Program finished.");
        }
    }
}
