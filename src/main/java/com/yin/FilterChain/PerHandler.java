package com.yin.FilterChain;

/**
 * Created by easony on 08/03/18.
 */
public class PerHandler implements Handler {

    @Override
    public void handle(Context context) {
        if(context.isPre()){
            System.out.println("Pre Handler...");
            context.getResult().add("after");
        }
    }
}
