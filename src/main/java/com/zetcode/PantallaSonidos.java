package com.zetcode;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.FocusManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class PantallaSonidos extends JFrame {
	
	private JPanel contentPane;
	private JPanel panelSonidos;
	private JLabel label;
	private JButton botonSonido1;
	private JButton botonSonido2;
	private JButton botonSonido3; 
	private JButton botonVolver;

    public PantallaSonidos() {

        pantallaSonidos();
    }

    private void pantallaSonidos() {

    	setTitle("Personalizar sonidos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 1, 0, 0));
		contentPane.add(getLabel());
		contentPane.add(getPanelSonidos());
		contentPane.add(getBotonVolver());
    	
    }
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Elige un sonido:");
			label.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return label;
	}
    
    private JPanel getPanelSonidos() {
		if (panelSonidos == null) {
			panelSonidos = new JPanel();
			panelSonidos.setLayout(new GridLayout(1, 3, 0, 0));
			panelSonidos.add(getBotonSonido1());
			panelSonidos.add(getBotonSonido2());
			panelSonidos.add(getBotonSonido3());
		}
		return panelSonidos;
	}
    
    private JButton getBotonSonido1() {
		if (botonSonido1 == null) {
			botonSonido1 = new JButton("Sonido 1");
			botonSonido1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
		}
		return botonSonido1;
	}
    
    private JButton getBotonSonido2() {
		if (botonSonido2 == null) {
			botonSonido2 = new JButton("Sonido 2");
			botonSonido2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
		}
		return botonSonido2;
	}
    
    private JButton getBotonSonido3() {
		if (botonSonido3 == null) {
			botonSonido3 = new JButton("Sonido 3");
			botonSonido3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
		}
		return botonSonido3;
	}
    
    private JButton getBotonVolver() {
		if (botonVolver == null) {
			botonVolver = new JButton("Volver");
			botonVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Window ventana = FocusManager.getCurrentManager().getActiveWindow();
					ventana.dispose();
					PantallaPersonalizacion frameTab = new PantallaPersonalizacion();
					frameTab.setVisible(true);
				}
			});
		}
		return botonVolver;
	}
}
