
package ohtu;

public class Player {
    private String name;
    private String nationality;
    private String assists;
    private String goals;
    private String penalties;
    private String team;
    private String games;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " ("  + team + "): goals: " + goals + ", assists: " + assists +
        ", games: " + games;
    }
      
}