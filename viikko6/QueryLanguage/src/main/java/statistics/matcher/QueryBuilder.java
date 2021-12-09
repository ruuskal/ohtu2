package statistics.matcher;

import java.util.ArrayList;
import statistics.Player;

public class QueryBuilder {
    Matcher m;
    
    public QueryBuilder() {
       this.m = new All();
    }
    
    public QueryBuilder(Matcher m) {
        this.m = m;
    }
    
    public QueryBuilder playsIn(String team) {
        QueryBuilder  q = new QueryBuilder(new And(this.m, new PlaysIn(team)));
        return q;
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        QueryBuilder q = new QueryBuilder(new And(this.m, new HasAtLeast(value, category)));
        return q;
    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
        QueryBuilder q = new QueryBuilder(new And(this.m, new HasFewerThan(value, category)));
        return q;
    }
    

    public Matcher build() {

        return this.m;
    }



}
