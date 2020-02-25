package is.hi.hpv501.sack.SackOverflow.Wrappers.Requests;

public class SearchRequestWrapper {
    private String search;

    public SearchRequestWrapper(){}

    public SearchRequestWrapper(String search) {
        this.search = search;
    }


    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
