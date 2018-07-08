package com.yin.springDI;

import com.yin.springDI.Entity.User;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by easony on 05/10/18.
 */
public class testMap {
    static Map<String, User> map = new HashMap<String, User>();
    static{
        User user = new User();
        user.setAge(33);
        map.put("a", user);
    }
    public static void main(String[] args){
        User user = map.get("a");
        user.setAge(22);
        System.out.println(map.get("a").getAge());
    }
}
