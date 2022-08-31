package search;

public class Finder {

    private Search method;

    public void setMethod(Search method) {
        this.method = method;
    }

    public boolean find(String s, String pattern) {
        return method.search(s, pattern);
    }
}
