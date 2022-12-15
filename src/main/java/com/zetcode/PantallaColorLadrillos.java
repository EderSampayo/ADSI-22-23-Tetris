package com.zetcode;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.FocusManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class PantallaColorLadrillos extends JFrame {
	
	private JPanel contentPane;

    public PantallaColorLadrillos(String pUsuario) {

        pantallaColorLadrillos(pUsuario);
    }

    private void pantallaColorLadrillos(String pUsuario) {

    	setTitle("Personalizar color de ladrillos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panelLadrillos = new JPanel();
		panelLadrillos.setLayout(new GridLayout(1, 2, 0, 0));
		JLabel label = new JLabel("Elige un ladrillo y un color:");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panelLadrillos.add(label);	
		JRadioButton botonCuadrado = new JRadioButton("Cuadrado");;
		botonCuadrado.setHorizontalAlignment(SwingConstants.CENTER);
		panelLadrillos.add(botonCuadrado);
		JRadioButton botonRecto = new JRadioButton("Recto");
		botonRecto.setHorizontalAlignment(SwingConstants.CENTER);
		panelLadrillos.add(botonRecto);
		JRadioButton botonL = new JRadioButton("L");
		botonL.setHorizontalAlignment(SwingConstants.CENTER);
		panelLadrillos.add(botonL);
		JRadioButton botonLInversa = new JRadioButton("L inversa");
		botonLInversa.setHorizontalAlignment(SwingConstants.CENTER);
		panelLadrillos.add(botonLInversa);
		JRadioButton botonTPequena = new JRadioButton("T pequeña");
		botonTPequena.setHorizontalAlignment(SwingConstants.CENTER);
		panelLadrillos.add(botonTPequena);
		JRadioButton botonZ = new JRadioButton("Z");
		botonZ.setHorizontalAlignment(SwingConstants.CENTER);
		panelLadrillos.add(botonZ);
		JRadioButton botonZInversa = new JRadioButton("Z inversa");
		botonZInversa.setHorizontalAlignment(SwingConstants.CENTER);
		panelLadrillos.add(botonZInversa);
		ButtonGroup g = new ButtonGroup();
		g.add(botonCuadrado);
		g.add(botonRecto);
		g.add(botonL);
		g.add(botonLInversa);
		g.add(botonTPequena);
		g.add(botonZ);
		g.add(botonZInversa);
		contentPane.add(panelLadrillos);
		
		JPanel panelColores = new JPanel();
		panelColores.setLayout(new GridLayout(3, 3, 0, 0));
		JButton botonRojo = new JButton("");
		botonRojo.setBackground(Color.RED);
		botonRojo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(botonCuadrado.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.RED,1);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,1,1);
				}
				else if(botonRecto.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.RED,2);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,1,2);
				}
				else if(botonL.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.RED,3);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,1,3);
				}
				else if(botonLInversa.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.RED,4);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,1,4);
				}
				else if(botonTPequena.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.RED,5);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,1,5);
				}
				else if(botonZ.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.RED,6);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,1,6);
				}
				else if(botonZInversa.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.RED,7);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,1,7);
				}
				
			}
		});
		panelColores.add(botonRojo);
		JButton botonVerde = new JButton("");
		botonVerde.setBackground(Color.GREEN);
		botonVerde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(botonCuadrado.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.GREEN,1);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,2,1);
				}
				else if(botonRecto.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.GREEN,2);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,2,2);
				}
				else if(botonL.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.GREEN,3);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,2,3);
				}
				else if(botonLInversa.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.GREEN,4);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,2,4);
				}
				else if(botonTPequena.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.GREEN,5);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,2,5);
				}
				else if(botonZ.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.GREEN,6);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,2,6);
				}
				else if(botonZInversa.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.GREEN,7);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,2,7);
				}
				
			}
		});
		panelColores.add(botonVerde);
		JButton botonAmarillo = new JButton("");
		botonAmarillo.setBackground(Color.YELLOW);
		botonAmarillo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(botonCuadrado.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.YELLOW,1);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,3,1);
				}
				else if(botonRecto.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.YELLOW,2);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,3,2);
				}
				else if(botonL.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.YELLOW,3);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,3,3);
				}
				else if(botonLInversa.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.YELLOW,4);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,3,4);
				}
				else if(botonTPequena.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.YELLOW,5);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,3,5);
				}
				else if(botonZ.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.YELLOW,6);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,3,6);
				}
				else if(botonZInversa.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.YELLOW,7);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,3,7);
				}
			}
		});
		panelColores.add(botonAmarillo);
		JButton botonAzul = new JButton("");
		botonAzul.setBackground(Color.BLUE);
		botonAzul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(botonCuadrado.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.BLUE,1);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,4,1);
				}
				else if(botonRecto.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.BLUE,2);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,4,2);
				}
				else if(botonL.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.BLUE,3);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,4,3);
				}
				else if(botonLInversa.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.BLUE,4);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,4,4);
				}
				else if(botonTPequena.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.BLUE,5);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,4,5);
				}
				else if(botonZ.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.BLUE,6);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,4,6);
				}
				else if(botonZInversa.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.BLUE,7);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,4,7);
				}
			}
		});
		panelColores.add(botonAzul);
		JButton botonRosa = new JButton("");
		botonRosa.setBackground(Color.PINK);
		botonRosa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(botonCuadrado.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.PINK,1);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,5,1);
				}
				else if(botonRecto.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.PINK,2);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,5,2);
				}
				else if(botonL.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.PINK,3);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,5,3);
				}
				else if(botonLInversa.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.PINK,4);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,5,4);
				}
				else if(botonTPequena.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.PINK,5);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,5,5);
				}
				else if(botonZ.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.PINK,6);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,5,6);
				}
				else if(botonZInversa.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.PINK,7);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,5,7);
				}
			}
		});
		panelColores.add(botonRosa);
		JButton botonBlanco = new JButton("");
		botonBlanco.setBackground(Color.WHITE);
		botonBlanco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(botonCuadrado.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.WHITE,1);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,6,1);
				}
				else if(botonRecto.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.WHITE,2);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,6,2);
				}
				else if(botonL.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.WHITE,3);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,6,3);
				}
				else if(botonLInversa.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.WHITE,4);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,6,4);
				}
				else if(botonTPequena.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.WHITE,5);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,6,5);
				}
				else if(botonZ.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.WHITE,6);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,6,6);
				}
				else if(botonZInversa.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.WHITE,7);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,6,7);
				}
			}
		});
		panelColores.add(botonBlanco);
		JButton botonNaranja = new JButton("");
		botonNaranja.setBackground(Color.ORANGE);
		botonNaranja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(botonCuadrado.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.ORANGE,1);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,7,1);
				}
				else if(botonRecto.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.ORANGE,2);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,7,2);
				}
				else if(botonL.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.ORANGE,3);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,7,3);
				}
				else if(botonLInversa.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.ORANGE,4);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,7,4);
				}
				else if(botonTPequena.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.ORANGE,5);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,7,5);
				}
				else if(botonZ.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.ORANGE,6);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,7,6);
				}
				else if(botonZInversa.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.ORANGE,7);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,7,7);
				}
			}
		});
		panelColores.add(botonNaranja);
		JButton botonGrisClaro = new JButton("");
		botonGrisClaro.setBackground(Color.LIGHT_GRAY);
		botonGrisClaro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(botonCuadrado.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.LIGHT_GRAY,1);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,8,1);
				}
				else if(botonRecto.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.LIGHT_GRAY,2);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,8,2);
				}
				else if(botonL.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.LIGHT_GRAY,3);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,8,3);
				}
				else if(botonLInversa.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.LIGHT_GRAY,4);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,8,4);
				}
				else if(botonTPequena.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.LIGHT_GRAY,5);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,8,5);
				}
				else if(botonZ.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.LIGHT_GRAY,6);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,8,6);
				}
				else if(botonZInversa.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.LIGHT_GRAY,7);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,8,7);
				}
			}
		});
		panelColores.add(botonGrisClaro);
		JButton botonCyan = new JButton("");
		botonCyan.setBackground(Color.CYAN);
		botonCyan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(botonCuadrado.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.CYAN,1);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,9,1);
				}
				else if(botonRecto.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.CYAN,2);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,9,2);
				}
				else if(botonL.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.CYAN,3);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,9,3);
				}
				else if(botonLInversa.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.CYAN,4);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,9,4);
				}
				else if(botonTPequena.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.CYAN,5);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,9,5);
				}
				else if(botonZ.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.CYAN,6);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,9,6);
				}
				else if(botonZInversa.isSelected()) {
					Board.getBoard().cambiarColorLadrillo(Color.CYAN,7);
					int id = Controlador.getControlador().obtenerId(pUsuario);
					Controlador.getControlador().cambiarColorLadrilloBD(id,9,7);
				}
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
				Board.getBoard().ponerColoresDefault();
				int id = Controlador.getControlador().obtenerId(pUsuario);
				Controlador.getControlador().ponerColoresDefaultBD(id);
			}
		});
		panelVolverDefault.add(botonColoresDefault);
		contentPane.add(panelVolverDefault);    	
    }
}
