package datas;

/**
 * Cette classe définit une durée temporelle. Elle permet la manipulation d'intervalles de temps. Une durée s'exprime en millisecondes.
 *
 *
 */
public class Duree {

    /**
     * La durée s'exprime en millisecondes.
     */
    private long leTemps;

    /**
     * Constructeur avec initialisation en millisecondes.
     *
     * @param millisecondes la durée exprimée en millisecondes
     */
    public Duree(long millisecondes) {
        if (millisecondes >= 0) {
            this.leTemps = millisecondes;
        } else {
            System.out.println("Erreur de Temps");
        }

    }

    /**
     * Constructeur à partir des données heures, minutes, secondes.
     *
     * @param heures   nbre d'heures.
     * @param minutes  nbre de minutes.
     * @param secondes nbre de secondes.
     */
    public Duree(int heures, int minutes, int secondes) {
        if (heures > 0 && minutes > 0 && secondes > 0) {
            long conversion = heures * 3600000 + minutes * 60000 + secondes * 1000;
            this.leTemps = conversion;
        } else {
            System.out.println("Erreur de temps");
        }

    }

    /**
     * Construction par recopie d'une Duree passée en paramètre.
     *
     * @param autreDuree la durée à recopier.
     */
    public Duree(Duree autreDuree) {
        this.leTemps = autreDuree.getLeTemps();
    }


    /**
     * Modificateur qui ajoute une durée à la durée courante.
     *
     * @param autreDuree durée à rajouter.
     */
    public void ajoute(Duree autreDuree) {
        this.leTemps += autreDuree.getLeTemps();
    }

    /**
     * Accesseur qui effectue une comparaison entre la durée courante et une autre durée.
     *
     * @param autreDuree durée à comparer à la durée courante.
     * @return un entier qui prend les valeurs suivantes :
     * <ul>
     *     <li>-1 : si la durée courante est + petite que autreDuree.</li>
     *     <li>0 : si la durée courante est égale à autreDuree.</li>
     *     <li>1 : si la durée courante est + grande que autreDuree.</li>
     * </ul>
     */
    public int compareA(Duree autreDuree) {
        int ret = 0;
        if (this.leTemps > autreDuree.leTemps) {
            ret = 1;
        } else if (this.leTemps < autreDuree.leTemps) {
            ret = -1;
        }
        return ret;
    }

    /**
     * Méthode privée qui effectue un découpage de la durée courante en intervalles (jours, heures, minutes, secondes, millisecondes).
     * La durée courante (leTemps) est analysée pour fabriquer un tableau d'entiers (taille 5) dont chaque élément à la signification suivante :
     * <ul>
     *     <li>ret[0] contient le nbre de jours.</li>
     *     <li>ret[1] contient le nbre d'heures (&lt; 24h).</li>
     *     <li>ret[2] contient le nbre de minutes (&lt; 60min).</li>
     *     <li>ret[3] contient le nbre de secondes (&lt; 60sec).</li>
     *     <li>ret[4] contient le nbre de millisecondes (&lt; 1000millisec).</li>
     * </ul>
     *
     * @return un tableau d'entiers.
     */
    private int[] enJHMS() {
        int[] ret = null;
        if (this.leTemps > 0) {
            ret = new int[5];
            int jour = (int) (this.leTemps / 86400000);
            int reste = (int) (this.leTemps % 86400000);
            int heure = reste / 3600000;
            reste %= 3600000;
            int minute = reste / 60000;
            reste %= 60000;
            int seconde = reste / 1000;
            reste %= 1000;
            int milliseconde = reste;

            ret[0] = jour;
            ret[1] = heure;
            ret[2] = minute;
            ret[3] = seconde;
            ret[4] = milliseconde;

        }
        return ret;
    }

    /**
     * Acceseur qui renvoie sous la forme d'une chaîne de caractères la durée courante.
     *
     * @param mode décide de la forme données à la chaîne de caractère.
     *             La forme de la chaine de caractères dépend du "mode" (caractère passé en paramètre) choisi :
     *             <ul>
     *             <li>si mode == 'J' -> chaîne de caractère de la forme "JJJ jours HH h".</li>
     *             <li>si mode == 'H' -> chaîne de caractère de la forme "HHH:MM:SS".</li>
     *             <li>si mode == 'S' -> chaîne de caractère de la forme "SSS.MMM sec".</li>
     *             <li>si mode == 'M' -> chaîne de caractère de la forme "MMMMMM millisec".</li>
     *             </ul>
     * @return la durée sous la forme d'une chaîne de caractères.
     * La méthode utilise la méthode privée enJHMS() pour extraire dans un tableau d'entiers séparement le nombre de jours,
     * le nombre d'heures, le nombre de minutes, le nombre de secondes et le nombre de millisecondes qui contient la durée courante (leTemps).
     */
    public String enTexte(char mode) {
        String phraseTexte = null;
        int[] tableauTemps = enJHMS();
        int jour = tableauTemps[0];
        int heure = tableauTemps[1];
        int minute = tableauTemps[2];
        int seconde = tableauTemps[3];
        int milliseconde = tableauTemps[4];

        int heureTotale = jour * 24 + heure;
        int secondeTotale = (jour * 24 * 60 * 60) + (heure * 60 * 60) + (minute * 60) + seconde;
        int millisecondeTotale = (jour * 24 * 60 * 60 * 1000) + (heure * 60 * 60 * 1000) + (minute * 60 * 1000) + (seconde * 1000) + milliseconde;

        switch (mode) {
            case 'J':
                phraseTexte = jour + "jours" + heure + "h";
                break;
            case 'H':
                phraseTexte = heureTotale + ":" + minute + ":" + seconde;
                break;
            case 'S':
                phraseTexte = secondeTotale + "." + milliseconde + " sec";
                break;
            case 'M':
                phraseTexte = millisecondeTotale + " millisec";
                break;

            default:
                System.out.println("Erreur de paramètre");
                break;
        }

        return phraseTexte;
    }

    /**
     * Accesseur qui retourne la valeur de la durée courante en millisecondes.
     *
     * @return la durée en millisecondes.
     */
    public long getLeTemps() {

        return this.leTemps;
    }

}