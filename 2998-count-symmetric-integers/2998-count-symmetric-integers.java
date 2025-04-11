class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count=0;
        for (int j = low;j<=high;j++){
            String s = String.valueOf(j);
            int n = s.length();
            if (n%2==0){
                int sum1=0;
                int sum2=0;
                for (int i = 0;i<n/2;i++){
                    sum1+=Integer.parseInt(String.valueOf(s.charAt(i)));
                }
                for (int k=n/2;k<n;k++){
                    sum2+=Integer.parseInt(String.valueOf(s.charAt(k)));
                }
                if (sum1==sum2){
                    count++;
                }
            }
        }
        return count;
    }
}