package ihm;

import datas.LecteurCD;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;
import java.awt.*;

public class FrameLectCD extends JFrame {
    //All widget in attribute
    private JButton btnChargerCD = new JButton("ChargerCD - ON");
    private JLabel labTempsTotal = new JLabel("Temps Total");
    private JLabel labNbPlages = new JLabel("Nombre de Plages");
    private JTextField textTempsTotalAffiche = new JTextField();
    private JTextField textNbPlageAffiche = new JTextField();
    private JTextField textNumPlage = new JTextField();
    private JTextField textNomPlage = new JTextField();
    private JTextField textDureePlage = new JTextField();
    private JButton butStop = new JButton("STOP");
    private JButton butPlay = new JButton("PLAY");
    private JButton butNext = new JButton("NEXT");
    private JButton butPrevious = new JButton("PREVIOUS");
    private LecteurCD leLecteur;
    private ImageIcon image;
    private JLabel jImage;

    public FrameLectCD(String titre) {
        super(titre);
        this.leLecteur = new LecteurCD();
        //addListeners();
        setSize(600, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        miseEnPlaceDecor();

    }
    private void miseEnPlaceDecor() {
        this.setLayout(new GridLayout(1, 1));
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.add(premierComposant());
        panel.add(deuxiemeComposant());
        panel.add(troisiemeComposant());
        this.add(panel);

    }

    private JPanel troisiemeComposant() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 4));
        panel.add(this.butStop);
        panel.add(this.butPlay);
        panel.add(this.butNext);
        panel.add(this.butPrevious);

        return panel;
    }

    private JPanel deuxiemeComposant() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(this.textNumPlage, BorderLayout.WEST);
        textNumPlage.setPreferredSize(new Dimension(50, 100));
        panel.add(this.textNomPlage, BorderLayout.CENTER);
        textNomPlage.setHorizontalAlignment(JTextField.CENTER);
        panel.add(this.textDureePlage, BorderLayout.EAST);
        textDureePlage.setPreferredSize(new Dimension(50, 100));
        return panel;
    }


    private JPanel premierComposant() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        panel.add(this.btnChargerCD);
        panel.add(new JLabel(""));
        panel.add(this.labTempsTotal);
        panel.add(this.textDureePlage);
        panel.add(this.labNbPlages);
        panel.add(this.textNumPlage);
        panel.add(this.textTempsTotalAffiche);
        panel.add(this.textNbPlageAffiche);

        return panel;
    }

    public LecteurCD getLeLecteur() {
        return this.leLecteur;
    }

    public JButton getButPlay() {
        return butPlay;
    }

    public JButton getButNext() {
        return butNext;
    }

    public JButton getBtnChargerCD() {
        return btnChargerCD;
    }

    public JButton getButStop() {
        return butStop;
    }

    public JButton getButPrevious() {
        return butPrevious;
    }

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        FrameLectCD maf = new FrameLectCD("Lecteur CD");
    }

}