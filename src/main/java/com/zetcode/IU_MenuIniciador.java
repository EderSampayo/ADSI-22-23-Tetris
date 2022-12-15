package main.java.com.zetcode;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;

public class IU_MenuIniciador extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_MenuIniciador frame = new IU_MenuIniciador();
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
	public IU_MenuIniciador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton JButtonRegistrarse = new JButton("Registrarte");
		JButtonRegistrarse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JButtonRegistrarse.setBounds(0, 0, 224, 263);
		contentPane.add(JButtonRegistrarse);
		
		JButton JButtonLogueate = new JButton("Logueate");
		JButtonLogueate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JButtonLogueate.setBounds(222, 0, 214, 263);
		contentPane.add(JButtonLogueate);
		
		JButtonRegistrarse.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				IU_Register r = new IU_Register();
				r.setVisible(true);
				jButton2_actionPerformed(e);
			}
		});
		JButtonLogueate.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				IU_Login l = new IU_Login();
				l.setVisible(true);
				jButton2_actionPerformed(e);
			}
		});
	}
	
	private void jButton2_actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}

}
