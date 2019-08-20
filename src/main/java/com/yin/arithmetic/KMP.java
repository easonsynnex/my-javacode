package com.yin.arithmetic;

import java.util.Arrays;

public class KMP {
    private static int[] prefixTable;

    /**
     * 部分匹配表
     * @param t
     * @return
     */
    public int[] getPrefixTable(char[] t){
        int n = t.length;
        int len;//匹配位置
        prefixTable = new int[n];
        prefixTable[0] = 0;

        for(int i = 1;i < n;i++){
            len  = prefixTable[i - 1];
            while(true){
                if(t[len] == t[i]){
                    len++;
                    prefixTable[i] = len;
                    break;
                }else{
                    if(len > 0)//下一个比较位置
                        len = prefixTable[len - 1];
                    else{
                        prefixTable[i] = 0;//
                        break;
                    }
                }
            }
        }
        return prefixTable;
    }

    public int[] match(char[] s,char[] t){
        int[] result = new int[s.length];//记录所有匹配的子串
        int count = 0;
        int j = 0;//记录子串匹配位置
        for(int i = 0;i < s.length;i++){
            if(s[i] == t[j]){//相等
                if(j == t.length - 1){//子串匹配完毕，记录位置，并且j=0找下一个匹配的子串
                    result[count++] = i - t.length + 1;
                    j = 0;
                }else{//子串匹配位置加1
                    j++;
                }
            }else{
                if(j > 0){//如果子串位置＞0
                    j = prefixTable[j - 1];//不匹配的话从匹配表里面找到子串新的匹配位置
                    i--;//接着比较
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        KMP kmp= new KMP();
        char[] s = "ABCDAB ABCDABCDABDEABCDABD".toCharArray();
        char[] t = "ABCDABD".toCharArray();
        kmp.getPrefixTable(t);
        int index[] = kmp.match(s, t);
        System.out.println(Arrays.toString(index));
    }
}
