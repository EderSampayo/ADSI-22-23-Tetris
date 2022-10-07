package com.zetcode;

import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.FocusManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class PantallaPersonalizacion extends JFrame {
	
	private JPanel contentPane;
	private JButton botonColor;
	private JButton botonLadrillos;
	private JButton botonSonidos;
	private JButton botonVolver;
	private JLabel lblVacio;

    public PantallaPersonalizacion() {

        personalizar();
    }

    private void personalizar() {

    	setTitle("Personalizar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 3, 0, 0));
		contentPane.add(getBotonColor());
		contentPane.add(getbotonLadrillos());
		contentPane.add(getbotonSonidos());
		contentPane.add(getlblVacio());
		contentPane.add(getBotonVolver());
    	
    }

    private JButton getBotonColor() {
		if (botonColor == null) {
			botonColor = new JButton(" Personalizar color de fondo");
			botonColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Jugar frameTab = new Jugar();
					frameTab.setVisible(true);
				}
			});
		}
		return botonColor;
	}
    
    private JButton getbotonLadrillos() {
		if (botonLadrillos == null) {
			botonLadrillos = new JButton("Personalizar ladrillos");
			botonLadrillos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					PantallaPerfil frameTab = new PantallaPerfil();
					frameTab.setVisible(true);
				}
			});
		}
		return botonLadrillos;
	}
    
    private JButton getbotonSonidos() {
		if (botonSonidos == null) {
			botonSonidos = new JButton("Personalizar sonidos");
			botonSonidos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					PantallaPerfil frameTab = new PantallaPerfil();
					frameTab.setVisible(true);
				}
			});
		}
		return botonSonidos;
	}
    
    private JLabel getlblVacio() {
    	if (lblVacio == null) {
			lblVacio = new JLabel();
    	}
    	return lblVacio;
	}
    
    private JButton getBotonVolver() {
		if (botonVolver == null) {
			botonVolver = new JButton("Volver");
			botonVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Window ventana = FocusManager.getCurrentManager().getActiveWindow();
					ventana.dispose();
					PantallaPerfil frameTab = new PantallaPerfil();
					frameTab.setVisible(true);
				}
			});
		}
		return botonVolver;
	}
}
