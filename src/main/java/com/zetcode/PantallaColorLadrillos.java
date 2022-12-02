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
	private JPanel panelColores;
	private JPanel panelLadrillos;
	private JLabel label;
	private ButtonGroup g;
	private JRadioButton botonCuadrado;
	private JRadioButton botonRecto;
	private JRadioButton botonL;
	private JRadioButton botonLInversa;
	private JRadioButton botonTpequena;
	private JRadioButton botonZ;
	private JRadioButton botonZInversa;
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

    public PantallaColorLadrillos() {

        pantallaColorLadrillos();
    }

    private void pantallaColorLadrillos() {

    	setTitle("Personalizar color de ladrillos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 1, 0, 0));
		contentPane.add(getPanelLadrillos());
		contentPane.add(getPanelColores());
		contentPane.add(getBotonVolver());
		g = getButtonGroup();
		g.add(botonCuadrado);
		g.add(botonRecto);
		g.add(botonL);
		g.add(botonLInversa);
		g.add(botonTpequena);
		g.add(botonZ);
		g.add(botonZInversa);
    	
    }
    
    private JPanel getPanelLadrillos() {
		if (panelLadrillos == null) {
			panelLadrillos = new JPanel();
			panelLadrillos.setLayout(new GridLayout(1, 2, 0, 0));
			panelLadrillos.add(getLabel());		
			panelLadrillos.add(getBotonCuadrado());
			panelLadrillos.add(getBotonRecto());
			panelLadrillos.add(getBotonL());
			panelLadrillos.add(getBotonLInversa());
			panelLadrillos.add(getBotonTPequena());
			panelLadrillos.add(getBotonZ());
			panelLadrillos.add(getBotonZInversa());
		}
		return panelLadrillos;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("Elige un ladrillo y un color:");
			label.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return label;
	}
	
	private ButtonGroup getButtonGroup() {
		if (g == null) {
			g = new ButtonGroup();
		}
		return g;
	}
	
	private JRadioButton getBotonCuadrado() {
		if (botonCuadrado == null) {
			botonCuadrado = new JRadioButton("Cuadrado");;
			botonCuadrado.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return botonCuadrado;
	}
	private JRadioButton getBotonRecto() {
		if (botonRecto == null) {
			botonRecto = new JRadioButton("Recto");
			botonRecto.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return botonRecto;
	}
	private JRadioButton getBotonL() {
		if (botonL == null) {
			botonL = new JRadioButton("L");
			botonL.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return botonL;
	}
	private JRadioButton getBotonLInversa() {
		if (botonLInversa == null) {
			botonLInversa = new JRadioButton("L inversa");
			botonLInversa.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return botonLInversa;
	}
	private JRadioButton getBotonTPequena() {
		if (botonTpequena == null) {
			botonTpequena = new JRadioButton("T pequeña");
			botonTpequena.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return botonTpequena;
	}
	private JRadioButton getBotonZ() {
		if (botonZ == null) {
			botonZ = new JRadioButton("Z");
			botonZ.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return botonZ;
	}
	private JRadioButton getBotonZInversa() {
		if (botonZInversa == null) {
			botonZInversa = new JRadioButton("Z inversa");
			botonZInversa.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return botonZInversa;
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
					
				}
			});
		}
		return botonCyan;
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
}
