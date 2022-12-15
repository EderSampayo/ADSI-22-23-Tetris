package com.zetcode;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Window;

import javax.swing.FocusManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.Font;
import javax.swing.JLabel;

public class IU_Rankings extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_Rankings frame = new IU_Rankings("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IU_Rankings(String usu) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new GridLayout(2, 3, 0, 0));
		
		JButton btnPersonal = new JButton("Personal");
		btnPersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IU_RanksPersonal tabla;
				try {
					tabla = new IU_RanksPersonal(usu);
					tabla.setVisible(true);
					Window ventana = FocusManager.getCurrentManager().getActiveWindow();
					ventana.dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		getContentPane().add(btnPersonal);

		JButton btnGlobal = new JButton("Global");
		btnGlobal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IU_RanksGlobal tabla;
				try {
					tabla = new IU_RanksGlobal(usu);
					tabla.setVisible(true);
					Window ventana = FocusManager.getCurrentManager().getActiveWindow();
					ventana.dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		getContentPane().add(btnGlobal);

		JButton btnNiveles = new JButton("Por niveles");
		btnNiveles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IU_RanksNiveles tabla = new IU_RanksNiveles(usu);
				tabla.setVisible(true);
				Window ventana = FocusManager.getCurrentManager().getActiveWindow();
				ventana.dispose();
			}
		});
		getContentPane().add(btnNiveles);
		
		JLabel lblNewLabel = new JLabel("");
		getContentPane().add(lblNewLabel);
		
		JButton btnVolver = new JButton("Volver");
		getContentPane().add(btnVolver);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window ventana = FocusManager.getCurrentManager().getActiveWindow();
				ventana.dispose();
				Tetris frameTab = new Tetris();
				frameTab.setVisible(true);
				
			}
		});
	}

}
