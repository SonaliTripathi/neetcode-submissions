class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        //check if no solution exists,
        //at every step if gas is less than cost to go to another station
        //then no solution exists
        int totalgas=0;
        int totalcost=0;
        for(int i=0;i<gas.length;i++){
            totalgas=totalgas+gas[i];
            totalcost=totalcost+cost[i];
        }
        if(totalgas<totalcost) return -1;

        //One unique solution exists
        //Will loop just for the length of array, because if at any point
        //we find the answer, it will be possible to come back to that point in a circle

        int start=0;
        int currgas=0;
        for(int i=0;i<=gas.length-1;i++){
            currgas=currgas+gas[i]-cost[i];
            if(currgas<0){
                start=i+1;
                currgas=0;
            }
            
        }
        return start;
        
    }
}
//n
//1
