package com.zetcode;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.zetcode.Shape.Tetrominoe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

public class Board extends JPanel {

	private static Board miBoard;
    private final int BOARD_WIDTH = 10;
    private final int BOARD_HEIGHT = 22;
    private final int PERIOD_INTERVAL = 300;

    private Timer timer;
    private boolean isFallingFinished = false;
    private boolean isPaused = false;
    private int numLinesRemoved = 0;
    private int curX = 0;
    private int curY = 0;
    private JLabel statusbar;
    private Shape curPiece;
    private Tetrominoe[] board;
    private Color colorFondo;
    private Color ladrillo1;
    private Color ladrillo2;
    private Color ladrillo3;
    private Color ladrillo4;
    private Color ladrillo5;
    private Color ladrillo6;
    private Color ladrillo7;
    private int sonido;
    /** ADSI **/
    private String usuario = "eder";
    private Tetris padre;
    /** ADSI **/
    

    public Board(){
    	int idPersonalizacion = Controlador.getControlador().obtenerId(usuario);
    	
    }

    public static Board getBoard(){
		if (Board.miBoard == null) {
			Board.miBoard = new Board();
			
		}
		return Board.miBoard;
	}
    
    public void initBoard(Tetris parent) {

    	this.padre = parent;
        setFocusable(true);
        statusbar = parent.getStatusBar();
        this.setBackground(colorFondo);
        addKeyListener(new TAdapter());
    }

    private int squareWidth() {

        return (int) getSize().getWidth() / BOARD_WIDTH;
    }

    private int squareHeight() {

        return (int) getSize().getHeight() / BOARD_HEIGHT;
    }

    private Tetrominoe shapeAt(int x, int y) {

        return board[(y * BOARD_WIDTH) + x];
    }

    void start(String pEstadoPartida) {

        curPiece = new Shape();
        /** ADSI **/
        if(pEstadoPartida != null)
        {
            Tetrominoe[] partida = this.convertirStringABoard(pEstadoPartida);
            board = partida;
        }
        else
        {
            board = new Tetrominoe[BOARD_WIDTH * BOARD_HEIGHT];
            clearBoard();
        }
        /** ADSI **/
        newPiece();

        timer = new Timer(PERIOD_INTERVAL, new GameCycle());
        timer.start();
    }

    private void pause() {

        isPaused = !isPaused;

        if (isPaused) {
            statusbar.setText("paused");
            this.setVisible(false);
            padre.dispose();
            String estadoPartida = this.convertirBoardAString();

            IU_Pausa pausa= new IU_Pausa(estadoPartida, usuario);
            pausa.setVisible(true);
        } else {

            statusbar.setText(String.valueOf(numLinesRemoved));
        }

        repaint();
    }
    
    private String convertirBoardAString()
    /** Convierte el Board Tetrominoe[] al String estadoPartida **/
    {
        String s = "";
        for(int i=0; i<board.length; i++)
        {
            Tetrominoe te = board[i];
            if(i != board.length-1)
            {
                s = s + te + " ";
            }
            else
            {
                s = s + te;
            }
        }

        //System.out.println(s);
        return s;
    }
    
