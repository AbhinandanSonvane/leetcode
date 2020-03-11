package main.java.com.as.leetcode.problem;

public class ContainerWithMostWater {

  public int maxArea(int[] height) {

    int i = 0;
    int j = height.length - 1;

    int maxArea = 0;
    int area = 0;
    while (i < j) {

      if (height[i] <= height[j]) {
        area = (j - i) * height[i];
        i++;
      } else {
        area = (j - i) * height[j];
        j--;
      }

      if (area >= maxArea) {
        maxArea = area;
      }
    }

    return maxArea;
  }
}
