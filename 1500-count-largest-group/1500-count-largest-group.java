class Solution {
    public int countLargestGroup(int n) {
        int arr[] = new int[37];
        for(int i=1;i<=n;i++){
            int count = sum(i);
            arr[count]++;
        }
        Arrays.sort(arr);
        int c=0,max=arr[arr.length-1];
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]==max)
                c++;
            else
                break;
        }
        return c;
    }
    public int sum(int number){
        int s=0;
        while(number>0){
            s=s+number%10;
            number=number/10;
        }
        return s;
    }
}