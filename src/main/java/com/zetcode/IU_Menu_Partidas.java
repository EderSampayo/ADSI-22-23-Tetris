package com.zetcode;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IU_Menu_Partidas extends JFrame {

	private JPanel contentPane;

	public IU_Menu_Partidas(String pUsuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnNuevaPartida = new JButton("Nueva Partida");
		btnNuevaPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();	//Cierra la ventana actual
				Tetris tetris = new Tetris(null, pUsuario,0);				//aqui igual hay que poner lo de niveles
				tetris.setVisible(true);
			}
		});
		panel.add(btnNuevaPartida);
		
		JButton btnCargar = new JButton("Cargar Partida");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String estadoPartida = Controlador.getControlador().buscarEstadoPartida(pUsuario);
				if(estadoPartida == null)	//no existen partidas guardadas
				{
					System.out.println("No tienes ninguna partida guardada");
				}
				else
				{
					dispose();	//Cierra la ventana actual
					int puntos = Controlador.getControlador().obtenerPuntos(pUsuario);
					Tetris tetris = new Tetris(estadoPartida, pUsuario,puntos);
					tetris.setVisible(true);
				}
			}
		});
		panel.add(btnCargar);
		
		JButton btnVolver = new JButton("Volver al menu");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();	//Cierra la ventana actual
				IU_Menu menuPrincipal = new IU_Menu(pUsuario);
				menuPrincipal.setVisible(true);
			}
		});
		panel.add(btnVolver);
	}

}