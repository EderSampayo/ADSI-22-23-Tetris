package com.zetcode;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.FocusManager;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class Dificultad extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton botonFacil;
	private JButton botonNormal;
	private JButton BotonDificil;
	private JPanel panel_1;
	private JLabel label1;
	private JLabel label;
	private JLabel label2;
	private JPanel panel_2;
	private JButton botonAplicar;
	private JButton botonVolver = new JButton("Volver");
	private JButton botonMenuPrincipal = new JButton("Menu Principal");

	/**
	 * Create the frame.
	 */
	public Dificultad(String pUsuario) {
		dificultad(pUsuario);
	}

	private void dificultad(String pUsuario) {
		setTitle("Dificultad");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		contentPane.add(getPanel());
		contentPane.add(getPanel_1());
		contentPane.add(getPanel_2());

		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window ventana = FocusManager.getCurrentManager().getActiveWindow();
				ventana.dispose();
				PantallaPersonalizacion frameTab = new PantallaPersonalizacion(pUsuario);
				frameTab.setVisible(true);
			}
		});

		botonMenuPrincipal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window ventana = FocusManager.getCurrentManager().getActiveWindow();
				ventana.dispose();
				IU_Menu frameTab = new IU_Menu(pUsuario);
				frameTab.setVisible(true);
			}
		});
	}



	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setLayout(new GridLayout(0, 1, 0, 0));
			panel.add(getBotonFacil());
			panel.add(getBotonNormal());
			panel.add(getBotonDificil());
		}
		return panel;
	}

	public void cambiarDificultad(String dificultad) {
		Controlador.getControlador().cambiarDificultad(dificultad);

	}

	private JButton getBotonFacil() {
		if (botonFacil == null) {
			botonFacil = new JButton("F\u00E1cil");
			botonFacil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JButton fuente = (JButton) e.getSource();
					if (botonFacil == fuente) {
						cambiarDificultad("Facil");
						JOptionPane.showMessageDialog(null, "A");
					}
				}
			});
		}

		return botonFacil;
	}

	private JButton getBotonNormal() {
		if (botonNormal == null) {
			botonNormal = new JButton("Normal (Por defecto)");
			botonNormal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JButton fuente = (JButton) e.getSource();
					if (botonNormal == fuente) {
						cambiarDificultad("Normal");
					}
				}
			});

		}
		return botonNormal;
	}

	private JButton getBotonDificil() {
		if (BotonDificil == null) {
			BotonDificil = new JButton("Dif\u00EDcil");
			BotonDificil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JButton fuente = (JButton) e.getSource();
					if (BotonDificil == fuente) {
						cambiarDificultad("Dificil");
					}
				}
			});
		}
		return BotonDificil;
	}

	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(new GridLayout(0, 1, 0, 0));
			panel_1.add(getLabel());
			panel_1.add(getLabel1());
			panel_1.add(getLabel2());
		}
		return panel_1;
	}

	private JLabel getLabel1() {
		if (label1 == null) {
			label1 = new JLabel("Velocidad de ladrillos y tama\u00F1o de tablero por defecto");
			label1.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return label1;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Menor velocidad de ladrillos y menor tama\u00F1o de tablero");
			label.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return label;
	}

	private JLabel getLabel2() {
		if (label2 == null) {
			label2 = new JLabel("Mayor velocidad de ladrillos y mayor tama\u00F1o de tablero");
			label2.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return label2;
	}

	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(new GridLayout(0, 1, 0, 0));
			panel_2.add(getBotonAplicar());
			panel_2.add(botonVolver);
			panel_2.add(botonMenuPrincipal);
		}
		return panel_2;
	}

	private JButton getBotonAplicar() {
		if (botonAplicar == null) {
			botonAplicar = new JButton("Aplicar");
		}
		return botonAplicar;
	}

}
