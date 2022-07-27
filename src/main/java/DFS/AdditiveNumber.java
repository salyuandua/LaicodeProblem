package DFS;

public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        for(int i = 1; i < num.length() / 2; i++) {
            if(num.charAt(0) == '0' && i > 1){
                return false;
            }
            Long first = Long.valueOf(num.substring(0, i));
            for(int j = 1; num.length() - i - j < Math.max(i, j); j++) {
                if(num.charAt(i) == '0' && j > 1) {
                    break;
                }
                Long second = Long.valueOf(num.substring(i, i + j));
                if(helper(first, second, i + j, num)) {
                    return true;
                }
            }
        }
        return false;
    }


    private boolean helper(Long first, Long second, int start, String num) {
        if(start >= num.length()) {
            return true;
        }
        Long sum = first + second;
        return num.startsWith(String.valueOf(sum), start)
                && helper(second, sum, start + String.valueOf(sum).length(), num);
    }
}
