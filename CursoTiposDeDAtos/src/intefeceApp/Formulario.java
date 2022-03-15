package intefeceApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Formulario {
    //elementos
    JFrame jFrame;//es el contenedor o ventana
    JPanel panel, panelb;//utilizamos para ordenar los elementos
    JLabel userlaber, passwordlabel;
    JTextField usertexfield;//campo de texto
    JPasswordField jPasswordField;
    JButton button;

    public Formulario(){
        // el elemento frame es el marco... intrioducimos objectos con el panel para darle forma
        jFrame = new JFrame("Mi ventana");
        jFrame.setSize(400,150);
        userlaber = new JLabel("usuario");
        usertexfield = new JTextField(15);
        panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setSize(100,100);
        //agregamos sus elementos
        panel.add(userlaber,BorderLayout.WEST);
        panel.add(usertexfield, BorderLayout.CENTER);

        passwordlabel = new JLabel("password");
        jPasswordField = new JPasswordField(15);
        panelb = new JPanel();
        panelb.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelb.add(passwordlabel, BorderLayout.WEST);
        panelb.add(jPasswordField, BorderLayout.CENTER);

        button= new JButton("enviar");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //una manera antes
               JOptionPane.showMessageDialog(jFrame, jPasswordField.getText());
               //manera ahora
                String pass = String.valueOf(jPasswordField.getPassword());
                JOptionPane.showMessageDialog(jFrame, pass);
            }
        });
        jFrame.setLayout(new BoxLayout(jFrame.getContentPane(), BoxLayout.Y_AXIS));
        jFrame.add(panel);
        jFrame.add(panelb);
        jFrame.add(button);
        jFrame.setVisible(true);

    }
    public static void main(String... args) {
        Formulario formulario= new Formulario();
    }
}
