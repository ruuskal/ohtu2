
package ohtu.verkkokauppa;

import java.util.ArrayList;

public interface KirjanpitoRaja {

    ArrayList<String> getTapahtumat();

    void lisaaTapahtuma(String tapahtuma);
    
}
