package stack;

import java.util.List;
import java.util.Stack;

public class ExecutionTimeofFunctions {
    public int[] executeTime(int n, List<String> logs) {
        // Write your solution here
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        int prevTime = 0;
        for (String log : logs) {
            String[] logData = log.split(":");
            int id = Integer.parseInt(logData[0]);
            String status = logData[1];
            int time = Integer.parseInt(logData[2]);
            if ("start".equals(status)) {
                if (!stack.isEmpty()) {
                    result[stack.peek()] += (time - prevTime);
                }
                stack.push(id);
                prevTime = time;
            }else {
                int idx = stack.pop();
                result[idx] += (time - prevTime + 1);
                prevTime = time + 1;
            }
        }
        return result;

    }
}
