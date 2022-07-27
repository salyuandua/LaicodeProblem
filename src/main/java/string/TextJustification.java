package string;

import java.util.ArrayList;

public class TextJustification {
    public ArrayList<String> fullJustify(String[] words, int L) {
        //Input your code here
        ArrayList<String> res = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        for(String word : words) {
            if(cur.length() + word.length() + 1 > 16) {
                res.add(cur.toString());
                continue;
            }
            if(cur.length() == 0) {
                cur.append(word);
            }else{
                cur.append(" " + word);
            }
            
        }

        return null;
      }
}
