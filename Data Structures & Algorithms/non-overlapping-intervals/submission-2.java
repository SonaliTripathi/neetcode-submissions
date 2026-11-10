class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        int c=0;

        for(int i=1;i<intervals.length;i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            int lastend = res.get(res.size()-1)[1];

            if(start<lastend){
                res.get(res.size()-1)[1]=Math.min(lastend,end);
                c++;
            }else{
                res.add(intervals[i]);
            }
        }
        return c;
    }
}
//nlogn
//1
