package com.jihu.SimpleFactory;

import java.math.BigDecimal;

public class Operation {

    public BigDecimal numberA;

    public BigDecimal numberB;

    public BigDecimal getResult(){
        return BigDecimal.ZERO;
    }

    public BigDecimal getNumberA() {
        return numberA;
    }

    public void setNumberA(BigDecimal numberA) {
        this.numberA = numberA;
    }

    public BigDecimal getNumberB() {
        return numberB;
    }

    public void setNumberB(BigDecimal numberB) {
        this.numberB = numberB;
    }
}
