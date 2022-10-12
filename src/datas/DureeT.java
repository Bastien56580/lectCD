package datas;

public class DureeT{
    public  static void main (String[] args){
        //testConstructeur1EtAccesseur();
        //testConstructeur2();
        //	testCompareA();
        testEnTexteA();
    }
    private static void testConstructeur1EtAccesseur(){
        System.out.println("Test constructeur1 cas normal :");
        Duree d1= new Duree(1000);
        long tps= d1.getLeTemps();
        if (tps==1000) {
            System.out.println("Test reussi");
        }
        else {
            System.out.println("Echec du test");
        }

        System.out.println("Test constructeur1 cas d'erreur");
        Duree d2 = new Duree (-10);
        System.out.println("Message d'erreur affiché");
    }
    private static void testConstructeur2(){
        System.out.println("Test constructeur2 cas normal");
        Duree d3 = new Duree (1,2,3);
        long tps = d3.getLeTemps();
        if (tps==3723000) {
            System.out.println("Test reussi");
        }
        else {
            System.out.println("Echec du test");
        }

        System.out.println("Test constructeur2 cas d'erreur");
        Duree d4 = new Duree (1,2,70);
        System.out.println("Message d'erreur affiché");
    }

    private static void testCompareA(){
        System.out.println("Test de la methode compareA");
        System.out.println("Cas normal durée supérieure à 0");
        System.out.println("Initialisation de la durée ");
        Duree d1 = new Duree(2);
        System.out.println("Initialisation de la durée 2");
        Duree d2= new Duree(5);
        System.out.println("test durée courante > autre durée");

        if(d1.compareA(d2)==-1) {
            System.out.println("Test reussi");
        }else {
            System.out.println("Echec");
        }
        System.out.println("---------------");

        System.out.println("test durée courante < autre durée");

        if(d2.compareA(d1)==1) {
            System.out.println("Test reussi");
        }else {
            System.out.println("Echec");
        }

        System.out.println("---------------");

        System.out.println("Initialisation d'une troisème durée");

        Duree d3= new Duree(5);

        System.out.println("test durée courante = autre durée");

        if(d2.compareA(d3)==0) {
            System.out.println("Test reussi");
        }else {
            System.out.println("Echec");
        }
        System.out.println("---------------");

        System.out.println("Initialisation d'une durée négative donc erreur");

        Duree d4= new Duree(-8);
        System.out.println("test durée négative / durée positive");
        System.out.println("appel de la méthode compareA le test donne une erreur");
        d4.compareA(d3);
    }

    private static void testEnTexteA(){
        System.out.println("Test de la methode enTexte");
        Duree duree = new Duree (26, 2, 3);
        System.out.println(duree.enTexte('J'));
        Duree duree1 = new Duree(8, 50, 0);
        System.out.println(duree1.enTexte('H'));
        Duree duree2 = new Duree(50);
        System.out.println(duree2.enTexte('S'));

        // todo ajouter milli et des if pour avoir valeurs attendues

    }

}

