package com.yin.arithmetic;

import java.util.HashSet;

/**
 * @author:eason
 * @desc:最长回文串（“回文串”是一个正读和反读都一样的字符串，比如“level”或者“noon”等等就是回文串。）
 * @思路:利用hashset，遍历字符串数组，判断字符是否在hashset中，如果在则加2，并在hashset中移除改字符，反之则放入hashset中
 * ，最后判断count是否大于字符串长度
 */
public class LongestPalindromic {
    public int getLonestLength(String s){
        int count = 0;
        char[] chars = s.toCharArray();
        HashSet set = new HashSet();
        for(int i = 0;i < chars.length; i++){
            char b = chars[i];
            if(set.contains(b)){
                count += 2;
                set.remove(b);
            }else{
                set.add(b);
            }
        }
        if(count < s.length()){
            count ++;
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "assdsdgggggaa";
        LongestPalindromic longestPalindromic = new LongestPalindromic();
        System.out.println(longestPalindromic.getLonestLength(s));
    }
}
