/**
 * 搜索二维矩阵  https://leetcode-cn.com/problems/search-a-2d-matrix/
 */
public class 搜索二维矩阵 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0) return false;
        int row=matrix.length;
        int col=matrix[0].length;
        int l=0,r=row*col-1,mid=0;
        while (l<=r){
            mid=(l+r+1)>>>1;
            int tr=mid/col;
            int tc=mid%col;
            if(matrix[tr][tc]==target){
                return true;
            }else if(matrix[tr][tc]<target){
                l=mid+1;
            }else {
                r=mid-1;
            }
        }
        return false;
    }
}
