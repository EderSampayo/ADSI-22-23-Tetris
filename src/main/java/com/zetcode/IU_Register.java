package com.zetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
//import java.util.ResourceBundle;
import java.util.ResourceBundle;

import javax.swing.JTextField;
//import com.toedter.components.JLocaleChooser;

//import main.java.com.zetcode.IU_Login;
//import main.java.com.zetcode.Usuario;
//import main.java.com.zetcode.UserAlreadyExists;
//import main.java.com.zetcode.AddressException;
//import main.java.com.zetcode.InternetAddress;
//import javax.mail.internet.InternetAddress;

import com.toedter.calendar.JDateChooser;

import javax.swing.JButton;
import java.awt.Color;

public class IU_Register extends JFrame {

	private JPanel contentPane;
	private JTextField nombreField;
	private JTextField apellidosField;
	private JTextField userField;
	private JPasswordField passwordField;
	private JTextField dniField;
	private JPasswordField passwordField2;
	private JTextField emailField;

	/**
	 * Create the frame.
	 */
	public IU_Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 737, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel JLabelNombre = new JLabel("Nombre:");
		JLabelNombre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabelNombre.setBounds(27, 69, 58, 29);
		contentPane.add(JLabelNombre);

		nombreField = new JTextField();
		nombreField.setBounds(169, 75, 142, 20);
		contentPane.add(nombreField);
		nombreField.setColumns(10);

		JLabel JLabelApellidos = new JLabel("Apellidos:");
		JLabelApellidos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabelApellidos.setBounds(340, 69, 84, 29);
		contentPane.add(JLabelApellidos);

		apellidosField = new JTextField();
		apellidosField.setBounds(489, 75, 185, 20);
		contentPane.add(apellidosField);
		apellidosField.setColumns(10);

		JLabel JLabelUser = new JLabel("User:");
		JLabelUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabelUser.setBounds(27, 109, 58, 29);
		contentPane.add(JLabelUser);

		userField = new JTextField();
		userField.setColumns(10);
		userField.setBounds(169, 115, 142, 20);
		contentPane.add(userField);

		JLabel JLabelContraseña = new JLabel("Contrase\u00F1a:");
		JLabelContraseña.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabelContraseña.setBounds(27, 149, 84, 29);
		contentPane.add(JLabelContraseña);

		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBounds(169, 155, 142, 20);
		contentPane.add(passwordField);

		JLabel JLabelTitulo = new JLabel("Rellena los siguientes campos:");
		JLabelTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JLabelTitulo.setBounds(27, 28, 284, 20);
		contentPane.add(JLabelTitulo);

		JLabel JLabelDNI = new JLabel("DNI:");
		JLabelDNI.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabelDNI.setBounds(340, 109, 58, 29);
		contentPane.add(JLabelDNI);

		dniField = new JTextField();
		dniField.setColumns(10);
		dniField.setBounds(489, 115, 185, 20);
		contentPane.add(dniField);

		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(489, 158, 185, 20);
		contentPane.add(dateChooser);

		JLabel JLabelRepetirContraseña = new JLabel("Repetir contrase\u00F1a:");
		JLabelRepetirContraseña.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabelRepetirContraseña.setBounds(27, 189, 132, 29);
		contentPane.add(JLabelRepetirContraseña);

		passwordField2 = new JPasswordField();
		passwordField2.setColumns(10);
		passwordField2.setBounds(169, 195, 142, 20);
		contentPane.add(passwordField2);

		JLabel JLabelFechaNacimiento = new JLabel("FechaNacimineto:");
		JLabelFechaNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabelFechaNacimiento.setBounds(340, 149, 120, 29);
		contentPane.add(JLabelFechaNacimiento);

		JButton JButtonRegister = new JButton("Registrarse");
		JButtonRegister.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JButtonRegister.setBounds(112, 258, 175, 59);
		contentPane.add(JButtonRegister);

		JLabel JLabelEmail = new JLabel("Email:");
		JLabelEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabelEmail.setBounds(340, 189, 120, 29);
		contentPane.add(JLabelEmail);

		emailField = new JTextField();
		emailField.setColumns(10);
		emailField.setBounds(489, 195, 185, 20);
		contentPane.add(emailField);

