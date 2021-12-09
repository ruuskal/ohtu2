/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import statistics.Player;

public class HasFewerThan implements Matcher {
    
    private Matcher not;
    
    public HasFewerThan(int value, String category) {
        this.not = new Not(new HasAtLeast(value, category));
    }
    
    public boolean matches(Player p) {
        if (this.not.matches(p) == true) {
            return true;
        }
        return false;
    }
    
}
