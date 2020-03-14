package com.as.leetcode.strings;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
  public static int lengthOfLongestSubstring(String s) {

    Set<Character> set = new HashSet<>();

    int maxLength = 0;

    char[] charArray = s.toCharArray();
    for (int i = 0, j = 0; i < charArray.length; ) {


      if(!set.contains(charArray[i])) {
        set.add(charArray[i]);
        i++;
        maxLength = Math.max(set.size(), maxLength);
      } else {
        set.remove(charArray[j]);
        j++;
      }
      System.out.println("End i : " + i + " j : " + j);
      System.out.println("Max Length : " + maxLength);
    }

    return maxLength;
  }

  public static void main(String[] args) {

    String s = "abcadbcbb";

    s ="tmmzuxt";

    s = "aabaab!bb";

    // a -> 0 , 1 , 3, 4
    // b -> 2 , 5
    // ! -> 6

    LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(s);
  }
}
