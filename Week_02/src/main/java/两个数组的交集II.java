import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode做题-两个数组的交集II https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/
 */
public class 两个数组的交集II {
    public int[] intersectHashMap(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){//这个很巧妙
            return intersectHashMap(nums2,nums1);
        }

        Map<Integer,Integer> map=new HashMap<>();
        for(int i:nums1){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        int[] r=new int[nums1.length];
        int index=0;
        for(int j:nums2){
            if(map.containsKey(j)&&map.get(j)>0){
                r[index++]=j;
                map.put(j,map.get(j)-1);
            }
        }

        return Arrays.copyOfRange(r,0,index);
    }

    public int[] intersectTwoPointer(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int first=0,second=0;

        int[] r=new int[nums1.length>nums2.length?nums2.length:nums1.length];
        int index=0;
        while (first<nums1.length&&second<nums2.length){
            if(nums1[first]==nums2[second]){
                r[index++]=nums1[first];
                first++;
                second++;
            }else if(nums1[first]>nums2[second]){
                second++;
            }else {
                first++;
            }
        }

        return Arrays.copyOfRange(r,0,index);
    }
}
