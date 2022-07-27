package bit;

public class AllUniqueCharactersI {
    public boolean allUnique(String word) {
        // Write your solution here
        for(int i = word.length() - 1; i >= 0; i--) {
            if(word.indexOf(word.charAt(i)) != i) {
                return false;
            }
        }
        return true;
      }
}
