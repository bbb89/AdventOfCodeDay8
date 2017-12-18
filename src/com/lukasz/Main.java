package com.lukasz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<String> getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter passphrase: ");
        String line;
        List<String> passphrases = new ArrayList<>();


        while(!(line = scanner.nextLine()).isEmpty()) {
            passphrases.add(line);
        }

        return passphrases;
    }

    public static void main(String[] args) {

        List<String> input = getInput();

        Solution solution = new Solution(input);
        System.out.println("Largest value is " + solution.getLargestValue() + ".");
        System.out.println("Highest value held in any register during process is " + solution.getLargestHistoricalValue() + ".");


    }
}