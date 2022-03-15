package intefeceApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MiPriemeraApp extends JFrame {

    JLabel jLabel;
    JPanel jPanel;
    JButton jButton;


    public MiPriemeraApp(){

        jLabel = new JLabel();
        jPanel = new JPanel();
        jButton =new JButton();

        setSize(700, 500);

        jButton.setText("enviar datos");
        setTitle("mi primera aplicacion");
        setSize(600, 400);

        //definiendo un comportamiento por defecto
        //ejemplo si es cerrar es cerrar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);//por defecto es false

        jPanel.add(jButton);//un elemento
        jPanel.add(jLabel);//un elemento

        add(jPanel);

        //parte de eventos... o comportamiento
        jButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //super.mouseClicked(e); ->no va
                clic(e);
            }

        });
    }
    public static void main(String[] args) {
        //EventQueue.invokeLater();forma
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MiPriemeraApp();
            }
        });
    }

    public void clic(MouseEvent e){
        //clic(e);
        jLabel.setText("Hemos cambiado el texto");
    }
}
