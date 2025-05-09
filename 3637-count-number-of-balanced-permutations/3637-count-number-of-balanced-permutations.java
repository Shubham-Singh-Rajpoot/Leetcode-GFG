import java.math.BigInteger;

class Solution {
    public int countBalancedPermutations(String num) {
		int n = num.length(), sum = 0;
		int[] nums = new int[n], hash = new int[10];
		for (int i = 0; i < n; i++) {
			nums[i] = num.charAt(i) - '0';
			hash[nums[i]]++;
			sum += nums[i];
		}
		if ((sum & 1) == 1) return 0;
		int index = 0;
        for (int i = 9; i >= 0; i--) {
            int count = hash[i];
            while (count-- > 0)
                nums[index++] = i;
        }

		BigInteger duplicates = BigInteger.ONE;
		for (int i = 0; i < 10; i++)
			if (hash[i] > 1)
				duplicates = duplicates.multiply(factorial(hash[i]));
		int target = sum / 2, odd = (n + 1) / 2, even = n / 2;
		BigInteger[][][] dp = new BigInteger[odd + 1][even + 1][361];
		return f(odd, even, target, n, nums, dp).divide(duplicates).mod(BigInteger.valueOf(1_000_000_007)).intValue();
	}

	private BigInteger factorial(int n) {
		BigInteger fact = BigInteger.ONE;
		for (; n > 1; n--) fact = fact.multiply(BigInteger.valueOf(n));
		return fact;
	}

	private BigInteger f(int odd, int even, int target, int n, int[] nums, BigInteger[][][] dp) {
		if (target < 0) return BigInteger.ZERO;

		if (odd == 0 && even == 0) {
			if (target == 0) return BigInteger.ONE;
			return BigInteger.ZERO;
		}

		if (dp[odd][even][target] != null) return dp[odd][even][target];

		BigInteger ways = BigInteger.ZERO;
		if (odd > 0)
			ways = ways.add(f(odd - 1, even, target - nums[n - (odd + even)], n, nums, dp).multiply(BigInteger.valueOf(odd)));
		if (even > 0)
			ways = ways.add(f(odd, even - 1, target, n, nums, dp).multiply(BigInteger.valueOf(even)));
	
		return dp[odd][even][target] = ways;
	}
}