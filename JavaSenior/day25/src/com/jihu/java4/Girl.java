package com.jihu.java4;

public class Girl {

    private String name;

    @Override
    public String toString() {
        return "Girl{" +
                "name='" + name + '\'' +
                '}';
    }

    public Girl(String name) {
        this.name = name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }

    public Girl() {

    }
}
