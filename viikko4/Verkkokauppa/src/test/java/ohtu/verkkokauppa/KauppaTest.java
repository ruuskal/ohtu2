package ohtu.verkkokauppa;

import org.junit.Before;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.*;
import org.junit.Test;
import static org.mockito.Mockito.*;


public class KauppaTest {
    Pankki pankki;
    Viitegeneraattori viite;
    Varasto varasto;
    Kauppa k;
    
    @Before
    public void setUp() {
        pankki = mock(Pankki.class);
        viite = mock(Viitegeneraattori.class);
        varasto = mock(Varasto.class);
        
        k = new Kauppa(varasto, pankki, viite);
        
        when(viite.uusi()).thenReturn(42);
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5)); 
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "piimä", 6));
        when(varasto.haeTuote(3)).thenReturn(new Tuote(3, "jugurtti", 7));
    }
    
    @Test
    public void listaanTuoteJotaOnJaTuoteJokaOnLoppuMetodiaTilisiirtoKutsutaan() {
        when(varasto.saldo(2)).thenReturn(0);
        when(varasto.saldo(3)).thenReturn(10);
        
        k.aloitaAsiointi();
        k.lisaaKoriin(2);
        k.lisaaKoriin(3);
        k.tilimaksu("pekka", "12345");
        
        verify(pankki).tilisiirto(eq("pekka"), anyInt(), eq("12345"), anyString(), eq(7));
    }
    
    @Test
    public void kahdenSamanTuotteenOstamisenJalkeenMetodiaTilisiirtoKutsutaan() {
        when(varasto.saldo(anyInt())).thenReturn(10);
        
        k.aloitaAsiointi();
        k.lisaaKoriin(2);
        k.lisaaKoriin(2);
        k.tilimaksu("pekka", "12345");
        
        verify(pankki).tilisiirto(eq("pekka"), anyInt(), eq("12345"), anyString(), eq(12));
    }
    
    @Test
    public void kahdenEriTuotteenOstamisenJalkeenMetodiaTilisiirtoKutsutaan() {
        when(varasto.saldo(anyInt())).thenReturn(10);
        
        k.aloitaAsiointi();
        k.lisaaKoriin(2);
        k.lisaaKoriin(3);
        k.tilimaksu("pekka", "12345");
        
        verify(pankki).tilisiirto(eq("pekka"), anyInt(), eq("12345"), anyString(), eq(13));
    }
    
    @Test
    public void ostoksenPaaytyttyaPankinMetodiaTilisiirtoKutsutaan() {
        when(varasto.saldo(1)).thenReturn(10);           

        // tehdään ostokset
        k.aloitaAsiointi();
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.tilimaksu("pekka", "12345");
       
        // sitten suoritetaan varmistus, että pankin metodia tilisiirto on kutsuttu
        verify(pankki).tilisiirto(eq("pekka"), anyInt(), eq("12345"), anyString(), eq(5));   
        
    }
    
}
