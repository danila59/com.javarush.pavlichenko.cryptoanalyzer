package Service;

import java.io.IOException;

public class Encryption {
    public void encrypt(String text, int Key, String path) throws IOException {
        char[] chars = text.toLowerCase().toCharArray();
        String result = "";
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            for (int j = 0; j <= Constants.ALPHABET.length; j++) {
                int n = Constants.ALPHABET.length;
                if (j == n) continue;

                if (j + Key >= Constants.ALPHABET.length && c == Constants.ALPHABET[j]) {
                    char c1 = Constants.ALPHABET[(j + Key) % n];
                    chars[i]=c1;
                    break;
                }
                if (c == Constants.ALPHABET[j]) {
                    chars[i]=Constants.ALPHABET[j+Key];
                    break;
                }
            }
        }
        result= String.valueOf(chars);
        FileHandler.writeFile(path,result);
    }
}
