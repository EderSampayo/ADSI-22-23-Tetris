package com.zetcode;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.JSONArray;
import org.json.JSONObject;

import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.FocusManager;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;

public class IU_RanksNiveles extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public IU_RanksNiveles(String usu) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(7, 3, 0, 0));
		
		JLabel n1 = new JLabel("Nivel 1");
		n1.setHorizontalAlignment(SwingConstants.CENTER);
		n1.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(n1);
		
		JLabel n2 = new JLabel("Nivel 2");
		n2.setHorizontalAlignment(SwingConstants.CENTER);
		n2.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(n2);
		
		JLabel n3 = new JLabel("Nivel 3");
		n3.setHorizontalAlignment(SwingConstants.CENTER);
		n3.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(n3);
		
		JLabel n11 = new JLabel("1- ");
		n11.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(n11);
		
		JLabel n21 = new JLabel("1- ");
		n21.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(n21);
		
		JLabel n31 = new JLabel("1- ");
		n31.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(n31);
		
		JLabel n12 = new JLabel("2- ");
		n12.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(n12);
		
		JLabel n22 = new JLabel("2- ");
		n22.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(n22);
		
		JLabel n32 = new JLabel("2- ");
		n32.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(n32);
		
		JLabel n13 = new JLabel("3- ");
		n13.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(n13);
		
		JLabel n23 = new JLabel("3- ");
		n23.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(n23);
		
		JLabel n33 = new JLabel("3- ");
		n33.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(n33);
		
		JLabel n14 = new JLabel("4- ");
		n14.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(n14);
		
		JLabel n24 = new JLabel("4- ");
		n24.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(n24);
		
		JLabel n34 = new JLabel("4- ");
		n34.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(n34);
		
		JLabel n15 = new JLabel("5- ");
		n15.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(n15);
		
		JLabel n25 = new JLabel("5- ");
		n25.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(n25);
		
		JLabel n35 = new JLabel("5- ");
		n35.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(n35);
		
		JLabel lblNewLabel_18 = new JLabel("");
		contentPane.add(lblNewLabel_18);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Window ventana = FocusManager.getCurrentManager().getActiveWindow();
				ventana.dispose();
				IU_Rankings frameTab = new IU_Rankings(usu);
				frameTab.setVisible(true);
			}
		});
		contentPane.add(btnVolver);
		
		JSONArray j2 = new JSONArray();
		j2 = Controlador.getControlador().buscarMejoresXNivel(); 	//Se buscan las mejores partidas por cada nivel
		JSONObject j1n1 = (JSONObject) j2.remove(0);		//Mejores partidas nivel 1
		JSONObject j1n2 = (JSONObject) j2.remove(1);		//Mejores partidas nivel 2
		JSONObject j1n3 = (JSONObject) j2.remove(2);		//Mejores partidas nivel 3
		
		//Actualizar ranking Nivel 1
		if (j1n1!=null)
		{
			Iterator<String> itr1 = j1n1.keys();
			int i1 = 1;
			while(itr1.hasNext())
			{
				String quien = itr1.next();
				int cuanto = (int) j1n1.remove(quien); 	//Cu�ntos puntos ha hecho ese usuario
				String cuantoS = Integer.toString(cuanto);
				if(i1==1)
				{
					n11.setText("1- "+quien+" "+cuantoS);
				}
				else if(i1==2)
				{
					n12.setText("2- "+quien+" "+cuantoS);		
				}
				else if(i1==3)
				{
					n13.setText("3- "+quien+" "+cuantoS);			
				}
				else if(i1==4)
				{
					n14.setText("4- "+quien+" "+cuantoS);			
				}
				else if(i1==5)
				{
					n15.setText("5- "+quien+" "+cuantoS);			
				}
				i1++;
			}
		}
		

		//Actualizar ranking Nivel 2
		if (j1n2!=null)
		{
			Iterator<String> itr2 = j1n2.keys();
			int i2 = 1;
			while(itr2.hasNext())
			{
				String quien = itr2.next();
				int cuanto = (int) j1n2.remove(quien); 	//Cu�ntos puntos ha hecho ese usuario
				String cuantoS = Integer.toString(cuanto);
				if(i2==1)
				{
					n21.setText("1- "+quien+" "+cuantoS);
				}
				else if(i2==2)
				{
					n22.setText("2- "+quien+" "+cuantoS);		
				}
				else if(i2==3)
				{
					n23.setText("3- "+quien+" "+cuantoS);			
				}
				else if(i2==4)
				{
					n24.setText("4- "+quien+" "+cuantoS);			
				}
				else if(i2==5)
				{
					n25.setText("5- "+quien+" "+cuantoS);			
				}
				i2++;
			}
		}
		
		
		//Actualizar ranking Nivel 3
		if (j1n3!=null)
		{
			Iterator<String> itr3 = j1n3.keys();
			int i3 = 1;
			while(itr3.hasNext())
			{
				String quien = itr3.next();
				int cuanto = (int) j1n3.remove(quien); 	//Cu�ntos puntos ha hecho ese usuario
				String cuantoS = Integer.toString(cuanto);
				if(i3==1)
				{
					n31.setText("1- "+quien+" "+cuantoS);
				}
				else if(i3==2)
				{
					n32.setText("2- "+quien+" "+cuantoS);		
				}
				else if(i3==3)
				{
					n33.setText("3- "+quien+" "+cuantoS);			
				}
				else if(i3==4)
				{
					n34.setText("4- "+quien+" "+cuantoS);			
				}
				else if(i3==5)
				{
					n35.setText("5- "+quien+" "+cuantoS);			
				}
				i3++;
			}
		}
		
	}

}
