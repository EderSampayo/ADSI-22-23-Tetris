package main.java.com.zetcode;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;

public class IU_CambiarContraseña extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JPasswordField passwordField2; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_CambiarContraseña frame = new IU_CambiarContraseña(null);
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
	public IU_CambiarContraseña(String pUsuario) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 279, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel JLabelContraseña = new JLabel("Introduce la nueva contrase\u00F1a:");
		JLabelContraseña.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabelContraseña.setBounds(25, 42, 211, 30);
		contentPane.add(JLabelContraseña);

		passwordField = new JPasswordField();
		passwordField.setBounds(25, 83, 206, 20);
		contentPane.add(passwordField);
		passwordField.setColumns(10);

		JLabel lblRepiteLaNueva = new JLabel("Repite la nueva contrase\u00F1a:");
		lblRepiteLaNueva.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRepiteLaNueva.setBounds(25, 114, 206, 30);
		contentPane.add(lblRepiteLaNueva);

		passwordField2 = new JPasswordField();
		passwordField2.setColumns(10);
		passwordField2.setBounds(25, 155, 206, 20);
		contentPane.add(passwordField2);

		JButton JButtonCambiar = new JButton("CambiarContrase\u00F1a");
		JButtonCambiar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JButtonCambiar.setBounds(10, 197, 245, 39);
		contentPane.add(JButtonCambiar);

		JLabel JLabelError = new JLabel("");
		JLabelError.setForeground(new Color(255, 0, 0));
		JLabelError.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabelError.setBounds(25, 17, 206, 20);
		contentPane.add(JLabelError);

		JButtonCambiar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				if (passwordField.getPassword() == null || passwordField2.getPassword() == null) {
					JLabelError.setText("Porfavor complete todos los campos");
				} else {
					String password = String.valueOf(passwordField.getPassword());
					String password2 = String.valueOf(passwordField2.getPassword());
					if (password.compareTo(password2) == 0) {
						main.java.com.zetcode.Controlador.getControlador().setContraseña(password,pUsuario);
						JLabelError.setText("Las contraseñas se han modificado correctamente");
						IU_Login rc = new IU_Login();
						rc.setVisible(true);
						jButton2_actionPerformed(e);
					} else {
						JLabelError.setText("Las contraseñas no coinciden");
					}
				}
			}
		});

	}

	private void jButton2_actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}

}
