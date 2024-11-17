package service;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class BruteForce {

    public void Brute(String text, String path) throws IOException {
        int num = 0;
        int Key = 1;
        char[] chars = text.toLowerCase().toCharArray();
        String result = "";

        while (Key != Constants.ALPHABET.length) {
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                for (int j = 0; j <= Constants.ALPHABET.length; j++) {
                    int n = Constants.ALPHABET.length;
                    if (j == n) continue;


                    if (j + Key >= Constants.ALPHABET.length && c == Constants.ALPHABET[j]) {
                        char c1 = Constants.ALPHABET[(j + Key) % n];
                        chars[i] = c1;
                        break;
                    }

                    if (c == Constants.ALPHABET[j]) {
                        chars[i] = Constants.ALPHABET[j + Key];
                        break;
                    }
                }
            }

            result = String.valueOf(chars);
            num++;
            String filename = "//readme_" + num + ".txt";
            Files.createFile(Path.of(path + filename));
            BufferedWriter out = new BufferedWriter(new FileWriter(path + filename));
            out.write(result);
            chars = text.toLowerCase().toCharArray();
            Key++;
            out.close();
        }
        System.out.println("Готово, проверьте папку которую Вы указали для записи файлов.");
    }
}
