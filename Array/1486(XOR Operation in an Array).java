class Solution {
    public int xorOperation(int n, int start) {
        int a[]=new int[n];
        int x=0;
        for(int i=0;i<n;i++){
            a[i]=start+2*i;
            x=x^a[i];
        }
        return x;
    }
}
