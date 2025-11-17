class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        boolean answer = false;

        for (int i = 0; i < flowerbed.length - 1; i++) {
            if (i == flowerbed.length - 2) {
                if (flowerbed[i] == 0 && flowerbed[i+1] == 0) {
                    flowerbed[i+1] = 1;
                    n -= 1;
                }
                break;
            }

            if (i == 0) {
                if (flowerbed[i] == 0 && flowerbed[i+1] == 0) {
                    flowerbed[i] = 1;
                    n -= 1;
                }
            } else {
                if (flowerbed[i-1] == 0 && flowerbed[i] == 0 && flowerbed[i+1] == 0) {
                    flowerbed[i] = 1;
                    n -= 1;
                }
            }
        }

        if (flowerbed.length == 1 && flowerbed[0] == 0) answer = true;
        if (n <= 0) answer = true;

        return answer;
    }
}