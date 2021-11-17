
package ohtu;

public class Player {
    private String name;
    private String nationality;
    private int assists;
    private int goals;
    private String penalties;
    private String team;
    private String games;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isFinn() {
        if (nationality.equals("FIN")) {
            return true;
        }
        return false;
    }

    public int getGoals() {
        return goals;
    }

    public int getAssists() {
        return assists;
    }

    public int getPoints() {
        return goals + assists;
    }


    @Override
    public String toString() {
        return name + " ("  + team + "): goals: " + goals + ", assists: " + assists +
        ", games: " + games;
    }
      
}