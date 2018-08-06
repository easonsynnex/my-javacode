package com.yin.FilterChain;

/**
 * Created by easony on 08/03/18.
 */
public class AfterHandler implements Handler {

    @Override
    public void handle(Context context) {
        if(context.isAfter()){
            System.out.println("After Handler...");
            context.getResult().add("pre");
        }
    }
}
