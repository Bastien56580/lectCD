package datas;

public class CDT {
    public static void main (String[] args) {
        /*System.out.println("Test constructeur CD");
        testConstruct();

        System.out.println("Test de la methode getDureeTotale");
        testGetDureeTotale(); */
        CD cd = new CD("ws/musique.txt");
    }

    public static void testConstruct() {
        System.out.println("Test cas normal");
        CD cd = new CD("Franz Ferdinand ", "CyberPunk 2077 OST");
        if ((cd.getLInterpreteCD() == "Franz Ferdinand") && (cd.getLeTitreCD() == "CyberPunk 2077 OST")) {
            System.out.println("Test ok");
        } else {
            System.out.println("ECHEC");
        }
    }

    public static void testGetDureeTotale(){
        System.out.println("Test cas normal");

        CD cd5 = new CD("Moultes artistes","Compile Fun");
        CD cd = null;
        Duree d1 = cd.getDureeTotale();
        long t1 = d1.getLeTemps();

        if(t1==1310500){
            System.out.println("Test getDureeTotale() OK");
        }
        else{
            System.out.println("Erreur ! Echec du test !");
        }
    }



}












