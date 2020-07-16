package com.jihu.SimpleFactory;

import java.math.BigDecimal;

public class OperationFactory {

    public static Operation builder(String operation){
        Operation oper = null;
        switch (operation){
            case "+":
                oper = new OperationAdd();
                break;
            case "-":
                oper = new OperationSub();
                break;
            case "*":
                oper = new OperationMul();
                break;
            case "/":
                oper = new OperationDiv();
                break;
        }
        return oper;
    }

    public static void main(String[] args) {
        Operation operation = OperationFactory.builder("+");
        operation.setNumberA(new BigDecimal("1"));
        operation.setNumberB(new BigDecimal("2"));
        System.out.println(operation.getResult());
    }
}
