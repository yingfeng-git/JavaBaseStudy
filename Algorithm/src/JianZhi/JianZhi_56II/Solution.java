package JianZhi.JianZhi_56II;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // 用最暴力的解法
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            }else{
                map.put(num, map.get(num) + 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue() == 1) ans = entry.getKey();
            break;
        }
        return ans;
    }
}
