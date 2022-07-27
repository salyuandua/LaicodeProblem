package math;

public class IntegerToEnglish {
    public static void main(String[] args) {
        int src = 123456089;
        final String num[] = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
        final String unit[] = {"", "十", "百", "千", "万", "十", "百", "千", "亿", "十", "百", "千"};
        String dst = "";
        int count = 0;
        while(src > 0) {
            dst = (num[src % 10] + unit[count]) + dst;
            src = src / 10;
            count++;
        }
        System.out.println(dst);
        //	return dst.replaceAll("零[千百十]", "零").replaceAll("零+万", "万")
		//	.replaceAll("零+亿", "亿").replaceAll("亿万", "亿零")
		//	.replaceAll("零+", "零").replaceAll("零$", "");
    }
}
