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
	private JPanel panelBotones;
	private JButton botonColor;
	private JButton botonLadrillos;
	private JButton botonSonidos;
	private JButton botonVolver;
	private JButton botonDificultad;

    public PantallaPersonalizacion() {

        personalizar();
    }

    private void personalizar() {

    	setTitle("Personalizar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 1, 0, 0));
		contentPane.add(getPanelBotones());
		contentPane.add(getBotonVolver());
    	
    }

    private JPanel getPanelBotones() {
		if (panelBotones == null) {
			panelBotones = new JPanel();
			panelBotones.setLayout(new GridLayout(2, 2, 0, 0));
			panelBotones.add(getBotonColor());
			panelBotones.add(getBotonLadrillos());
			panelBotones.add(getBotonSonidos());
			panelBotones.add(getBotonDificultad());
		}
		return panelBotones;
	}
    
    private JButton getBotonColor() {
		if (botonColor == null) {
			botonColor = new JButton(" Personalizar color de fondo");
			botonColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Window ventana = FocusManager.getCurrentManager().getActiveWindow();
					ventana.dispose();
					PantallaColorDeFondo frameTab = new PantallaColorDeFondo();
					frameTab.setVisible(true);
				}
			});
		}
		return botonColor;
	}
    
    private JButton getBotonLadrillos() {
		if (botonLadrillos == null) {
			botonLadrillos = new JButton("Personalizar ladrillos");
			botonLadrillos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Window ventana = FocusManager.getCurrentManager().getActiveWindow();
					ventana.dispose();
					PantallaColorLadrillos frameTab = new PantallaColorLadrillos();
					frameTab.setVisible(true);
				}
			});
		}
		return botonLadrillos;
	}
    
    private JButton getBotonSonidos() {
		if (botonSonidos == null) {
			botonSonidos = new JButton("Personalizar sonidos");
			botonSonidos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Window ventana = FocusManager.getCurrentManager().getActiveWindow();
					ventana.dispose();
					PantallaSonidos frameTab = new PantallaSonidos();
					frameTab.setVisible(true);
				}
			});
		}
		return botonSonidos;
	}
    
    private JButton getBotonDificultad() {
    	if (botonDificultad == null) {
			botonDificultad = new JButton("Dificultad");
    	}
    	return botonDificultad;
	}
    
    private JButton getBotonVolver() {
		if (botonVolver == null) {
			botonVolver = new JButton("Volver");
			botonVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Window ventana = FocusManager.getCurrentManager().getActiveWindow();
					ventana.dispose();
					PantallaPerfil frameTab = new PantallaPerfil();
					frameTab.setVisible(true);
				}
			});
		}
		return botonVolver;
	}
}
