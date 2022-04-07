package string;

public class AddBinary {
    public static String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        boolean biggerThanTwo = false;
        StringBuilder result = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int sum = biggerThanTwo ? 1 : 0;
            biggerThanTwo = false;
            if (i >= 0) {
                sum += Character.getNumericValue(a.charAt(i));
                i--;
            }
            if (j >=0) {
                sum += Character.getNumericValue(b.charAt(j));
                j--;
            }
            if (sum >=2) {
                biggerThanTwo = true;
                result.append(sum % 2);
            }else {
                result.append(sum);
            }
        }
        if (biggerThanTwo) {
            result.append('1');
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
    }
}
