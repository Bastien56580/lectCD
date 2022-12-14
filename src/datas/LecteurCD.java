package datas;

/**
 * La classe lecteurCD simule de manière simplifiée les fonctionnalités d'un lecteur CDk à savoir :
 * <ul>
 *     <li>Le chargement d'un CD dans le lecteur</li>
 *     <li>La lecture du CD depuis le début (touche PLAY)</li>
 *     <li>L'arrêt de la lecture (touche STOP)</li>
 *     <li>Le passage au morceau suivant (touche NEXT)</li>
 *     <li>Le passage au morceau précédent (touche PREVIOUS)</li>
 * </ul>
 *
 *
 */
public class LecteurCD {

    /**
     * Le lecteur renferme-t-il un CD ?
     */
    private boolean estCharge;

    /**
     * Le CD courant (qui se trouve dans le lecteur)
     */
    private CD leCdCourant;

    /**
     * L'index de la plage courante (1 &lt;= index &lt;= nbrePlages ou zéro si aucun CD chargé)
     */
    private int indexPlage;

    /**
     * Construction d'un lecteur de CD. A l'issue de la construction, il n'y a aucun CD dans le lecteur (leCdCourant=null).
     * Le chargement d'un CD se fait à l'aide de la méthode "chargerUnCD()"
     */
    public LecteurCD() {
        this.estCharge = false;
        this.leCdCourant = null;
        this.indexPlage = 0;

    }

    /**
     * Accesseur qui renvoie le temps total du CD chargé sous forme d'une chaîne de caractères.
     *
     * @return le temps total du CD
     */
    public String getTempsTotal() {
        String tempsTotal = null;
        if (this.estCharge) {
            tempsTotal = this.leCdCourant.getDureeTotale().enTexte('H');
        } else {
            System.out.println("Erreur ! le lecteur n'est pas chargé !");
        }
        return tempsTotal;
    }

    /**
     * Accesseur qui renvoie le nombre de plages que contient le CD
     *
     * @return le nombre de plages (-1 si aucun CD chargé)
     */
    public int getNombrePlages() {
        int nombrePlages = 0;
        if (this.estCharge) {
            nombrePlages = this.leCdCourant.getNbrePlages();
        } else {
            System.out.println("Erreur aucune plage sur le CD");
        }
        return nombrePlages;
    }

    /**
     * Accesseur qui renvoie l'index de la plage du CD en cours de lecture. Cet index est compris entre 1 et nbrePlages
     *
     * @return l'index de la plage courante (zéro si aucun CD chargé)
     */
    public int getIndexCourant() {
        int indexPlage = 0;

        if (this.estCharge) {
            indexPlage = this.indexPlage;
        } else {
            System.out.println("Erreur le lecteur n'est pas encore chargé");
        }

        return indexPlage;
    }

    /**
     * Accesseur qui renvoie la plage en cours de lecture.
     *
     * @return la plage courante (null si aucun CD chargé)
     */
    public Plage getPlageCourante() {
        Plage plageEnCours = null;
        if (this.estCharge) {
            if (this.indexPlage > 0) {
                plageEnCours = this.leCdCourant.getUnePlage(this.indexPlage);
            } else {
                System.out.println("Le CD n'est pas lancé");
            }
        } else {
            System.out.println("Le lecteur n'est pas chargé");
        }
        return plageEnCours;
    }


    /**
     * Accesseur qui renvoie vrai si le lecteur contient un CD
     *
     * @return vrai si il y a un CD dans le lecteur
     */
    public boolean estCharge() {
        return this.estCharge;

    }

    /**
     * Accesseur qui renvoie le CD chargé dans le lecteur ou null si aucun CD chargé
     *
     * @return le CD courant ou null si aucun CD dans le lecteur
     */
    public CD getCD() {
        CD cd = null;
        if (this.estCharge) {
            cd = this.leCdCourant;
        } else {
            System.out.println("Erreur le CD n'est pas chargé");
        }
        return cd;

    }

    /**
     * Modification qui force le lecture à se décharger du CD qu'il contient. Le booléen estCharge devient faux et leCdCourant devient null
     */
    public void setDecharger() {
        if (this.estCharge) {
            this.leCdCourant = null;
            this.estCharge = false;
            this.indexPlage = 0;
        } else {
            System.out.println("Erreur le disque n'est pas correctement déchargé");
        }
    }

    /**
     * Modificateur dont le rôle est de charger un CD dans le lecteur. Pour simplifier, il s'agira toujours du même CD pour cette version de la
     * méthode. La méthode doit construire le CD et mettre le booléen à vrai.
     */
    public void chargerUnCD() {
        if (!this.estCharge) {
            this.leCdCourant = new CD("Etoile", "MLP");
            this.estCharge = true;
        } else {
            System.out.println("Erreur CD déjà chargé");
        }

    }

    /**
     * Modificateur dont le rôle est de charger un CD dans le lecteur. Pour cette version, le CD est construit à partir d'un fichier texte.
     *
     * @param leFich le nom du fichier texte à lire
     */
    public void chargerUnCD(String leFich) {
        if (!this.estCharge) {
            this.leCdCourant = new CD(leFich);
            this.estCharge = true;
        } else {
            System.out.println("Le lecteur est déjà chargé");
        }
    }

    /**
     * Modificateur qui simule la touche STOP. Cela a pour conséquence de simplement remettre l'index des plages sur 1. (Et éventuellement
     * d'arrêter le timer de lecture de plages en cours). Il ne se passe rien si aucun CD est chargé
     */
    public void stop() {
        if (this.estCharge) {
            if (this.indexPlage > 0) {
                this.indexPlage = 1;
            } else {
                System.out.println("Erreur CD non lancé");
            }
        }

    }

    /**
     * Modificateur qui simule la touche PLAY. Cela a pour conséquence de simplement remettre l'index des plages sur 1.(Et éventuellement de
     * démarrer le timer de lecture de la 1ère plage). Il ne se passe rien si aucun CD chargé
     */
    public void play() {
        if (this.estCharge) {
            if (this.indexPlage == 0) {
                this.indexPlage = 1;
            }

        } else {
            System.out.println("Erreur CD non chargé!");
        }
    }

    /**
     * Modificateur qui simule la touche NEXT. Cela a pour conséquence de simplement incrémenter l'index des plages. (Et éventuellement de démarrer
     * le timer de lecture de la plage suivante). Il ne se passe rien si aucun CD chargé
     */
    public void next() {
        if (this.estCharge) {
            if (this.indexPlage > 0) {
                if (this.indexPlage == this.getNombrePlages()) {
                    this.indexPlage = 1;
                } else {
                    this.indexPlage += 1;
                }
            } else {
                System.out.println("Le CD n'est pas lancé");
            }
        } else {
            System.out.println("Le lecteur n'est pas chargé");
        }
    }

    /**
     * Modificateur qui simule la touche PREVIOUS. Cela a pour conséquence de simplement décrémenter l'index des plages. (Et éventuellement de
     * démarrer le timer de lecture de la plage précédente). Il ne se passe rien si aucun CD chargé
     */
    public void previous() {
        if (this.estCharge) {
            if (this.indexPlage > 0) {
                if (this.indexPlage == 1) {
                    this.indexPlage = this.getNombrePlages();
                } else {
                    this.indexPlage -= 1;
                }
            } else {
                System.out.println("Le CD n'est pas lancé");
            }
        } else {
            System.out.println("Le lecteur n'est pas chargé");
        }
    }
}