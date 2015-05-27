    package com.fcy.test02;  
      
    public class Test05 {  
        public static void main(String[] args) {  
        	String query="acbac";
    		String text="acaccbabb";
            char[] ss = text.toCharArray();  
            char[] tt = query.toCharArray();  
            System.out.println(KMP_Index(ss, tt)); // KMP匹配字符串  
        }  
      
        public static int[] next(char[] t) {  
            int[] next = new int[t.length];  
            next[0] = -1;  
            int i = 0;  
            int j = -1;  
            while (i < t.length - 1) {  
                if (j == -1 || t[i] == t[j]) {  
                    i++;  
                    j++;  
                    if (t[i] != t[j]) {  
                        next[i] = j;  
                    } else {  
                        next[i] = next[j];  
                    }  
                } else {  
                    j = next[j];  
                }  
            }  
            return next;  
        }  
        public static int KMP_Index(char[] s, char[] t) {  
            int[] next = next(t);  
            int i = 0;  
            int j = 0;  
            while (i <= s.length - 1 && j <= t.length - 1) {  
                if (j == -1 || s[i] == t[j]) {  
                    i++;  
                    j++;  
                } else {  
                    j = next[j];  
                }  
            }  
            if (j < t.length) {  
                return -1;  
            } else  
                return i - t.length; // 返回模式串在主串中的头下标  
        }  
    }  