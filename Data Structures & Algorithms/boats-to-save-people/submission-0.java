class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int l = 0;
        int r = people.length-1;
        int count=0;
        Arrays.sort(people);
        while(l<r){
            if(people[l]+people[r]<=limit){
                l++;r--;
                count++;
            }
            else {
                count++;
                r--;
            }
        }
        if(l==r){
            count++;
        }
        return count;
    }
}

//n
//1