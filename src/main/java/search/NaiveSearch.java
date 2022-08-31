package search;

public class NaiveSearch implements Search {
    @Override
    public boolean search(String s, String pattern) {
        return s.contains(pattern);
    }
}
