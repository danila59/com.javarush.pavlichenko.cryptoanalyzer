package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class StaticAnalyse {

    public void StaticAnalyse(String text, String path) throws IOException {
        String path1 = System.getProperty("user.dir") + File.separator + "text" + File.separator + "dictionary.txt";
        ArrayList<String> results = new ArrayList<>();
        TreeMap<Integer, String> map = new TreeMap<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path1));
            while (bufferedReader.ready()) {
                results.add(bufferedReader.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        int count = 0;
        int Key = 0;
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
            String[] words = result.split(" ");
            for (String word : words) {
                for (int i = 0; i < results.size(); i++) {
                    String s = results.get(i);
                    if (s.length() <= 2) continue;
                    boolean equals = word.equals(results.get(i));
                    if (equals) {
                        count++;
                    }
                }
            }
            map.put(count, result);
            count = 0;
            Key++;
            chars = text.toLowerCase().toCharArray();
        }
        int largestKey = 0;
        String largestValue = "";
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            int key = entry.getKey();
            String val = entry.getValue();
            if (key > largestKey) {
                largestKey = key;
                largestValue = val;

            }
        }
        FileHandler.writeFile(path, largestValue);
    }
}
