package com.zetcode;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;

public class IU_EliminarUser extends JFrame {

	private JPanel contentPane;
	private JComboBox<String> comboBox = new JComboBox<String>();
	DefaultComboBoxModel<String> modelEvents = new DefaultComboBoxModel<String>();

	/**
	 * Create the frame.
	 */
	public IU_EliminarUser(String pUsuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 292, 303);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel JLabelTitulo = new JLabel("Elige el usuario a eliminar:");
		JLabelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JLabelTitulo.setBounds(20, 41, 249, 33);
		contentPane.add(JLabelTitulo);

		comboBox.setModel(modelEvents);
		comboBox.setBounds(41, 95, 184, 22);
		contentPane.add(comboBox);
		this.getContentPane().add(comboBox, null);

		JButton JButtonEliminar = new JButton("Eliminar");
		JButtonEliminar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JButtonEliminar.setBounds(75, 143, 125, 64);
		contentPane.add(JButtonEliminar);

		JLabel JLabelError = new JLabel("");
		JLabelError.setForeground(new Color(255, 0, 0));
		JLabelError.setBounds(41, 241, 184, 14);
		contentPane.add(JLabelError);
		Vector<String> users = Controlador.getControlador().getUsersList(pUsuario);

//		while (!users.isEmpty()) {
			for (String u : users) {
				System.out.println(u);
				Usuario user = new Usuario(null, null, null, null, null, null, null);
				try {
					user = Controlador.getControlador().getUser_3(u);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				modelEvents.addElement(user.getUser());
				comboBox.repaint();
			}
//		}

		JButtonEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButtonCreate_actionPerformed(e);
			}
		});
	}

	private void jButtonCreate_actionPerformed(ActionEvent e) {
		String s = (String) comboBox.getSelectedItem();
		System.out.println(s);
		Usuario user = new Usuario(null, null, null, null, null, null, null);
		try {
			user = Controlador.getControlador().getUser_3(s);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		Controlador.getControlador().deleteUser(user);
	}
}
