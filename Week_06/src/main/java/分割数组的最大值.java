/**
 * 分割数组的最大值  https://leetcode-cn.com/problems/split-array-largest-sum/
 */
public class 分割数组的最大值 {
    public int splitArray(int[] nums, int m) {
        //看这个大哥的题解https://leetcode-cn.com/problems/split-array-largest-sum/solution/er-fen-cha-zhao-by-liweiwei1419-4/

        int max=0,sum=0;
        for(int n:nums){
            max=Math.max(max,n);
            sum+=n;
        }
        int l=max,r=sum;
        while(l<r){
            int mid=(l+r)>>>1;

            //这里用贪心思想先猜一个值，cnt可能不准，不准就根据二分查找不断逼近
            int cur=0,cnt=1;
            for(int n:nums){
                if(cur+n>mid){
                    cur=0;
                    cnt++;
                }
                cur+=n;
            }

            if(cnt>m){
                l=mid+1;
            }else {
                r=mid;
            }
        }
        return l;
    }
}

