package com.zetcode;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.FocusManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
Java Tetris game clone

Author: Jan Bodnar
Website: https://zetcode.com
 */
public class Tetris extends JFrame {
	
	private static final Logger logger = LogManager.getLogger(Tetris.class);

	private JLabel statusbar;

    public Tetris(String pEstadoPartida, String pUsuario) { //ADSI

        initUI(pEstadoPartida);
    }

    private void initUI(String pEstadoPartida) { //ADSI

        statusbar = new JLabel(" 0");
        add(statusbar, BorderLayout.SOUTH);

        var board = Board.getBoard();
        board.initBoard(this);
        add(board);
        board.start(pEstadoPartida); //ADSI

        setTitle("Tetris");
        setSize(200, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    JLabel getStatusBar() {

        return statusbar;
    }
    
    public static void main(String[] args) {

    	logger.info("Playing");
        EventQueue.invokeLater(() -> {

        	var game = new Tetris(null, "eder");
            game.setVisible(true);
        });
    }
}