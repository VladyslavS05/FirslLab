package com.company;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.print("\nВиберіть завдання \n1. Категорія віку \n2. Табуляція функції \n3. Одновимірний масив \n4. Матриця \n\nВаш вибір: ");
            int askTask = scanner.nextInt();

            switch (askTask) {
                case 1:
                    TaskOne();
                    break;
                case 2:
                    TaskTwo();
                    break;
                case 3:
                    TaskThree();
                    break;
                case 4:
                    TaskFour();
                    break;
                default:
                    System.out.println("Ви обрали неправильне завдання!");
                    break;
            }
        }
    }

    // Запитання віку користувача і визначення, до якої вікової категорії він належить
    public static void TaskOne() {
        System.out.print("Введіть Ваш вік: ");

        int age = scanner.nextInt();

        switch ((1 <= age && age <= 10) ? 1 :
                (11 <= age && age <= 15) ? 2 :
                        (16 <= age && age <= 20) ? 3 :
                                (21 <= age && age <= 30) ? 4 :
                                        (31 <= age && age <= 100) ? 5 : 6) {
            case 1 -> System.out.println("Ви дитина!");
            case 2 -> System.out.println("Ви підліток!");
            case 3 -> System.out.println("Ви юнак!");
            case 4 -> System.out.println("Ви молода людина!");
            case 5 -> System.out.println("Ви доросла людина!");
            case 6 -> System.out.println("Неправильно введений вік!");
        }
    }

    // Табулювання функції
    public static void TaskTwo() {
        float a = -2f, dx = 0.5f;
        Integer b = 12;

        System.out.print("Яким циклом виконати завдання? \n1. While \n2. Do.. while \n\nВаш вибір: ");
        int askCycle = scanner.nextInt();

        if (askCycle == 1) {
            System.out.println("x\t | \t f(x)");

            while (a <= b) {
                System.out.println(a + "\t| \t " + Math.round(((Math.pow(a, 4)) - 12 * a) / (a - 2)));
                a += dx;
            }
        } else if (askCycle == 2) {
            System.out.println("x\t | \t f(x)");
            do {
                System.out.println(a + "\t| \t " + Math.round(((Math.pow(a, 4)) - 12 * a) / (a - 2)));
                a += dx;
            } while (a <= b);
        } else {
            System.out.println("Ви обрали неіснуючий варіант");
        }
    }

    // Заповнення масиву
    public static void TaskThree() {
        Integer[] array;
        Integer enterArray;

        System.out.print("\nВведіть розмірність масиву: ");
        enterArray = scanner.nextInt();

        System.out.print("Заповнити масив автоматично? (y/n): ");
        String way = scanner.next();

        if (way.equals("y") || way.equals("yes")) {
            array = new Integer[enterArray];
            for (int i = 0; i < enterArray; i++) {
                array[i] = (int) (Math.random() * (200 + 1)) - 100;
            }
            for (int i = 0; i < enterArray; i++) {
                System.out.println("Елемент [" + (i + 1) + "] : " + array[i]);
            }
            TaskThreeSolution(array, enterArray);
        } else {
            array = new Integer[enterArray];
            for (int i = 0; i < enterArray; i++) {
                System.out.print("Введіть елемент[" + (i + 1) + "]: ");
                while (!scanner.hasNextInt()) {
                    System.out.print("Введіть елемент[" + (i + 1) + "]: ");
                    scanner.next();
                }
                array[i] = scanner.nextInt();
            }
            for (int i = 0; i < enterArray; i++) {
                System.out.println("Елемент [" + (i + 1) + "]: " + array[i]);
            }
            TaskThreeSolution(array, enterArray);
        }
    }

    // Сума елементів масиву з непарними номерами; сума елементів масиву між першим і другим додатними елементами
    public static void TaskThreeSolution(Integer[] array, Integer enterArray) {
        double summOdd = 0;
        for (int i = 0; i < enterArray; i += 2) {
            summOdd += array[i];
        }
        System.out.println("Сума елементів масиву з непарними номерами: " + summOdd);

        int sumBetween = 0;
        for (int i = 0; i < enterArray; i++) {
            if (array[i] > 0) {
                i++;
                while (array[i] <= 0 && i < enterArray) {
                    sumBetween += array[i];
                    i++;
                }
                break;
            }
        }

        System.out.println("Сума елементів масиву, розташованих між першим й другим додатними елементами: " + sumBetween);
    }

    // Поміняти місцями вказані рядки матриці
    public static void TaskFour() {
        Integer[][] matrix;
        byte n, m;
        System.out.print("\nВведіть кількість рядків матриці: ");
        n = scanner.nextByte();
        System.out.print("Введіть кількість стовбців матриці: ");
        m = scanner.nextByte();
        matrix = new Integer[n][m];

        System.out.print("Заповнити матрицю автоматично? (y/n): ");
        String way = scanner.next();

        if (way.equals("y") || way.equals("yes")) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = (int) (Math.random() * (200 + 1)) - 100;
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(matrix[i][j] + "\t\t");
                }
                System.out.println();
            }

        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print("Введіть елемент[" + (i + 1) + "][" + (j + 1) + "]: ");
                    while (!scanner.hasNextInt()) {
                        System.out.print("Введіть елемент[" + (i + 1) + "][" + (j + 1) + "]: ");
                        scanner.next();
                    }
                    matrix[i][j] = scanner.nextInt();
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(matrix[i][j] + "\t\t");
                }
                System.out.println();
            }
        }

        System.out.println("Які рядки матриці необхідно поміняти місцями? ");
        byte k = scanner.nextByte();
        byte p = scanner.nextByte();

        for (int i = 0; i < matrix[0].length; i++) {
            int temp = matrix[k - 1][i];
            matrix[k - 1][i] = matrix[p - 1][i];
            matrix[p - 1][i] = temp;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(matrix[i][j] + "\t\t");
            }
            System.out.println();
        }
    }
}




