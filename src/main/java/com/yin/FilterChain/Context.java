package com.yin.FilterChain;

import java.util.List;

/**
 * Created by easony on 08/03/18.
 */
public class Context {
    private boolean isPre;
    private boolean isAfter;
    private List<String> result;

    public List<String> getResult() {
        return result;
    }

    public void setResult(List<String> result) {
        this.result = result;
    }

    public Context(boolean isPre, boolean isAfter, List<String> result) {
        this.isPre = isPre;
        this.isAfter = isAfter;
        this.result = result;
    }

    public boolean isPre() {
        return isPre;
    }

    public void setPre(boolean pre) {
        isPre = pre;
    }

    public boolean isAfter() {
        return isAfter;
    }

    public void setAfter(boolean after) {
        isAfter = after;
    }

    public Context(boolean isPre, boolean isAfter) {

        this.isPre = isPre;
        this.isAfter = isAfter;
    }
}
