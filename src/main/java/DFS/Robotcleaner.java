package DFS;

import pojo.Robot;

import java.util.HashSet;
import java.util.Set;

public class Robotcleaner {

    public void cleanRoom(Robot robot) {
        Set<String> set = new HashSet<>();
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,-1},{0,1}};
        helper(robot, 0, 0, 0, set, dirs);
    }

    private void helper(Robot robot, int i, int j, int dir, Set<String> set, int[][] dirs) {
        set.add(i + "->" + j);
        robot.clean();
        for (int k = 0; k < dirs.length; k++) {
            int newDir = (dir + k) % 4;
            int newi = i + dirs[k][0];
            int newj = j + dirs[k][1];
            if (!set.contains(newi + "->" + newj) && robot.move()) {
                helper(robot, newi, newj, newDir, set, dirs);
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight();
        }
    }
}
