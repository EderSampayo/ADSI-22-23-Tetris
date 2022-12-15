package main.java.com.zetcode;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JTextField;
import javax.swing.JButton;

public class IU_RecuperarContraseña extends JFrame {

	private JPanel contentPane;
	private JTextField emailField;
	private JTextField dniField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_RecuperarContraseña frame = new IU_RecuperarContraseña();
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
	public IU_RecuperarContraseña() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel JLabelEmail = new JLabel("Introduce el correo electronico:");
		JLabelEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabelEmail.setBounds(23, 47, 213, 25);
		contentPane.add(JLabelEmail);

		emailField = new JTextField();
		emailField.setBounds(23, 83, 213, 20);
		contentPane.add(emailField);
		emailField.setColumns(10);

		JLabel JLabelPregunta = new JLabel("\u00BFCual es tu DNI?");
		JLabelPregunta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JLabelPregunta.setBounds(23, 114, 213, 25);
		contentPane.add(JLabelPregunta);

		dniField = new JTextField();
		dniField.setColumns(10);
		dniField.setBounds(23, 150, 213, 20);
		contentPane.add(dniField);

		JButton JButtonRecuperar = new JButton("Recuperar");
		JButtonRecuperar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JButtonRecuperar.setBounds(23, 191, 131, 49);
		contentPane.add(JButtonRecuperar);

		JButton JButtonAtras = new JButton("Atras");
		JButtonAtras.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JButtonAtras.setBounds(199, 191, 131, 49);
		contentPane.add(JButtonAtras);

		JButtonRecuperar.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				String email = emailField.getText();
				String DNI = dniField.getText();
				if (validar(DNI)) {
					if (emailVerify(email)) {
						try {
							if (main.java.com.zetcode.Controlador.getControlador().getDNI(email, DNI)) {
								Usuario u = null;
								u = main.java.com.zetcode.Controlador.getControlador().getUser_2(email,DNI);
								IU_CambiarContraseña cc = new IU_CambiarContraseña(u.getUser());
								cc.setVisible(true);
							}
						} catch (SQLException e1) {
							e1.printStackTrace();

						}
					}
				}
			}
		});

		JButtonAtras.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				IU_Login l = new IU_Login();
				l.setVisible(true);
				jButton2_actionPerformed(e);
			}
		});
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
