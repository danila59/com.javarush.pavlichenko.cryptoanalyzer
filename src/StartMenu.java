
import Service.*;

import java.io.IOException;
import java.util.Scanner;

public class StartMenu {
    public static void main(String[] args) throws IOException {

        System.out.println("ШИФРОВАНИЕ МЕТОДОМ ЦЕЗАРЯ.");
        System.out.println("Выберите пункт меню.");
        System.out.println("Нажмите 1 если хотите зашифровать файл.");
        System.out.println("Нажмите 2 если хотите расшифровать файл.");
        System.out.println("Нажмите 3 если хотите расшифровать файл методом Brute force.");
        System.out.println("Нажмите 4 если хотите расшифровать файл с помощью Статистического анализа.");
        System.out.println("Нажмите 0 если хотите завершить программу.");

        Encryption encryption = new Encryption();
        Decryption decryption = new Decryption();
        BruteForce bruteForce = new BruteForce();
        StaticAnalyse staticAnalyse = new StaticAnalyse();

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int count = 3;
        String writePath = "";
        boolean b = false;
        boolean c = false;


        switch (Integer.parseInt(s)) {
            case 1 -> {

                System.out.println("Введите путь к файлу, который хотите зашифровать.");
                System.out.println("У вас " + count + " попытки.");
                String filePath = "";
                count--;
                while (!b) {
                    filePath = scanner.nextLine();
                    if (Validator.isFileExists(filePath) && Validator.isFileNotEmpty(filePath)) {
                        FileHandler.readFile(filePath);
                        b = true;
                        continue;
                    } else {
                        if (count == 0) {
                            System.out.println("Зайдите позже.");
                            return;
                        }
                        System.out.println("Попробуйте еще раз!");
                    }
                    if (count == 1) {
                        System.out.println("У вас " + count + " попытка.");
                    } else {
                        System.out.println("У вас " + count + " попытки.");
                    }
                    count--;
                }
                count = 3;
                System.out.println("Введите путь к файлу где будет записан результат шифрования.");
                System.out.println("У вас " + count + " попытки.");
                count--;
                while (!c) {
                    writePath = scanner.nextLine();
                    if (Validator.isFileExists(writePath)) {
                        c = true;
                        continue;
                    } else {
                        if (count == 0) {
                            System.out.println("Зайдите позже.");
                            return;
                        }
                        System.out.println("Попробуйте еще раз!");
                    }
                    if (count == 1) {
                        System.out.println("У вас " + count + " попытка.");
                    } else {
                        System.out.println("У вас " + count + " попытки.");
                    }
                    count--;
                }

                System.out.println("Введите целое число (ключ) от 1 до 42, на сколько позиций будет сдвиг.");
                int key = scanner.nextInt();
                if (Validator.isValidKey(key)) {
                    encryption.encrypt(FileHandler.readFile(filePath), key, writePath);
                }
            }

            case 2 -> {
                System.out.println("Введите путь к файлу, который хотите расшифровать.");
                System.out.println("У вас " + count + " попытки.");
                String filePath = "";
                count--;
                while (!b) {
                    filePath = scanner.nextLine();
                    if (Validator.isFileExists(filePath) && Validator.isFileNotEmpty(filePath)) {
                        FileHandler.readFile(filePath);
                        b = true;
                        continue;
                    } else {
                        if (count == 0) {
                            System.out.println("Зайдите позже.");
                            return;
                        }
                        System.out.println("Попробуйте еще раз!");
                    }
                    if (count == 1) {
                        System.out.println("У вас " + count + " попытка.");
                    } else {
                        System.out.println("У вас " + count + " попытки.");
                    }
                    count--;
                }
                count = 3;

                System.out.println("Введите путь к файлу где будет записан результат расшифровки.");
                System.out.println("У вас " + count + " попытки.");
                count--;
                while (!c) {
                    writePath = scanner.nextLine();
                    if (Validator.isFileExists(writePath)) {
                        c = true;
                        continue;
                    } else {
                        if (count == 0) {
                            System.out.println("Зайдите позже.");
                            return;
                        }
                        System.out.println("Попробуйте еще раз!");
                    }
                    if (count == 1) {
                        System.out.println("У вас " + count + " попытка.");
                    } else {
                        System.out.println("У вас " + count + " попытки.");
                    }
                    count--;
                }

                System.out.println("Введите целое число (ключ) от 1 до 42, на сколько позиций будет сдвиг.");
                int key = scanner.nextInt();
                if (Validator.isValidKey(key)) {
                    decryption.decrypt(FileHandler.readFile(filePath), key, writePath);
                }
            }

            case 3 -> {
                System.out.println("Введите путь к файлу, который хотите расшифровать методом Brute force.");
                System.out.println("У вас " + count + " попытки.");
                String filePath = "";
                count--;
                while (!b) {
                    filePath = scanner.nextLine();
                    if (Validator.isFileExists(filePath) && Validator.isFileNotEmpty(filePath)) {
                        FileHandler.readFile(filePath);
                        b = true;
                        continue;
                    } else {
                        if (count == 0) {
                            System.out.println("Зайдите позже.");
                            return;
                        }
                        System.out.println("Попробуйте еще раз!");
                    }
                    if (count == 1) {
                        System.out.println("У вас " + count + " попытка.");
                    } else {
                        System.out.println("У вас " + count + " попытки.");
                    }
                    count--;
                }

                System.out.println("Введите путь к папке где будут записаны результаты расшифровки.");
                while (!c) {
                    writePath = scanner.nextLine();
                    if (Validator.isDirectoryExist(writePath)) {
                        bruteForce.Brute(FileHandler.readFile(filePath), writePath);
                        c = true;
                        continue;
                    } else {
                        if (count == 0) {
                            System.out.println("Зайдите позже.");
                            return;
                        }
                        System.out.println("Попробуйте еще раз!");
                    }
                    if (count == 1) {
                        System.out.println("У вас " + count + " попытка.");
                    } else {
                        System.out.println("У вас " + count + " попытки.");
                    }
                    count--;
                }
            }


            case 4 -> {
                System.out.println("Введите путь к файлу, который хотите расшифровать с помощью статистического анализа.");
                System.out.println("У вас " + count + " попытки.");
                String filePath = "";
                count--;
                while (!b) {
                    filePath = scanner.nextLine();
                    if (Validator.isFileExists(filePath) && Validator.isFileNotEmpty(filePath)) {
                        FileHandler.readFile(filePath);
                        b = true;
                        continue;
                    } else {
                        if (count == 0) {
                            System.out.println("Зайдите позже.");
                            return;
                        }
                        System.out.println("Попробуйте еще раз!");
                    }
                    if (count == 1) {
                        System.out.println("У вас " + count + " попытка.");
                    } else {
                        System.out.println("У вас " + count + " попытки.");
                    }
                    count--;
                }

                System.out.println("Введите путь к файлу где будет записан результат.");
                while (!c) {
                    writePath = scanner.nextLine();
                    if (Validator.isFileExists(writePath)) {
                        staticAnalyse.StaticAnalyse(FileHandler.readFile(filePath), writePath);
                        c = true;
                        continue;
                    } else {
                        if (count == 0) {
                            System.out.println("Зайдите позже.");
                            return;
                        }
                        System.out.println("Попробуйте еще раз!");
                    }
                    if (count == 1) {
                        System.out.println("У вас " + count + " попытка.");
                    } else {
                        System.out.println("У вас " + count + " попытки.");
                    }
                    count--;
                }
            }
            case 0 -> System.out.println("Программа завершена.");
        }
    }
}
