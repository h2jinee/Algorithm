class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder str = new StringBuilder();

        int maxLength = Math.max(word1.length(), word2.length());
        int minLength = Math.min(word1.length(), word2.length());
        String maxWord = word1.length() >= word2.length() ? word1 : word2;
        int subtraction = maxLength - minLength;

        for (int i = 0; i < (minLength * 2); i++) {
            if ((i % 2) != 0) {
                str.append(word2.charAt(i / 2));
            } else {
                str.append(word1.charAt(i / 2));
            }
        }
        str.append(maxWord.substring(minLength, maxLength));
        return str.toString();
    }
}