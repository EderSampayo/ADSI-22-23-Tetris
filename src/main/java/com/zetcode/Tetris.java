package com.zetcode;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.FocusManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
Java Tetris game clone

Author: Jan Bodnar
Website: https://zetcode.com
 */
public class Tetris extends JFrame {
	
	private static final Logger logger = LogManager.getLogger(Tetris.class);

    private JPanel contentPane;
	private JButton botonJugar;
	private JButton botonPerfil;

    public Tetris() {

        initUI();
    }

    private void initUI() {

    	setTitle("Tetris");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		contentPane.add(getBotonJugar());
		contentPane.add(getBotonPerfil());
    	
    }

    private JButton getBotonJugar() {
		if (botonJugar == null) {
			botonJugar = new JButton("Jugar");
			botonJugar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Window ventana = FocusManager.getCurrentManager().getActiveWindow();
					ventana.dispose();
					Jugar frameTab = new Jugar();
					frameTab.setVisible(true);
				}
			});
		}
		return botonJugar;
	}
    
    private JButton getBotonPerfil() {
		if (botonPerfil == null) {
			botonPerfil = new JButton("Perfil");
			botonPerfil.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Window ventana = FocusManager.getCurrentManager().getActiveWindow();
					ventana.dispose();
					PantallaPerfil frameTab = new PantallaPerfil();
					frameTab.setVisible(true);
				}
			});
		}
		return botonPerfil;
	}
    
    public static void main(String[] args) {

    	logger.info("Playing");
        EventQueue.invokeLater(() -> {

            var game = new Tetris();
            game.setVisible(true);
        });
    }
}