    private Tetrominoe[] convertirStringABoard(String pEstadoPartida)
    /** Convierte el String estadoPartida al Board Tetrominoe[] **/
    {
        String[] textoSeparado = pEstadoPartida.split(" ");     //Devuelve un array de String por cada palabra separada por un espacio

        Tetrominoe[] resultado = new Tetrominoe[BOARD_WIDTH * BOARD_HEIGHT];
        for(int i=0; i< textoSeparado.length; i++)
        {
            String s = textoSeparado[i];
            if(s.equals("NoShape"))
            {
                resultado[i] = Tetrominoe.NoShape;
            }
            else if(s.equals("ZShape"))
            {
                resultado[i] = Tetrominoe.ZShape;
            }
            else if(s.equals("SShape"))
            {
                resultado[i] = Tetrominoe.SShape;
            }
            else if(s.equals("LineShape"))
            {
                resultado[i] = Tetrominoe.LineShape;
            }
            else if(s.equals("TShape"))
            {
                resultado[i] = Tetrominoe.TShape;
            }
            else if(s.equals("SquareShape"))
            {
                resultado[i] = Tetrominoe.SquareShape;
            }
            else if(s.equals("LShape"))
            {
                resultado[i] = Tetrominoe.LShape;
            }
            else if(s.equals("MirroredLShape"))
            {
                resultado[i] = Tetrominoe.MirroredLShape;
            }
        }

        return resultado;
    }

    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        doDrawing(g);
    }

    private void doDrawing(Graphics g) {

        var size = getSize();
        int boardTop = (int) size.getHeight() - BOARD_HEIGHT * squareHeight();

        for (int i = 0; i < BOARD_HEIGHT; i++) {

            for (int j = 0; j < BOARD_WIDTH; j++) {

                Tetrominoe shape = shapeAt(j, BOARD_HEIGHT - i - 1);

                if (shape != Tetrominoe.NoShape) {

                    drawSquare(g, j * squareWidth(),
                            boardTop + i * squareHeight(), shape);
                }
            }
        }

        if (curPiece.getShape() != Tetrominoe.NoShape) {

            for (int i = 0; i < 4; i++) {

                int x = curX + curPiece.x(i);
                int y = curY - curPiece.y(i);

                drawSquare(g, x * squareWidth(),
                        boardTop + (BOARD_HEIGHT - y - 1) * squareHeight(),
                        curPiece.getShape());
            }
        }
    }

    private void dropDown() {

        int newY = curY;

        while (newY > 0) {

            if (!tryMove(curPiece, curX, newY - 1)) {

                break;
            }

            newY--;
        }

        pieceDropped();
    }

    private void oneLineDown() {

        if (!tryMove(curPiece, curX, curY - 1)) {

            pieceDropped();
        }
    }

    private void clearBoard() {

        for (int i = 0; i < BOARD_HEIGHT * BOARD_WIDTH; i++) {

            board[i] = Tetrominoe.NoShape;
        }
    }

    private void pieceDropped() {

        for (int i = 0; i < 4; i++) {

            int x = curX + curPiece.x(i);
            int y = curY - curPiece.y(i);
            board[(y * BOARD_WIDTH) + x] = curPiece.getShape();
        }

        removeFullLines();

        if (!isFallingFinished) {

            newPiece();
        }
    }

    private void newPiece() {

        curPiece.setRandomShape();
        curX = BOARD_WIDTH / 2 + 1;
        curY = BOARD_HEIGHT - 1 + curPiece.minY();

        if (!tryMove(curPiece, curX, curY)) {

            curPiece.setShape(Tetrominoe.NoShape);
            timer.stop();

            var msg = String.format("Game over. Score: %d", numLinesRemoved);
            statusbar.setText(msg);
        }
    }

    private boolean tryMove(Shape newPiece, int newX, int newY) {

        for (int i = 0; i < 4; i++) {

            int x = newX + newPiece.x(i);
            int y = newY - newPiece.y(i);

            if (x < 0 || x >= BOARD_WIDTH || y < 0 || y >= BOARD_HEIGHT) {

                return false;
            }

            if (shapeAt(x, y) != Tetrominoe.NoShape) {

                return false;
            }
        }

        curPiece = newPiece;
        curX = newX;
        curY = newY;

        repaint();

        return true;
    }

    private void removeFullLines() {

        int numFullLines = 0;

        for (int i = BOARD_HEIGHT - 1; i >= 0; i--) {

            boolean lineIsFull = true;

            for (int j = 0; j < BOARD_WIDTH; j++) {

                if (shapeAt(j, i) == Tetrominoe.NoShape) {

                    lineIsFull = false;
                    break;
                }
            }

            if (lineIsFull) {

                numFullLines++;

                for (int k = i; k < BOARD_HEIGHT - 1; k++) {
                    for (int j = 0; j < BOARD_WIDTH; j++) {
                        board[(k * BOARD_WIDTH) + j] = shapeAt(j, k + 1);
                    }
                }
            }
        }

        if (numFullLines > 0) {

            numLinesRemoved += numFullLines;

            statusbar.setText(String.valueOf(numLinesRemoved));
            isFallingFinished = true;
            curPiece.setShape(Tetrominoe.NoShape);
        }
    }

    private void drawSquare(Graphics g, int x, int y, Tetrominoe shape) {

        Color colors[] = {new Color(0, 0, 0), ladrillo1,
        		ladrillo2, ladrillo3,
        		ladrillo4, ladrillo5,
        		ladrillo6, ladrillo7
        };

        var color = colors[shape.ordinal()];

        g.setColor(color);
        g.fillRect(x + 1, y + 1, squareWidth() - 2, squareHeight() - 2);

        g.setColor(color.brighter());
        g.drawLine(x, y + squareHeight() - 1, x, y);
        g.drawLine(x, y, x + squareWidth() - 1, y);

        g.setColor(color.darker());
        g.drawLine(x + 1, y + squareHeight() - 1,
                x + squareWidth() - 1, y + squareHeight() - 1);
        g.drawLine(x + squareWidth() - 1, y + squareHeight() - 1,
                x + squareWidth() - 1, y + 1);
    }
    
    public void cambiarColorFondo(Color color) {
    	colorFondo = color;
    }
    
    public void cambiarColorLadrillo(Color color,int num) {
    	if(num == 1) {
    		ladrillo1 = color;
    	}
    	else if(num == 2) {
    		ladrillo2 = color;
    	}
    	else if(num == 3) {
    		ladrillo3 = color;
    	}
    	else if(num == 4) {
    		ladrillo4 = color;
    	}
    	else if(num == 5) {
    		ladrillo5 = color;
    	}
    	else if(num == 6) {
    		ladrillo6 = color;
    	}
    	else if(num == 7) {
    		ladrillo7 = color;
    	}
    }
    
    public void ponerColorDeFondoDefault() {
    	
    	colorFondo = null;
    	
    }
    
    public void ponerColoresDefault() {
    	
    	ladrillo1 = new Color(204, 102, 204);
    	ladrillo2 = new Color(102, 102, 204);
    	ladrillo3 = new Color(102, 204, 204);
    	ladrillo4 = new Color(218, 170, 0);
    	ladrillo5 = new Color(204, 204, 102);
    	ladrillo6 = new Color(204, 102, 102);
    	ladrillo7 = new Color(102, 204, 102);
    	
    }
    
    public void cambiarSonido(int num) {
    	
    }

    private class GameCycle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            doGameCycle();
        }
    }

    private void doGameCycle() {

        update();
        repaint();
    }

    private void update() {

        if (isPaused) {

            return;
        }

        if (isFallingFinished) {

            isFallingFinished = false;
            newPiece();
        } else {

            oneLineDown();
        }
    }

    class TAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            if (curPiece.getShape() == Tetrominoe.NoShape) {

                return;
            }

            int keycode = e.getKeyCode();

            // Java 12 switch expressions
            switch (keycode) {

                case KeyEvent.VK_P -> pause();
                case KeyEvent.VK_LEFT -> tryMove(curPiece, curX - 1, curY);
                case KeyEvent.VK_RIGHT -> tryMove(curPiece, curX + 1, curY);
                case KeyEvent.VK_DOWN -> tryMove(curPiece.rotateRight(), curX, curY);
                case KeyEvent.VK_UP -> tryMove(curPiece.rotateLeft(), curX, curY);
                case KeyEvent.VK_SPACE -> dropDown();
                case KeyEvent.VK_D -> oneLineDown();
            }
        }
    }
}