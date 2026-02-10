package T3;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test {
    //给定一个字符串 s ，请你找出其中不含有重复字符的 最长 子串 的长度。
    //
    //示例 1:
    //
    //输入: s = "abcabcbb"
    //输出: 3
    //解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。注意 "bca" 和 "cab" 也是正确答案。
    //示例 2:
    //
    //输入: s = "bbbbb"
    //输出: 1
    //解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
    //示例 3:
    //
    //输入: s = "pwwkew"
    //输出: 3
    //解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
    //     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
    public static void main(String[] args) {
        String s = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        //TODO:2026.1.2
        //使用哈希集合完成
        //设计思想：比较每个位置后面对应的最长不含重复字符的子串长度，使用双层遍历，rk用于指示当前遍历位置
        //双指针用来实现双层遍历
        int rk = -1;
        int ans = 0;
        int n = s.length();
        //哈希集合，用于记录每个字符是否出现过
        Set<Character> occ = new HashSet<>();
        for(int i = 0;i<n;i++){
            if(i!=0){
                //左指针右移一位，移除一个字符
                occ.remove(s.charAt(i-1));
            }
            //移动右指针
            while(rk+1<n && !occ.contains(s.charAt(rk+1))){
                occ.add(s.charAt(rk+1));
                ++rk;
            }
            //从i到rk是一个不含重复字符的子串长度
            ans = Math.max(ans,rk-i+1);
        }
        return ans;
    }
}
