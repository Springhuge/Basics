package com.jihu.SimpleFactory;

import java.math.BigDecimal;

public class OperationMul extends Operation{

    @Override
    public BigDecimal getResult() {
        return numberA.multiply(numberB);
    }
}
