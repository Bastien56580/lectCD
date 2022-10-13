package datas;

public class PlageT {
    public static void main(String[] args) {
        //Test constructeur
        System.out.println("Test du constructeur");
        testConstruct1();

        System.out.println("Test toString");
        testToString();
    }

    private static void testConstruct1() {
        System.out.println("Test cas normal constructeur");
        Duree duree = new Duree(300);
        Plage plage = new Plage(duree, "This is fffire", "Franz Ferdinand");


        if ((plage.getLaDuree().getLeTemps() == 300) && (plage.getLeTitre() == "This is fffire")
                && (plage.getlInterprete() == "Franz Ferdinand")) {
            System.out.println("Test ok !!");
        } else {
            System.out.println("Echec du test !!");
        }


    }

    private static void testToString() {
        System.out.println("Test cas méthode ToString");
        Duree duree = new Duree(1);
        Plage plage = new Plage(duree, "This is ffffire", "Franz Ferdinand");
        String info = plage.toString();

        System.out.println("info = " + info);
        System.out.println("This is ffffire - Franz Ferdinand" + duree.enTexte('S'));
        if (info.equals("This is ffffire - Franz Ferdinand - " + duree.enTexte('S'))) {
            System.out.println("OK");
        } else {
            System.out.println("Test raté");
        }
    }
}