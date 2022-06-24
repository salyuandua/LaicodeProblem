package binarySearch;

public class FirstBadVersion {
    public int findFirstBadVersion(int n) {
        // write your solution here
        int left = 1;
        int right = n;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(isBadVersion(mid)) {
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;


      }
    public boolean isBadVersion(int n) {
        return true;
    }
}