		JButton JButtonAtras = new JButton("Atras");
		JButtonAtras.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JButtonAtras.setBounds(430, 258, 175, 59);
		contentPane.add(JButtonAtras);

		JLabel JLabelError = new JLabel("");
		JLabelError.setForeground(new Color(255, 0, 0));
		JLabelError.setBackground(new Color(0, 0, 0));
		JLabelError.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabelError.setBounds(349, 35, 325, 14);
		contentPane.add(JLabelError);

		JButtonAtras.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				IU_MenuIniciador mi = new IU_MenuIniciador();
				mi.setVisible(true);
				jButton2_actionPerformed(e);
			}
		});

		JButtonRegister.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if (userField.getText() == null || passwordField.getPassword() == null || emailField.getText() == null
						|| dniField.getText() == null || dateChooser.getDate() == null) {
					JLabelError.setText("Porfavor complete todos los campos");
				} else {
					String nombre = nombreField.getText();
					String apellidos = apellidosField.getText();
					String user = userField.getText();
					String password = String.valueOf(passwordField.getPassword());
					String password2 = String.valueOf(passwordField2.getPassword());
					String email = emailField.getText();
					String DNI = dniField.getText();
					Date fecha = dateChooser.getDate();
//					LocalDate birthDate = LocalDate.of(fecha.getYear(), fecha.getMonth(), fecha.getDay());
//					Date currentDate = Date.from(Instant.now());
//					LocalDate currentDate2 = LocalDate.of(currentDate.getYear(), currentDate.getMonth(),
//							currentDate.getDay());
//					Integer años = calculateAge(birthDate, currentDate2);
					if (validar(DNI)) {
						if (password.compareTo(password2) == 0) {
							if (emailVerify(email)) {
								try {
									if (!com.zetcode.Controlador.getControlador().getUser(user)) {
										Usuario user_new = new Usuario(user, nombre, apellidos, DNI, email, fecha,
												password);
										user_new.setNombre(nombre);
										user_new.setApellidos(apellidos);
										user_new.setUser(user);
										user_new.setDNI(DNI);
										com.zetcode.Controlador.getControlador().storeUser(user_new);
										JLabelError.setText("Registradoconexito");
										IU_Login hacerLogin = new IU_Login();
										hacerLogin.setVisible(true);
									}
								} catch (SQLException e1) {
									e1.printStackTrace();
									JLabelError.setText("El nombre de usuario ya existe");
								}
							} else {
								JLabelError.setText("El email no es valido");
							}
						} else {
							JLabelError.setText("Las contraseñas no coinciden");
						}
					} else {
						JLabelError.setText("DNI no valido");
					}
				}
			}
		});

	}

	public static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
		if ((birthDate != null) && (currentDate != null)) {
			return Period.between(birthDate, currentDate).getYears();
		} else {
			return 0;
		}
	}

	public static boolean emailVerify(String email) {
		String reg = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
				+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
		Pattern emailPat = Pattern.compile(reg, Pattern.CASE_INSENSITIVE);
		Matcher match = emailPat.matcher(email);
		return match.find();
	}

	public boolean validar(String dni) {

		String letraMayuscula = "";

		if (dni.length() != 9 || Character.isLetter(dni.charAt(8)) == false) {
			return false;
		}
		letraMayuscula = (dni.substring(8)).toUpperCase();
		if (soloNumeros(dni) == true && letraDNI(dni).equals(letraMayuscula)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean soloNumeros(String dnia) {

		String numero = "";
		String miDNI = "";
		String[] unoNueve = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };

		for (int i = 0; i < dnia.length() - 1; i++) {
			numero = dnia.substring(i, i + 1);
			for (int j = 0; j < unoNueve.length; j++) {
				if (numero.equals(unoNueve[j])) {
					miDNI += unoNueve[j];
				}
			}

		}
		if (miDNI.length() != 8) {
			return false;
		} else {
			return true;
		}
	}

	private String letraDNI(String dnia) {
		int miDNI = Integer.parseInt(dnia.substring(0, 8));
		int resto = 0;
		String miLetra = "";
		String[] asignacionLetra = { "T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S",
				"Q", "V", "H", "L", "C", "K", "E" };

		resto = miDNI % 23;
		miLetra = asignacionLetra[resto];
		return miLetra;

	}

	private void jButton2_actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}

}
