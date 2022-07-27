package bit;

public class FindSingleElement {
    public int getSingleElement(int[] nums) {
        // Write your solution here
        int res = 0;
        for(int num : nums) {
            res = res ^ num;
        }
        return res;
      }
}
