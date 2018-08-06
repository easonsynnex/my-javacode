package com.yin.FilterChain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by easony on 08/03/18.
 */
public class HandlerChain implements Chain {
    List<Handler> handlers = new ArrayList<>();

    public List<Handler> addHandler(Handler handler){
        this.handlers.add(handler);
        return this.handlers;
    }

    @Override
    public void hanle(Context context) {
        for(Handler handler:handlers){
            handler.handle(context);
        }
    }
}
