package stack;

import java.util.LinkedList;

public class SortWith2Stacks {
    public void sort(LinkedList<Integer> s1) {
        LinkedList<Integer> s2 = new LinkedList<Integer>();
        // Write your solution here.
        while (!s1.isEmpty()) {
            int cur = s1.pop();
            while (!s2.isEmpty() && s2.peek() > cur) {
                s1.push(s2.pop());
            }
            s2.push(cur);
        }
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }
}
