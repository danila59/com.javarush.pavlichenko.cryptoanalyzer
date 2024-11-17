package service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandler {

    public static String readFile(String filePath) throws IOException {
        Path file = Paths.get(filePath);
        byte[] bytes = Files.readAllBytes(file);
        return new String(bytes, StandardCharsets.UTF_8);
    }

    public static void writeFile(String file, String text) throws IOException {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(file);

            for (int i = 0; i < text.length(); i++) {
                fileWriter.write(text.charAt(i));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            assert fileWriter != null;
            fileWriter.close();
            System.out.println("Запись завершена.");
        }
    }
}





