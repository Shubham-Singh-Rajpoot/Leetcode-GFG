class Solution:
    def maximumCount(self, nums: List[int]) -> int:
        print(nums[-1])
        if nums[0]>0 or nums[-1]<0:
            return(len(nums))
        
        def lowerbound(nums):
            s=0
            e=len(nums)-1
            while(s<=e):
                mid=s+(e-s)//2
                if(nums[mid]>=0):
                    e=mid-1
                else:
                    s=mid+1
            return s

        def upperbound(nums):
            s=0
            e=len(nums)-1
            while(s<=e):
                mid=s+(e-s)//2
                if(nums[mid]<=0):
                    s=mid+1
                else:
                    e=mid-1
            return e
        n=len(nums)
        neg=lowerbound(nums)
        pos=n-upperbound(nums)-1
        return(max(neg,pos))