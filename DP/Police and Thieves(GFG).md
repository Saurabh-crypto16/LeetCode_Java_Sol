```java
class Solution { 
    static int catchThieves(char arr[], int n, int k) { 
        ArrayList<Integer> police=new ArrayList<>();
        ArrayList<Integer> thief=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            if(arr[i]=='P') police.add(i);
            else    thief.add(i);
        }
        
        int p=0,t=0,ans=0;
        while(p<police.size() && t<thief.size()){
            if(Math.abs(police.get(p)-thief.get(t))<=k){
                p++;
                t++;
                ans++;
            }else if(police.get(p)>thief.get(t)){
                //if current police is ahead current thief and unable to catch him them we 
                //increment thief because police may catch nearer thief as 1st if is false so 
                //distance between them is > k
                t++;
            }else{
                p++;
            }
        }
        
        return ans;
	} 
} 
```
