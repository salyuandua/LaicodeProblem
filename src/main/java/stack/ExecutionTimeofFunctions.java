package stack;

import java.util.Arrays;
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


    public int[] executeTime1(int n, List<String> logs) {
        int[] res = new int[n];
        int timeCost = 0;
        Stack<String[]> stack = new Stack<>();
        for(String log : logs) {
            String[] logStrings = log.split(":");
            if(logStrings[1].equals("start")) {
                stack.push(logStrings);
                continue;
            }
            String[] prevLogStrings = stack.pop();
            int timeDiff = Integer.parseInt(logStrings[2]) - Integer.parseInt(prevLogStrings[2]);
            res[Integer.parseInt(logStrings[0])] = timeDiff - timeCost;
            timeCost += res[Integer.parseInt(logStrings[0])];
        }
        return res;

    }

    public static void main(String[] args) {
        ExecutionTimeofFunctions timeofFunctions = new ExecutionTimeofFunctions();
        System.out.println(Arrays.toString(timeofFunctions.executeTime(3, Arrays.asList("0:start:0","1:start:2","1:end:5","2:start:6","2:end:6", "0:end:7"))));
    }
}
