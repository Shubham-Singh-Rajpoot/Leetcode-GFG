
from typing import List


class Solution:
    def Rearrange(self, n : int, arr : List[int]) -> None:
        list1=[]
        list2=[]
        for i in arr:
            if i<0:
                list1.append(i)
            else:
                list2.append(i)
        for i in range(len(list1)):
            arr[i]=list1[i]
        for i in range(len(list2)):
            arr[len(list1)+i]=list2[i]
            
        



#{ 
 # Driver Code Starts

class IntArray:
    def __init__(self) -> None:
        pass
    def Input(self,n):
        arr=[int(i) for i in input().strip().split()]#array input
        return arr
    def Print(self,arr):
        for i in arr:
            print(i,end=" ")
        print()


if __name__=="__main__":
    t = int(input())
    for _ in range(t):
        
        n = int(input())
        
        
        arr=IntArray().Input(2)
        
        obj = Solution()
        obj.Rearrange(n, arr)
        
        print(*arr, end=' ')
        print()

# } Driver Code Ends