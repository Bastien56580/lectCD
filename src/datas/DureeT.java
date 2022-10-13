package datas;

public class DureeT {
    public static void main(String[] args) {
        System.out.println("Test ajoute");
        testAjoute();

        System.out.println("Test durée enTexte (h) ");
        enTexte();
    }

    private static void testAjoute() {
        System.out.println("Test de cas normal pour ajoute");
        Duree d1 = new Duree(1, 2, 3);
        Duree d2 = new Duree(4, 5, 6);
        long dureeTotale = d1.getLeTemps() + d2.getLeTemps();
        d1.ajoute(d2);
        if (d1.getLeTemps() == dureeTotale) {
            System.out.println("test ok");

        } else {
            System.out.println("echec du test");
        }

    }


    private static void enTexte() {
        System.out.println("Test cas normal pour enTexte (h)");
        Duree duree = new Duree(5, 26, 56);
        String str = "5:26:56";
        if (duree.enTexte('H').equals(str)) {
            System.out.println("test ok");
        } else {
            System.out.println("echec test");
        }
        System.out.println(duree.enTexte('H'));
        System.out.println(str);

        System.out.println("Test cas 0 heures (h)");
        Duree duree2 = new Duree(0, 2, 45);
        String str2 = "0:2:45";
        System.out.println(str2);
        if (duree2.enTexte('H').equals((str2))) {
            System.out.println("test ok2");
        } else {
            System.out.println("Echec test2");
        }

        System.out.println("Test cas 0 minutes");
        Duree duree3 = new Duree(2,0,45);
        String str3 = "2:0:45";
        System.out.println(str3);
        if(duree3.enTexte('H').equals(str3)){
            System.out.println("test ok 3");
        }else {
            System.out.println("Echec test 3");
        }

        System.out.println("Test cas 0 secondes");
        Duree duree4 = new Duree(2,45,0);
        String str4 = "2:45:0";
        System.out.println(str4);
        if(duree4.enTexte('H').equals(str4)){
            System.out.println("test ok 4");
        }else {
            System.out.println("Echec test 4");
        }
    }
}

