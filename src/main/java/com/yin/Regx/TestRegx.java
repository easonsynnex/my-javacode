package com.yin.Regx;

/**
 * Created by easony on 06/20/18.
 */
public class TestRegx {
    public static void main(String[] args) {
        String regx = "^(-|\\+)?[0-9]+(.[0-9]+)?$";
        String num = "" +
                "+881";
        System.out.println(num.matches(regx));
    }
}
