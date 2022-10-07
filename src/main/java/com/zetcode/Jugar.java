package com.zetcode;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Jugar extends JFrame {
	
	private JLabel statusbar;
	
	public Jugar() {

        iniciarJuego();
    }

	private void iniciarJuego() {
		
		
		statusbar = new JLabel(" 0");
        add(statusbar, BorderLayout.SOUTH);

        var board = new Board(this);
        add(board);
        board.start();

        setTitle("Tetris");
        setSize(200, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
		
	}
	
	JLabel getStatusBar() {

        return statusbar;
    }
}
