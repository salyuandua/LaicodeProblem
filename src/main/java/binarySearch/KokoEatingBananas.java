package binarySearch;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        // Write your code here
        int left = 0;
        int right = 1;
        for(int pile : piles) {
            right = Math.max(right, pile);
        }

        while(left < right) {
            int mid = left + (right - left) / 2;
            if(canEatAll(piles, h, mid)) {
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;

    }

    private boolean canEatAll(int[] piles, int maxHours, int speed) {
        int hour = 0;
        for(int pile : piles) {
            hour += (pile / speed);
            if(pile % speed > 0) hour++;
        }
        return hour <= maxHours;
    }
}
