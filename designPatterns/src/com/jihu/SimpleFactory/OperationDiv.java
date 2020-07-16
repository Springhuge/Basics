package com.jihu.SimpleFactory;

import java.math.BigDecimal;

public class OperationDiv extends Operation{

    @Override
    public BigDecimal getResult() {
        return numberA.divide(numberB);
    }
}
