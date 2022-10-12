package datas;

public class PlageT {
    public static void main(String[] args) {
        //Test constructeur
        System.out.println("Test du constructeur");
        testConstruct1();

        System.out.println("Test toString");
    }

    private static void testConstruct1() {
        System.out.println("Test cas normal constructeur");
        Duree duree = new Duree(300);
        Plage plage = new Plage(duree, "This is fffire", "Franz Ferdinand");
        ;

        if ((plage.getLaDuree().getLeTemps() == 300) && (plage.getLeTitre() == "This is fffire")
                && (plage.getlInterprete() == "Franz Ferdinand")) {
            System.out.println("Test ok !!");
        } else {
            System.out.println("Echec du test !!");
        }


    }
    private static void testToString () {
        System.out.println("Test cas méthode ToString");
        Duree duree5 = new Duree(10000);
        Plage plage5 = new Plage(duree5, "This is ffffire", "Franz Ferdinand");
        String info = plage5.toString();

        if (info.equals("This is ffffire - Franz Ferdinand")) {
            System.out.println("OK");
        } else {
            System.out.println("Test raté");
        }
    }
}