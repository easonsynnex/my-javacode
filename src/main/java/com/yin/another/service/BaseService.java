package com.yin.another.service;

import java.util.concurrent.atomic.AtomicBoolean;

public abstract class BaseService implements Service {
    protected AtomicBoolean state = new AtomicBoolean();

    public void tryStart() {
        init();
        System.out.println("Try start...");
    }

    @Override
    public void start() {
        tryStart();
        System.out.println("Starting...");
    }
}
