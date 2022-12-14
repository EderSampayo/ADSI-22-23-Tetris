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

    public PantallaPersonalizacion(String pUsuario) {

        personalizar(pUsuario);
    }

    private void personalizar(String pUsuario) {

    	setTitle("Personalizar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panelBotones = new JPanel();
		panelBotones.setLayout(new GridLayout(2, 2, 0, 0));
		JButton botonColor = new JButton(" Personalizar color de fondo");
		botonColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window ventana = FocusManager.getCurrentManager().getActiveWindow();
				ventana.dispose();
				PantallaColorDeFondo frameTab = new PantallaColorDeFondo(pUsuario);
				frameTab.setVisible(true);
			}
		});
		panelBotones.add(botonColor);
		JButton botonLadrillos = new JButton("Personalizar ladrillos");
		botonLadrillos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window ventana = FocusManager.getCurrentManager().getActiveWindow();
				ventana.dispose();
				PantallaColorLadrillos frameTab = new PantallaColorLadrillos(pUsuario);
				frameTab.setVisible(true);
			}
		});
		panelBotones.add(botonLadrillos);
		JButton botonSonidos = new JButton("Personalizar sonidos");
		botonSonidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window ventana = FocusManager.getCurrentManager().getActiveWindow();
				ventana.dispose();
				PantallaSonidos frameTab = new PantallaSonidos(pUsuario);
				frameTab.setVisible(true);
			}
		});
		panelBotones.add(botonSonidos);
		JButton botonDificultad = new JButton("Dificultad");
		panelBotones.add(botonDificultad);
		contentPane.add(panelBotones);
		
		JButton botonVolver = new JButton("Volver");
		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window ventana = FocusManager.getCurrentManager().getActiveWindow();
				ventana.dispose();
				PantallaPerfil frameTab = new PantallaPerfil(pUsuario);
				frameTab.setVisible(true);
			}
		});
		contentPane.add(botonVolver);	
    }
}
