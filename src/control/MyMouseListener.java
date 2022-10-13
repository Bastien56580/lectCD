package control;

import datas.Duree;
import ihm.FrameLectCD;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyMouseListener implements ActionListener {

    private final FrameLectCD frameLectCD;

    private final Duree duree;


    public MyMouseListener(FrameLectCD frameLectCD, Duree duree) {
        this.frameLectCD = frameLectCD;
        this.duree = duree;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}


}
