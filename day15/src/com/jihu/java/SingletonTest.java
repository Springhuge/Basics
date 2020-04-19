package com.jihu.java;

public class SingletonTest {

    public static void main(String[] args) {
        Bank bank1 = Bank.bank;
        Bank bank2 = Bank.bank;

        //Bank.bank  = null;
        Bank bank3 = Bank.bank;

        System.out.println(bank1);
        System.out.println(bank2);
        System.out.println(bank3);
    }


}

class Bank{

    private Bank(){

    }

    public static final   Bank  bank= new Bank();

//    public static Bank getInstancce(){
//        return bank;
//    }
}
