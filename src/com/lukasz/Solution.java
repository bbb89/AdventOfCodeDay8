package com.lukasz;

import java.util.*;

public class Solution {
    private Map<String, Integer> registers;
    private int largestValue;
    private int largestHistoricalValue;

    public Solution(List<String> input) {
        this.registers = new HashMap<>();
        this.largestHistoricalValue = 0;

        createRegisters(input);
        completeInstructions(input);
        System.out.println(registers);

        this.largestValue = findLargestValue();
    }

    private void createRegisters(List<String> input) {
        ListIterator<String> i = input.listIterator();

        while (i.hasNext()) {
            addRegister(i.next());
        }
    }

    private void addRegister(String instruction) {
        Scanner scanner = new Scanner(instruction);
        String registerName = scanner.next();
        registers.put(registerName, 0);
    }

    private void completeInstructions(List<String> input) {
        ListIterator<String> i = input.listIterator();

        while (i.hasNext()) {
            processInstruction(i.next());
        }
    }

    private void processInstruction(String instructionString) {
        Instruction instruction = parseInstruction(instructionString);
        String registerName = instruction.getRegisterName();
        int value = registers.get(registerName);
        value += instruction.findValueChange();
        registers.put(registerName, value);
        if(value > largestHistoricalValue) {
            largestHistoricalValue = value;
        }
    }

    private Instruction parseInstruction(String instruction) {
        Scanner scanner = new Scanner(instruction);
        String registerName = scanner.next();
        String command = scanner.next();
        int value = Integer.parseInt(scanner.next());
        String ifWord = scanner.next();
        String conditionRegister = scanner.next();
        int conditionRegisterRealValue = registers.get(conditionRegister);
        String condition = scanner.next();
        int conditionValue = Integer.parseInt(scanner.next());


        return new Instruction(
                registerName,
                command,
                value,
                conditionRegister,
                conditionRegisterRealValue,
                condition,
                conditionValue);
    }

    private int findLargestValue() {
        int max = 0;
        for(String s : registers.keySet()) {
            if (registers.get(s) > max) {
                max = registers.get(s);
            }
        }

        return max;
    }

    public int getLargestValue() {
        return largestValue;
    }

    public int getLargestHistoricalValue() {
        return largestHistoricalValue;
    }
}
