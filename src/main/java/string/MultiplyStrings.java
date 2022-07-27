package string;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        // Write your solution here
        if(num1 == null || num2 == null) return "0";
        if(num1.equals("0") || num2.equals("0")) return "0";
        int n = num1.length();
        int m = num2.length();
        int[] res = new int[n + m];
        for(int i = n - 1; i >= 0; i--) {
            for(int j = m - 1; j >=0; j--) {
                char c1 = num1.charAt(i);
                char c2 = num2.charAt(j);
                int prod = (c1 - '0') * (c2 - '0');
                int temp = res[i + j + 1] + prod;
                res[i + j + 1] = temp % 10;
                res[i + j] = res[i + j] + temp/10;
            }
        }
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for(int num : res) {
            if(num == 0 && !flag) continue;
            sb.append(num);
            flag = true;
        }
        return sb.toString();
    }
}
