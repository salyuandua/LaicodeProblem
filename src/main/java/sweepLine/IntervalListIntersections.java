package sweepLine;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersections {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0;
        int j = 0;
        List<int[]> result = new ArrayList<>();
        while (i < firstList.length && j < secondList.length) {
            int firstLeft = firstList[i][0];
            int firstRight = firstList[i][1];
            int secondLeft = secondList[j][0];
            int secondRight = secondList[j][1];
            //if b2 >= a1 and a2 >= b1:
            if (secondRight >= firstLeft && firstRight >= secondLeft) {
                result.add(new int[]{Math.max(firstLeft, secondLeft), Math.min(firstRight, secondRight)});
            }
            if (secondRight < firstRight) {
                j++;
            }else {
                i++;
            }

        }
        int[][] finalResult = new int[result.size()][2];
        for (int k = 0; k < result.size(); k++) {
            finalResult[k] = result.get(k);
        }
        return finalResult;
    }
}
