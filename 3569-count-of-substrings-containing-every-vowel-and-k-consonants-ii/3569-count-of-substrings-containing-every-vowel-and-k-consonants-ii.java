class Solution {
    public long countOfSubstrings(String word, int k) {
        int i = 0, j = 0, n = word.length();
        long substring = 0;
        int consonant = 0;

        Map<Character, Integer> vowelSet = new HashMap<>();

        int[] nextConst = new int[n];
        int lastConstIndex = n;
        for (int m = n - 1; m >= 0; m--) {
            nextConst[m] = lastConstIndex;

            if (!isVowel(word.charAt(m))) {
                lastConstIndex = m;
            }
        }

        while (j < n) {
            char ch = word.charAt(j);
            if (isVowel(ch)) {
                vowelSet.put(ch, vowelSet.getOrDefault(ch, 0) + 1);
            } else {
                consonant++;
            }

            while (consonant > k) {
                char chi = word.charAt(i);
                if (isVowel(chi)) {
                    vowelSet.put(chi, vowelSet.get(chi) - 1);
                    if (vowelSet.get(chi) == 0) {
                        vowelSet.remove(chi);
                    }
                } else {
                    consonant--;
                }

                i++;
            }

            while (i < n && vowelSet.size() == 5 && consonant == k) {
                int idx = nextConst[j];
                substring += idx - j;

                char chi = word.charAt(i);
                if (isVowel(chi)) {
                    vowelSet.put(chi, vowelSet.get(chi) - 1);
                    if (vowelSet.get(chi) == 0) {
                        vowelSet.remove(chi);
                    }
                } else {
                    consonant--;
                }

                i++;
            }

            j++;
        }

        return substring;
    }

    public boolean isVowel(char ch) {
        return "aeiou".indexOf(ch) != -1;
    }
}