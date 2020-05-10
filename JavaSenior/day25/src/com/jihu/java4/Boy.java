package com.jihu.java4;

public class Boy {

    private Girl girl;

    @Override
    public String toString() {
        return "Boy{" +
                "girl=" + girl +
                '}';
    }

    public Boy(Girl girl) {
        this.girl = girl;
    }

    public Boy() {

    }

    public Girl getGirl() {
        return girl;
    }

    public void setGirl(Girl girl) {
        this.girl = girl;
    }
}
