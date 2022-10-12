package datas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Un CD est un ensemble de plages musicales. Le CD est caractérisé par un titre, un interprète (ou des interprètes s'il s'agit d'un groupe).
 * Lors de sa création, le CD est vierge. En le gravant, il sera rempli progressivement de morceaux (plages).
 *
 *
 */
public class CD {
    /**
     * Le titre du CD
     */
    private String leTitreCD;

    /**
     * Interprète(s) du CD
     */
    private String lInterpreteCD;

    /**
     * Le tableau contenant toutes les plages du CD
     */
    private java.util.ArrayList<Plage> lesPlages = new ArrayList<>();

    /**
     * Construction d'un CD.
     * Cette construction se fait en 2 temps :
     * <ul>
     *     <li>d'abord il y a création d'un CD vierge</li>
     *     <li>ensuite il sera gravé (ajout de plages) par appel de la méthode privé "graverCD()"</li>
     * </ul>
     *
     * @param leTitreCD     le titre du CD
     * @param lInterpreteCD le(les) interprètes du CD
     */
    public CD(String leTitreCD, String lInterpreteCD) {
        if (!leTitreCD.isEmpty() && !lInterpreteCD.isEmpty()) {
            this.leTitreCD = null;
            this.lInterpreteCD = null;
            graverCD();
        } else {
            System.out.println("Erreur CD non vierge");
        }

    }

    /**
     * Construction d'un CD.
     * Cette construction se fait à partir d'un fichier texte qui cointient toutes les informations :
     * <ul>
     *     <li>le titre et l'interprète du CD</li>
     *     <li>les différentes plages au format TitrePlage / InterprètePlage / X min. / Y sec.</li>
     * </ul>
     * La méthode privé "graverCD(String leFich)" effectue la lecture du fichier texte
     *
     * @param leFich le nom du fichier à lire
     */
    public CD(String leFich) {
        graverCD(leFich);

    }

    /**
     * Accesseur qui renvoie le nombre de plages gravées sur le CD.
     *
     * @return le nombre total de plages
     */
    public int getNbrePlages() {
        return this.lesPlages.size();
    }

    /**
     * Accesseur qui renvoie le titre du CD
     *
     * @return le titre du CD
     */
    public String getLeTitreCD() {
        return this.leTitreCD;
    }

    /**
     * Accesseur qui renvoie le(les) interprètes du CD
     *
     * @return le(les) interprètes
     */
    public String getlInterpreteCD() {
        return this.lInterpreteCD;
    }

    /**
     * Accesseur qui calcule et renvoie la durée totale du CD
     *
     * @return la durée totale
     */
    public Duree getDureeTotale() {
        Duree dureeTotale = new Duree(0);
        if (!this.lesPlages.isEmpty()) {

            for (Plage plage : this.lesPlages) {
                dureeTotale.ajoute(plage.getLaDuree());
            }
        }
        return dureeTotale;
    }

    /**
     * Accesseur qui renvoie la plage n°index du CD.
     * !! La première plage du CD est à l'index = 1
     *
     * @param index le numéro de la plage à renvoyer
     * @return la plage qui se trouve à l'emplacement (index-1) dans le tableau des plages
     */
    public Plage getUnePlage(int index) {
        //TODO Check si index inférieur ou égal à mon nombre de plage
        return this.lesPlages.get(index-1);
    }

    /**
     * Méthode privée qui grave le CD. Un certain nombre de plages sont ajoutées au CD. Dans cette version simplifiée, les plages sont créees et
     * ajoutées "à la main" au CD
     */
    private void graverCD() {
        Plage p1 = new Plage(new Duree(3,20,54),"Sleeping on a chair","Yasumu");
        this.lesPlages.add(p1);
        Plage p2 = new Plage(new Duree(151),"passing by", "Epektase");
        this.lesPlages.add(p2);
        Plage p3 = new Plage(new Duree(0,23,33),"Cracker Island", "Gorillaz");
        this.lesPlages.add(p3);
        Plage p4 = new Plage(new Duree(313000),"Slide x2", "Sopico");
        this.lesPlages.add(p4);

    }

    /**
     * Méthode privé qui grave le CD à partir d'un fichier. On donne un titre et un interprète au CD de même qu'une liste de plage. Les
     * informations sont lues à partir d'un fichier texte
     *
     * @param leFich le nom du fichier du texte à lire
     */
    private void graverCD(String leFich) {
        //TODO

    }

}
