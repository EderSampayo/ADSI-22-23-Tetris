package com.zetcode;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Window;

import javax.swing.JLabel;
import javax.swing.FocusManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import org.json.JSONObject;
import org.json.CDL;
import org.json.JSONArray;

public class IU_RanksGlobal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IU_RanksGlobal frame = new IU_RanksGlobal("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public IU_RanksGlobal(String usu) throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(7, 3, 0, 0));
		
		JLabel lblNewLabel_5 = new JLabel("RANKING");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_6);
		
		JLabel rTipo = new JLabel("Global");
		rTipo.setHorizontalAlignment(SwingConstants.CENTER);
		rTipo.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(rTipo);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window ventana = FocusManager.getCurrentManager().getActiveWindow();
				ventana.dispose();
				IU_Rankings frameTab = new IU_Rankings(usu);
				frameTab.setVisible(true);
			}
		});
		
		JLabel lblNewLabel = new JLabel("1- ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JLabel nom1 = new JLabel("-");
		nom1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(nom1);
		
		JLabel pts1 = new JLabel("-");
		pts1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(pts1);
		
		JLabel lblNewLabel_1 = new JLabel("2- ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_1);
		
		JLabel nom2 = new JLabel("-");
		nom2.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(nom2);
		
		JLabel pts2 = new JLabel("-");
		pts2.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(pts2);
		
		JLabel lblNewLabel_3 = new JLabel("3- ");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_3);
		
		JLabel nom3 = new JLabel("-");
		nom3.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(nom3);
		
		JLabel pts3 = new JLabel("-");
		pts3.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(pts3);
		
		JLabel lblNewLabel_2 = new JLabel("4- ");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_2);
		
		JLabel nom4 = new JLabel("-");
		nom4.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(nom4);
		
		JLabel pts4 = new JLabel("-");
		pts4.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(pts4);
		
		JLabel lblNewLabel_4 = new JLabel("5- ");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_4);
		
		JLabel nom5 = new JLabel("-");
		nom5.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(nom5);
		
		JLabel pts5 = new JLabel("-");
		pts5.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(pts5);
		
		JLabel lblNewLabel_7 = new JLabel("");
		contentPane.add(lblNewLabel_7);
		contentPane.add(btnVolver);
		
		
		JSONObject j1 = new JSONObject();

		j1 = Controlador.getControlador().buscarMejoresPartidas("");		//Se buscan las mejores partidas de entre todos los usuarios
		Iterator<String> itr = j1.keys();  //Iterador de los usuarios
		int i = 1;
		while(itr.hasNext())
		{
			String quien = itr.next();
			int cuanto = (int) j1.remove(quien); 	//Cuántos puntos ha hecho ese usuario
			String cuantoS = Integer.toString(cuanto);
			if(i==1)
			{
				nom1.setText(quien);
				pts1.setText(cuantoS);
			}
			else if(i==2)
			{
				nom2.setText(quien);
				pts2.setText(cuantoS);				
			}
			else if(i==3)
			{
				nom3.setText(quien);
				pts3.setText(cuantoS);				
			}
			else if(i==4)
			{
				nom4.setText(quien);
				pts4.setText(cuantoS);				
			}
			else if(i==5)
			{
				nom5.setText(quien);
				pts5.setText(cuantoS);				
			}
			
			i++;
		}
		
		
		
	}
	

}
