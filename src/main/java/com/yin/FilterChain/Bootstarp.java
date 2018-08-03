package com.yin.FilterChain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by easony on 08/03/18.
 */
public class Bootstarp {
    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        Context context = new Context(true,true,result);

        HandlerChain handlerChain = new HandlerChain();
        handlerChain.addHandler(new PerHandler())
                .add(new AfterHandler());

        handlerChain.hanle(context);

        System.out.println("result size = " + result.toString());
    }
}
