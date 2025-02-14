import java.util.*;

class ProductOfNumbers {
    private List<Integer> products;
    public ProductOfNumbers()
    {
        products=new ArrayList<>();
    }
    public void add(int num)
    {
        if(num==0)
            products.clear();
        else
            products.add(num*(products.isEmpty()?1:products.get(products.size()-1)));
        
    }
    public int getProduct(int k)
    {
        int n=products.size();
        if(n==0 || k>n)
            return 0;
        if(k==n)
            return products.get(n-1);
        return products.get(n-1)/products.get(n-k-1);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */