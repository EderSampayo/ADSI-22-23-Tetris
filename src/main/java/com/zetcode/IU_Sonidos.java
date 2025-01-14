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

public class IU_Sonidos extends JFrame {
	
	private JPanel contentPane;

    public IU_Sonidos(String pUsuario) {

        pantallaSonidos(pUsuario);
    }

    private void pantallaSonidos(String pUsuario) {

    	setTitle("Personalizar sonidos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 1, 0, 0));
		
		JLabel label = new JLabel("Elige un sonido:");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(label);
		
		JPanel panelSonidos = new JPanel();
		panelSonidos.setLayout(new GridLayout(1, 3, 0, 0));
		JButton botonSonido1 = new JButton("Sonido 1");
		botonSonido1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Board.getBoard(pUsuario,0).cambiarSonido(1);
				int id = Controlador.getControlador().obtenerId(pUsuario);
				Controlador.getControlador().cambiarSonidoBD(id,1);
			}
		});
		panelSonidos.add(botonSonido1);
		JButton botonSonido2 = new JButton("Sonido 2");
		botonSonido2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Board.getBoard(pUsuario,0).cambiarSonido(2);
				int id = Controlador.getControlador().obtenerId(pUsuario);
				Controlador.getControlador().cambiarSonidoBD(id,2);
			}
		});
		panelSonidos.add(botonSonido2);
		JButton botonSonido3 = new JButton("Sonido 3");
		botonSonido3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Board.getBoard(pUsuario,0).cambiarSonido(3);
				int id = Controlador.getControlador().obtenerId(pUsuario);
				Controlador.getControlador().cambiarSonidoBD(id,3);
			}
		});
		panelSonidos.add(botonSonido3);
		contentPane.add(panelSonidos);
		
		JButton botonVolver = new JButton("Volver");
		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window ventana = FocusManager.getCurrentManager().getActiveWindow();
				ventana.dispose();
				IU_Personalizacion frameTab = new IU_Personalizacion(pUsuario);
				frameTab.setVisible(true);
			}
		});
		contentPane.add(botonVolver);
    }
}
