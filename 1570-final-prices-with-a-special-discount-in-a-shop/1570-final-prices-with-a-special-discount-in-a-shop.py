class Solution:
    def finalPrices(self, prices: List[int]) -> List[int]:
        n=len(prices)
        st=[]
        i=0
        for i in range(n):
            while(len(st)>0 and prices[st[-1]]>=prices[i]):
                x=st.pop()
                prices[x]=prices[x]-prices[i]
            st.append(i)
        return prices