package com.zetcode;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.FocusManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class IU_Perfil extends JFrame {

	private JPanel contentPane;

	public IU_Perfil(String pUsuario) {

		iniciarPerfil(pUsuario);
	}

	private void iniciarPerfil(String pUsuario) {

		setTitle("Perfil");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 0, 0, 0));

		JPanel datos = new JPanel();
		contentPane.add(datos);
		datos.setLayout(null);

		JButton JButtonCambiarContrasena = new JButton("CambiarContrasena");
		JButtonCambiarContrasena.setBounds(0, 0, 426, 84);
		datos.add(JButtonCambiarContrasena);

		JButton botonPersonalizar = new JButton("Personalizar juego");
		botonPersonalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window ventana = FocusManager.getCurrentManager().getActiveWindow();
				ventana.dispose();
				IU_Personalizacion frameTab = new IU_Personalizacion(pUsuario);
				frameTab.setVisible(true);
			}
		});
		contentPane.add(botonPersonalizar);

		JButton botonVolver = new JButton("Volver");
		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window ventana = FocusManager.getCurrentManager().getActiveWindow();
				ventana.dispose();
				IU_Menu frameTab = new IU_Menu(pUsuario);
				frameTab.setVisible(true);

			}
		});
		contentPane.add(botonVolver);

		JButtonCambiarContrasena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IU_CambiarContrasena c = new IU_CambiarContrasena(pUsuario);
				c.setVisible(true);
			}
		});

	}
}
