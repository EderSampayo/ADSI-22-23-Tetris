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
	private JPanel panelColores;
	private JPanel panelVolverDefault;
	private JLabel label;
	private JButton botonRojo;
	private JButton botonVerde;
	private JButton botonAmarillo;
	private JButton botonAzul;
	private JButton botonRosa;
	private JButton botonBlanco;
	private JButton botonNaranja;
	private JButton botonGrisClaro;
	private JButton botonCyan;
	private JButton botonVolver;
	private JButton botonColoresDefault;

    public PantallaColorDeFondo() {

        pantallaColorDeFondo();
    }

    private void pantallaColorDeFondo() {

    	setTitle("Personalizar color de fondo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 1, 0, 0));
		contentPane.add(getLabel());
		contentPane.add(getPanelColores());
		contentPane.add(getPanelVolverDefault());
    	
    }
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Elige un color:");
			label.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return label;
	}
    
    private JPanel getPanelColores() {
		if (panelColores == null) {
			panelColores = new JPanel();
			panelColores.setLayout(new GridLayout(3, 3, 0, 0));
			panelColores.add(getBotonRojo());
			panelColores.add(getBotonVerde());
			panelColores.add(getBotonAmarillo());
			panelColores.add(getBotonAzul());
			panelColores.add(getBotonRosa());
			panelColores.add(getBotonBlanco());
			panelColores.add(getBotonNaranja());
			panelColores.add(getBotonGrisClaro());
			panelColores.add(getBotonCyan());
		}
		return panelColores;
	}
    
    private JButton getBotonRojo() {
		if (botonRojo == null) {
			botonRojo = new JButton("");
			botonRojo.setBackground(Color.RED);
			botonRojo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Board.getBoard().cambiarColorFondo(Color.RED);
				}
			});
		}
		return botonRojo;
	}
    
    private JButton getBotonVerde() {
		if (botonVerde == null) {
			botonVerde = new JButton("");
			botonVerde.setBackground(Color.GREEN);
			botonVerde.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Board.getBoard().cambiarColorFondo(Color.GREEN);
				}
			});
		}
		return botonVerde;
	}
    
    private JButton getBotonAmarillo() {
		if (botonAmarillo == null) {
			botonAmarillo = new JButton("");
			botonAmarillo.setBackground(Color.YELLOW);
			botonAmarillo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Board.getBoard().cambiarColorFondo(Color.YELLOW);
				}
			});
		}
		return botonAmarillo;
	}
    
    private JButton getBotonAzul() {
		if (botonAzul == null) {
			botonAzul = new JButton("");
			botonAzul.setBackground(Color.BLUE);
			botonAzul.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Board.getBoard().cambiarColorFondo(Color.BLUE);
				}
			});
		}
		return botonAzul;
	}
    
    private JButton getBotonRosa() {
		if (botonRosa == null) {
			botonRosa = new JButton("");
			botonRosa.setBackground(Color.PINK);
			botonRosa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Board.getBoard().cambiarColorFondo(Color.PINK);
				}
			});
		}
		return botonRosa;
	}
    
    private JButton getBotonBlanco() {
		if (botonBlanco == null) {
			botonBlanco = new JButton("");
			botonBlanco.setBackground(Color.WHITE);
			botonBlanco.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Board.getBoard().cambiarColorFondo(Color.WHITE);
				}
			});
		}
		return botonBlanco;
	}
    
    private JButton getBotonNaranja() {
		if (botonNaranja == null) {
			botonNaranja = new JButton("");
			botonNaranja.setBackground(Color.ORANGE);
			botonNaranja.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Board.getBoard().cambiarColorFondo(Color.ORANGE);
				}
			});
		}
		return botonNaranja;
	}
    
    private JButton getBotonGrisClaro() {
		if (botonGrisClaro == null) {
			botonGrisClaro = new JButton("");
			botonGrisClaro.setBackground(Color.LIGHT_GRAY);
			botonGrisClaro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Board.getBoard().cambiarColorFondo(Color.LIGHT_GRAY);
				}
			});
		}
		return botonGrisClaro;
	}
    
    private JButton getBotonCyan() {
		if (botonCyan == null) {
			botonCyan = new JButton("");
			botonCyan.setBackground(Color.CYAN);
			botonCyan.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Board.getBoard().cambiarColorFondo(Color.CYAN);
				}
			});
		}
		return botonCyan;
	}
    
    private JPanel getPanelVolverDefault() {
		if (panelVolverDefault == null) {
			panelVolverDefault = new JPanel();
			panelVolverDefault.setLayout(new GridLayout(1, 2, 0, 0));
			panelVolverDefault.add(getBotonVolver());
			panelVolverDefault.add(getBotonColoresDefault());
		}
		return panelVolverDefault;
	}
    private JButton getBotonVolver() {
		if (botonVolver == null) {
			botonVolver = new JButton("Volver");
			botonVolver.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Window ventana = FocusManager.getCurrentManager().getActiveWindow();
					ventana.dispose();
					PantallaPersonalizacion frameTab = new PantallaPersonalizacion();
					frameTab.setVisible(true);
				}
			});
		}
		return botonVolver;
	}
    private JButton getBotonColoresDefault() {
		if (botonColoresDefault == null) {
			botonColoresDefault = new JButton("Color default");
			botonColoresDefault.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Board.getBoard().ponerColorDeFondoDefault();
				}
			});
		}
		return botonColoresDefault;
	}
}
