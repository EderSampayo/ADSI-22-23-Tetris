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

public class IU_Personalizacion extends JFrame {
	
	private JPanel contentPane;

    public IU_Personalizacion(String pUsuario) {

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
				IU_ColorDeFondo frameTab = new IU_ColorDeFondo(pUsuario);
				frameTab.setVisible(true);
			}
		});
		panelBotones.add(botonColor);
		JButton botonLadrillos = new JButton("Personalizar ladrillos");
		botonLadrillos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window ventana = FocusManager.getCurrentManager().getActiveWindow();
				ventana.dispose();
				IU_ColorLadrillos frameTab = new IU_ColorLadrillos(pUsuario);
				frameTab.setVisible(true);
			}
		});
		panelBotones.add(botonLadrillos);
		JButton botonSonidos = new JButton("Personalizar sonidos");
		botonSonidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window ventana = FocusManager.getCurrentManager().getActiveWindow();
				ventana.dispose();
				IU_Sonidos frameTab = new IU_Sonidos(pUsuario);
				frameTab.setVisible(true);
			}
		});
		panelBotones.add(botonSonidos);
		JButton botonDificultad = new JButton("Dificultad");
		botonDificultad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window ventana = FocusManager.getCurrentManager().getActiveWindow();
				ventana.dispose();
				IU_Dificultad frameTab = new IU_Dificultad(pUsuario);
				frameTab.setVisible(true);
			}
		});
		panelBotones.add(botonDificultad);
		contentPane.add(panelBotones);
		
		JButton botonVolver = new JButton("Volver");
		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window ventana = FocusManager.getCurrentManager().getActiveWindow();
				ventana.dispose();
				IU_Perfil frameTab = new IU_Perfil(pUsuario);
				frameTab.setVisible(true);
			}
		});
		contentPane.add(botonVolver);	
    }
}
