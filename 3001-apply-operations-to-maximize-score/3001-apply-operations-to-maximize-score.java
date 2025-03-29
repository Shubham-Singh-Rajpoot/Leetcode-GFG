class Solution {
     static long mod = 1000000007L;
    static int[] divisibleByNearestPrime = new int[100001];
    static boolean[] isPrime = new boolean[100001];
    static List<Integer> primes;

    static {
        for (int i = 0; i < 100001; i++) divisibleByNearestPrime[i] = i;
        primes = new ArrayList<>();
        for (int i = 2; i * i < 100001; i++) {
            if (!isPrime[i]) {
                divisibleByNearestPrime[i] = i;
                for (int j = i * i; j < 100001; j += i) {
                    isPrime[j] = true;
                    divisibleByNearestPrime[j] = i;
                }
            }
        }

        for (int i = 2; i < 100001; i++) {
            if (!isPrime[i]) primes.add(i);
        }
    }

    static int primeMultiples(int n) {
        int count = 0;
        while (n != 1) {
            int factor = divisibleByNearestPrime[n];
            count++;
            while (n % factor == 0) n /= factor;
        }
        return count;
    }

    static public int maximumScore(List<Integer> nums, int K) {
        int n = nums.size();
        long k = K;
        long[] primeMultiplesArr = new long[n];
        int[] calculatedPrev = new int[100001];
        for (int i = 0; i < n; i++) {
            int num = nums.get(i);
            int x;
            if (calculatedPrev[num] == 0) {
                calculatedPrev[num] = primeMultiples(num);;
            }
            x = calculatedPrev[num];
            primeMultiplesArr[i] = x;
        }

        long[] monotonicArray = new long[n];
        long[] monotonicArray2 = new long[n];
        Stack<long[]> st = new Stack<>();
        int stackSize = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (stackSize > 0 && st.peek()[0] <= primeMultiplesArr[i]) {
                st.pop();
                stackSize--;
            }
            if (stackSize == 0) monotonicArray[i] = n - i;
            else monotonicArray[i] = st.peek()[1] - i;
            st.push(new long[] { primeMultiplesArr[i], i });
            stackSize++;
        }
        st.clear();
        stackSize = 0;
        for (int i = 0; i < n; i++) {
            while (stackSize > 0 && st.peek()[0] < primeMultiplesArr[i]) {
                st.pop();
                stackSize--;
            }
            if (stackSize == 0) monotonicArray2[i] = i;
            else monotonicArray2[i] = i - st.peek()[1] - 1;

            st.push(new long[] { primeMultiplesArr[i], i });
            stackSize++;

        }
        for (int i = 0; i < n; i++)
            monotonicArray[i] += monotonicArray2[i] * monotonicArray[i];

        long[][] arr = new long[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = nums.get(i);
            arr[i][1] = monotonicArray[i];
        }

        Arrays.sort(arr, (a, b) -> {
            if (b[0] > a[0]) return 1;
            return -1;
        });
        long ans = 1L;
        for (int i = 0; i < n; i++) {
            long data = arr[i][0], times = arr[i][1];
            if (times <= k) {
                ans = (ans * powMod(data, times, mod)) % mod;
                k -= times;
            } else {
                ans = (ans * powMod(data, k, mod)) % mod;
                break;
            }
        }
        return (int) (ans);
    }

    static long powMod(long base, long exp, long mod) {
        long ans = 1;
        long power = base % mod;
        while (exp > 0) {
            if ((exp & 1) == 1)ans = (ans * power) % mod;
            exp >>= 1;
            power = (power * power) % mod;
        }
        return ans;
    }
}