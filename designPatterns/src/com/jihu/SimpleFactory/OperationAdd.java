package com.jihu.SimpleFactory;

import java.math.BigDecimal;

public class OperationAdd extends Operation {

    @Override
    public BigDecimal getResult() {
        return numberA.add(numberB);
    }
}
