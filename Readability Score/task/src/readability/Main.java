package readability;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var checker = new DifficultyChecker();
        var scanner = new Scanner(System.in);

        var input = scanner.nextLine();

        var difficulty = checker.averageCheck(input);

        System.out.println(difficulty);
    }
}
