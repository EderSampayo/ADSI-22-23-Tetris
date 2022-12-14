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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

public class PantallaColorDeFondo extends JFrame {
	
	private JPanel contentPane;

    public PantallaColorDeFondo(String pUsuario) {

        pantallaColorDeFondo(pUsuario);
    }

    private void pantallaColorDeFondo(String pUsuario) {

    	setTitle("Personalizar color de fondo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 1, 0, 0));
		
		JLabel label = new JLabel("Elige un color:");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(label);
		
		JPanel panelColores = new JPanel();
		panelColores.setLayout(new GridLayout(3, 3, 0, 0));
		JButton botonRojo = new JButton("");
		botonRojo.setBackground(Color.RED);
		botonRojo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Board.getBoard().cambiarColorFondo(Color.RED);
				Controlador.getControlador().cambiarColorFondoBD(1);
			}
		});
		panelColores.add(botonRojo);
		JButton botonVerde = new JButton("");
		botonVerde.setBackground(Color.GREEN);
		botonVerde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Board.getBoard().cambiarColorFondo(Color.GREEN);
				Controlador.getControlador().cambiarColorFondoBD(2);
			}
		});
		panelColores.add(botonVerde);
		JButton botonAmarillo = new JButton("");
		botonAmarillo.setBackground(Color.YELLOW);
		botonAmarillo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Board.getBoard().cambiarColorFondo(Color.YELLOW);
				Controlador.getControlador().cambiarColorFondoBD(3);
			}
		});
		panelColores.add(botonAmarillo);
		JButton botonAzul = new JButton("");
		botonAzul.setBackground(Color.BLUE);
		botonAzul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Board.getBoard().cambiarColorFondo(Color.BLUE);
				Controlador.getControlador().cambiarColorFondoBD(4);
			}
		});
		panelColores.add(botonAzul);
		JButton botonRosa = new JButton("");
		botonRosa.setBackground(Color.PINK);
		botonRosa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Board.getBoard().cambiarColorFondo(Color.PINK);
				Controlador.getControlador().cambiarColorFondoBD(5);
			}
		});
		panelColores.add(botonRosa);
		JButton botonBlanco = new JButton("");
		botonBlanco.setBackground(Color.WHITE);
		botonBlanco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Board.getBoard().cambiarColorFondo(Color.WHITE);
				Controlador.getControlador().cambiarColorFondoBD(6);
			}
		});
		panelColores.add(botonBlanco);
		JButton botonNaranja = new JButton("");
		botonNaranja.setBackground(Color.ORANGE);
		botonNaranja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Board.getBoard().cambiarColorFondo(Color.ORANGE);
				Controlador.getControlador().cambiarColorFondoBD(7);
			}
		});
		panelColores.add(botonNaranja);
		JButton botonGrisClaro = new JButton("");
		botonGrisClaro.setBackground(Color.LIGHT_GRAY);
		botonGrisClaro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Board.getBoard().cambiarColorFondo(Color.LIGHT_GRAY);
				Controlador.getControlador().cambiarColorFondoBD(8);
			}
		});
		panelColores.add(botonGrisClaro);
		JButton botonCyan = new JButton("");
		botonCyan.setBackground(Color.CYAN);
		botonCyan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Board.getBoard().cambiarColorFondo(Color.CYAN);
				Controlador.getControlador().cambiarColorFondoBD(9);
			}
		});
		panelColores.add(botonCyan);
		contentPane.add(panelColores);
		
		JPanel panelVolverDefault = new JPanel();
		panelVolverDefault.setLayout(new GridLayout(1, 2, 0, 0));
		JButton botonVolver = new JButton("Volver");
		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window ventana = FocusManager.getCurrentManager().getActiveWindow();
				ventana.dispose();
				PantallaPersonalizacion frameTab = new PantallaPersonalizacion(pUsuario);
				frameTab.setVisible(true);
			}
		});
		panelVolverDefault.add(botonVolver);
		JButton botonColoresDefault = new JButton("Colores default");
		botonColoresDefault.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Board.getBoard().ponerColorDeFondoDefault();
				Controlador.getControlador().cambiarColorFondoBD(0);
			}
		});
		panelVolverDefault.add(botonColoresDefault);
		contentPane.add(panelVolverDefault); 
    }
}
