package com.crayon.SwordToOffersss.leetcodeplan2.String;

/**
 * 剑指 Offer 05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 0 <= s 的长度 <= 10000
 */
public class ReplaceSpace {

    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (' ' == s.charAt(i)) {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
