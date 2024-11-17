package service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

public class Validator {

    public static boolean isFileNotEmpty(String path) {
        File file = new File(path);
        if (file.length() != 0) {
            return true;
        } else {
            System.out.println("Файл не должен быть пустым -> " + path);
            return false;
        }
    }


    public static boolean isValidKey(int key) {
        if (key <= 0 || key > 42) {
            System.out.println("Введен некорректный ключ. ");
            return false;
        }

        try {
            int validate = key;
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Введен некорректный ключ.");
            return false;
        }
    }

    public static boolean isFileExists(String filePath) {
        Path path = Path.of(filePath);
        boolean exists = Files.exists(path);
        if (!exists) {
            System.out.println("Файл не найден по указанному пути -> " + path);
        }
        return exists;
    }

    public static boolean isDirectoryExist(String directory) {
        File f = new File(directory);
        boolean exists = Files.exists(f.toPath());
        if (!exists) {
            System.out.println("Папка не найдена по указанному пути -> " + f);
        }
        return exists;
    }

}
