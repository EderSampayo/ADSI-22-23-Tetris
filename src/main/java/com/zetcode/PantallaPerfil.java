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

public class PantallaPerfil extends JFrame {
	
	private JPanel contentPane;
		
	public PantallaPerfil(String pUsuario) {

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
		datos.setLayout(new GridLayout(4, 1, 0, 0));
		
		
		JLabel nombre = new JLabel("Nombre: ??");
		nombre.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel apellido = new JLabel("Apellido: ??");
		apellido.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel clave = new JLabel("Clave: ??");
		clave.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel mejorMarca = new JLabel("Mejor marca: ??");
		mejorMarca.setHorizontalAlignment(SwingConstants.CENTER);
		
		datos.add(nombre);
		datos.add(apellido);
		datos.add(clave);
		datos.add(mejorMarca);
		contentPane.add(datos);
		
		JButton botonPersonalizar = new JButton("Personalizar juego");
		botonPersonalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window ventana = FocusManager.getCurrentManager().getActiveWindow();
				ventana.dispose();
				PantallaPersonalizacion frameTab = new PantallaPersonalizacion(pUsuario);
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
	}	
}
