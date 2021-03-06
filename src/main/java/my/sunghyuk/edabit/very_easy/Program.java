package my.sunghyuk.edabit.very_easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Program {

  /**
   * Check if an Array Contains a Given Number
   * 
   * @see https://edabit.com/challenge/hAtARtyLzAHb2TEP5
   * @param arr
   * @param el
   * @return
   */
  public static boolean check(int[] arr, int el) {      
    for (int i = 0; i < arr.length; i++) {
      if(arr[i] == el) {
        return true;
      }
    }
    return false;
  }

  public static int getLastItem(int[] nums) {
    List<Integer> list = new ArrayList<>();
    
    for(int num : nums){
      list.add(num);
    }
    return list.get(list.size() - 1);
  }
  
}