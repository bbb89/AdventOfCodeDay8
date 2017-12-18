package com.lukasz;

public class Instruction {
    private String registerName;
    private int value;
    private String conditionRegister;
    private int conditionRegisterRealValue;
    private String condition;
    private int conditionValue;

    public Instruction(String registerName,
                       String command,
                       int value,
                       String conditionRegister,
                       int conditionRegisterRealValue,
                       String condition,
                       int conditionValue) {
        this.registerName = registerName;
        this.value = findValue(value, command);
        this.conditionRegister = conditionRegister;
        this.conditionRegisterRealValue = conditionRegisterRealValue;
        this.condition = condition;
        this.conditionValue = conditionValue;
    }

    public int findValueChange() {
        if(instructionCondition()) {
            return value;
        }

        return 0;
    }

    private int findValue(int value, String command) {
        if (command.equals("inc")) {
            return value;
        }

        return value * (-1);
    }

    private boolean instructionCondition() {
        switch (condition) {
            case ">":
                return conditionRegisterRealValue > conditionValue;
            case "<":
                return conditionRegisterRealValue < conditionValue;
            case ">=":
                return conditionRegisterRealValue >= conditionValue;
            case "<=":
                return conditionRegisterRealValue <= conditionValue;
            case "==":
                return conditionRegisterRealValue == conditionValue;
            case "!=":
                return conditionRegisterRealValue != conditionValue;
        }

        return false;
    }

    public String getRegisterName() {
        return registerName;
    }
}
