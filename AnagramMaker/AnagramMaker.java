// package com.omid.primecheck;

import java.util.ArrayList;
import java.util.List;

public class AnagramMaker {
    public static void main(String[] args) {
        ArrayList<String> charList1 = new ArrayList<String>();
        ArrayList<String> charList2 = new ArrayList<String>();

        charList1.add("l");
        charList1.add("i");
        charList1.add("p");

        
        charList2.add("l");
        charList2.add("o");
        charList2.add("f");


        long count = charList1.stream().filter(charList2::contains).filter(charList2::remove).count();
        System.out.println(charList1.size() - count);

    }
}


