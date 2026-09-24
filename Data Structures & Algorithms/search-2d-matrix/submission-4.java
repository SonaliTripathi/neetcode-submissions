class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int top =0;
        int bottom = rows-1;

        while(top<=bottom){
            int midrow = (top+bottom)/2;

            if(target < matrix[midrow][0]){
                bottom = midrow-1;
            }
            else if(target > matrix[midrow][cols-1]){
                top = midrow+1;
            }
            else break;
        }

        int l=0, r=cols-1;
        int row = (top+bottom)/2;

        while(l<=r){
            int mid = (l+r)/2;
            if(target < matrix[row][mid]){
                r=mid-1;
            }
            else if(target > matrix[row][mid]){
                l = mid+1;
            }
            else return true;
        }
        return false;        
    }
}

// log m + log n = log(m*n)
// 1
