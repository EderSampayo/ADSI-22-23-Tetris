package com.zetcode;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.FocusManager;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IU_Menu extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public IU_Menu(String pUsuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnJugar = new JButton("Jugar");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();	//Cierra la ventana actual
				IU_Menu_Partidas menu = new IU_Menu_Partidas(pUsuario);
				menu.setVisible(true);
			}
		});
		contentPane.add(btnJugar);
		
		JButton btnPerfil = new JButton("Perfil");
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				IU_Perfil perfil = new IU_Perfil(pUsuario);
				perfil.setVisible(true);
			}
		});
		contentPane.add(btnPerfil);
		
		JButton btnRankings = new JButton("Rankings");
		btnRankings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				IU_Rankings frameTab = new IU_Rankings(pUsuario);
				frameTab.setVisible(true);
			}
		});
		contentPane.add(btnRankings);
	}

}
