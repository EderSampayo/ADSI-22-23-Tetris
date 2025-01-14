package com.zetcode;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IU_Pausa extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public IU_Pausa(String pEstadoPartida, String pUsuario,int puntos) {
		String estadoPartida = pEstadoPartida;
		String usuario = pUsuario;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnReanudar = new JButton("Reanudar Partida");
		btnReanudar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();	//Cierra la ventana actual
				Tetris tetris = new Tetris(pEstadoPartida, pUsuario, puntos);
				tetris.setVisible(true);
				//System.out.println(pEstadoPartida);
			}
		});
		panel.add(btnReanudar);
		
		JButton btnGuardar = new JButton("Guardar Partida");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controlador.getControlador().eliminarPartidaGuardada(pUsuario);
				Controlador.getControlador().guardarPartida(pEstadoPartida, pUsuario, puntos);
			}
		});
		panel.add(btnGuardar);
		
		JButton btnSalir = new JButton("Salir de la Partida");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();	//Cierra la ventana actual
				IU_Menu_Partidas menu = new IU_Menu_Partidas(pUsuario);
				menu.setVisible(true);
			}
		});
		panel.add(btnSalir);

	}
}