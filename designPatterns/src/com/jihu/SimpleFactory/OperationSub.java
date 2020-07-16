package com.jihu.SimpleFactory;

import java.math.BigDecimal;

public class OperationSub extends Operation{

    @Override
    public BigDecimal getResult() {
        return numberA.subtract(numberB);
    }
}
