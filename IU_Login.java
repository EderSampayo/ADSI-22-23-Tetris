package com.zetcode;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

//import gui.HacerPronosticoGUI;
//import gui.MainGUI;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class IU_Login extends JFrame {

	private JPanel contentPane;
	private JTextField userField;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public IU_Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel JLabelTitulo = new JLabel("Rellena los campos para poder loguearte:");
		JLabelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JLabelTitulo.setBounds(34, 32, 383, 35);
		contentPane.add(JLabelTitulo);

		JLabel JLabelEmail_User = new JLabel("Nombre de usuario:");
		JLabelEmail_User.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabelEmail_User.setBounds(32, 93, 139, 20);
		contentPane.add(JLabelEmail_User);

		userField = new JTextField();
		userField.setBounds(34, 124, 255, 31);
		contentPane.add(userField);
		userField.setColumns(10);

		JLabel JLabelContrasena = new JLabel("Contrase\u00F1a:");
		JLabelContrasena.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabelContrasena.setBounds(34, 166, 111, 14);
		contentPane.add(JLabelContrasena);

		JButton JButtonRecuperarContrasena = new JButton("RecuperarContrase\u00F1a");
		JButtonRecuperarContrasena.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JButtonRecuperarContrasena.setBounds(338, 117, 230, 93);
		contentPane.add(JButtonRecuperarContrasena);

		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBounds(34, 191, 255, 31);
		contentPane.add(passwordField);

		JButton JButtonLogin = new JButton("Loguearse");
		JButtonLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JButtonLogin.setBounds(34, 255, 165, 50);
		contentPane.add(JButtonLogin);

		JButton JButtonAtras = new JButton("Atras");
		JButtonAtras.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JButtonAtras.setBounds(252, 255, 165, 50);
		contentPane.add(JButtonAtras);

		JLabel JLabelError = new JLabel("");
		JLabelError.setForeground(new Color(255, 0, 0));
		JLabelError.setBackground(new Color(0, 0, 0));
		JLabelError.setBounds(313, 221, 255, 23);
		contentPane.add(JLabelError);

		JButtonAtras.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				dispose();
				IU_MenuIniciador mi = new IU_MenuIniciador();
				mi.setVisible(true);
				jButton2_actionPerformed(e);
			}
		});

		JButtonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((String.valueOf(passwordField.getPassword()) == null) && (userField.getText() == null)) {
					JLabelError.setText("Introduzca los datos solicitados");
				} else {
					if (String.valueOf(passwordField.getPassword()) == null) {
						JLabelError.setText("Introduzca la contraseña");
					} else {
						if (userField.getText() == null) {
							JLabelError.setText("Introduzca el usuario");
						} else {
							String password = String.valueOf(passwordField.getPassword());
							String user = userField.getText();
							String admin = "admin";
							try {
								if (Controlador.getControlador().getUserContrasena(user, password) != null) {
									if(user.compareTo(admin)==0) {
										JLabelError.setText("Logeado con exito");
										dispose();
										IU_MenuAdmin a = new IU_MenuAdmin(admin);
										a.setVisible(true);
									}else {
										JLabelError.setText("Logeado con exito");
										dispose();
										IU_Menu a = new IU_Menu(user);
										a.setVisible(true);
									}
								} else {
									JLabelError.setText("Usuario o contraseña invalidos");
								}
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							// if ((facade.getUserLogin(user, password).getAdmin(user, password)) == false)
							// {
//							IU_Menu a = new IU_Menu(user);
//							a.setVisible(true);
							// VisibleFalse(e);
							// } else {
							//
							// MainGUI m = new MainGUI();
							// m.setVisible(true);

						}
					}
				}
			}
		});

		JButtonRecuperarContrasena.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				dispose();
				IU_RecuperarContrasena rc = new IU_RecuperarContrasena();
				rc.setVisible(true);
				jButton2_actionPerformed(e);

			}
		});
	}

	private void jButton2_actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}
}
