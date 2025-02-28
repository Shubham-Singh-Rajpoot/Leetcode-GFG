class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        int len1 = arr1.length;
        int len2 = arr2.length;
        String lcs = longestCommonSubsequence(str1, str2);
        char[] lcsArr = lcs.toCharArray();
        int lcsLen = lcsArr.length;
        int idx1 = 0;
        int idx2 = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < lcsLen; i++) {
            char currentChar = lcsArr[i];
            StringBuilder temp = new StringBuilder();
            while (idx1 < len1 && arr1[idx1] != currentChar) {
                temp.append(arr1[idx1]);
                idx1++;
            }
            idx1++;
            while (idx2 < len2 && arr2[idx2] != currentChar) {
                temp.append(arr2[idx2]);
                idx2++;
            }
            idx2++;
            temp.append(currentChar);
            result.append(temp);
        }
        while (idx1 < len1) {
            result.append(arr1[idx1]);
            idx1++;
        }
        while (idx2 < len2) {
            result.append(arr2[idx2]);
            idx2++;
        }
        return result.toString();
    }
    String longestCommonSubsequence(String text1, String text2) {
        char[] arr1 = text1.toCharArray();
        char[] arr2 = text2.toCharArray();
        int len1 = arr1.length;
        int len2 = arr2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                if (arr1[i] == arr2[j]) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while (i < len1 && j < len2) {
            if (dp[i][j] > Math.max(dp[i + 1][j], dp[i][j + 1])) {
                sb.append(arr1[i]);
                i++;
                j++;
            } else {
                if (dp[i + 1][j] > dp[i][j + 1]) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        return sb.toString();
    }
}
