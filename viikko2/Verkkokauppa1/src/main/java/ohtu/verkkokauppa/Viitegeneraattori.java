package ohtu.verkkokauppa;

import org.springframework.stereotype.Component;

@Component
public class Viitegeneraattori implements ViitegeneraattoriRaja {

    private int seuraava = 1;

    
    @Override
    public int uusi(){
        return seuraava++;
    }
}
