package com.zetcode;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;

public class IU_MenuAdmin extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public IU_MenuAdmin(String pUsuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton JButtonMenu = new JButton("Menu");
		JButtonMenu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JButtonMenu.setBounds(0, 0, 224, 263);
		contentPane.add(JButtonMenu);

		JButton JButtonEliminarUser = new JButton("EliminarUsuario");
		JButtonEliminarUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JButtonEliminarUser.setBounds(223, 0, 213, 263);
		contentPane.add(JButtonEliminarUser);

		JButtonMenu.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				dispose();
				IU_Menu m = new IU_Menu(pUsuario);
				m.setVisible(true);
			}
		});
		JButtonEliminarUser.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				dispose();
				IU_EliminarUser eu = new IU_EliminarUser(pUsuario);
				eu.setVisible(true);
			}
		});
	}
}
