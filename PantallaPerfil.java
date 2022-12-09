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
	private JPanel datos;
	private JLabel nombre;
	private JLabel apellido;
	private JLabel clave;
	private JLabel mejorMarca;
	private JButton botonPersonalizar;
	private JButton botonVolver;
	
	public PantallaPerfil() {

        iniciarPerfil();
    }

	private void iniciarPerfil() {
		
		setTitle("Perfil");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 0, 0, 0));
		contentPane.add(getPanelDatos());
		contentPane.add(getBotonPersonalizar());
		contentPane.add(getBotonVolver());
	}

	private JPanel getPanelDatos() {
		if (datos == null) {
			datos = new JPanel();
			datos.setLayout(new GridLayout(4, 1, 0, 0));
			datos.add(getLblNombre());
			datos.add(getLblApellido());
			datos.add(getLblClave());
			datos.add(getLblMejorMarca());
		}
		return datos;
	}

	private JLabel getLblNombre() {
		if (nombre == null) {
			nombre = new JLabel("Nombre: ??");
			nombre.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return nombre;
	}
	
	private JLabel getLblApellido() {
		if (apellido == null) {
			apellido = new JLabel("Apellido: ??");
			apellido.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return apellido;
	}
	
	private JLabel getLblClave() {
		if (clave == null) {
			clave = new JLabel("Clave: ??");
			clave.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return clave;
	}
	
	private JLabel getLblMejorMarca() {
		if (mejorMarca == null) {
			mejorMarca = new JLabel("Mejor marca: ??");
			mejorMarca.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return mejorMarca;
	}

	private JButton getBotonPersonalizar() {
		if (botonPersonalizar == null) {
			botonPersonalizar = new JButton("Personalizar juego");
			botonPersonalizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Window ventana = FocusManager.getCurrentManager().getActiveWindow();
					ventana.dispose();
					PantallaPersonalizacion frameTab = new PantallaPersonalizacion();
					frameTab.setVisible(true);
				}
			});
		}
		return botonPersonalizar;
	}
	
	private JButton getBotonVolver() {
		if (botonVolver == null) {
			botonVolver = new JButton("Volver");
			botonVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Window ventana = FocusManager.getCurrentManager().getActiveWindow();
					ventana.dispose();
					Tetris frameTab = new Tetris();
					frameTab.setVisible(true);
					
				}
			});
		}
		return botonVolver;
	}
	
}
