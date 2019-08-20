package com.yin.arithmetic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        String s = "abc";
        String p = "abc";
        Solution solution = new Solution();
        System.out.println(solution.findAnagrams(s, p));
    }

    private static class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> results = new ArrayList<>();
            if(s.length() > 20100 || p.length() > 20100){
                return results;
            }
            char[] ps = p.toCharArray();
            int pl = p.length();


            HashMap<Object, Integer> map = new HashMap<>();
            for(int i = 0;i < pl; i++){
                if(map.containsKey(ps[i])){
                    map.put(ps[i], Integer.valueOf(map.get(ps[i])) + 1);
                }else{
                    map.put(ps[i], 1);
                }
            }
            HashMap<Object, Integer> partmap;
            char[] partchar;
            boolean flag;
            aa:for(int i = 0; i < s.length() - pl + 1;i++){
                flag = true;
                partmap = new HashMap<>();

                partchar = s.substring(i, i + pl).toCharArray();

                bb:for(int j = 0;j < pl;j++){
                    if(map.containsKey(partchar[j])){
                        if(partmap.containsKey(partchar[j])){
                            partmap.put(partchar[j], Integer.valueOf(partmap.get(partchar[j])) + 1);
                        }else{
                            partmap.put(partchar[j], 1);
                        }
                    }else{
                        flag = false;
                        break bb;
                    }
                }

                if(!flag){
                    continue;
                }
                cc:for(Map.Entry<Object,Integer> entry : map.entrySet()){
                    if (map.get(entry.getKey()) != partmap.get(entry.getKey())) {
                        flag = false;
                        break cc;
                    }

                }

                if(flag){

                    results.add(i);
                }
            }

            return results;
        }
    }

}
