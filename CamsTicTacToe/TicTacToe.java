import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe extends JFrame
{
    boolean isXTurn;

    private PlayerPanel player1;
    private PlayerPanel player2;
	private JPanel players;
    private JPanel buttonPanel;
	private JPanel gameButtonPanel;
    private JButton newGame;
    private JButton reset;
    private JButton exit;
	
	private JLabel status;

    //buttons
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    
    ImageIcon X;
    ImageIcon O;


    public TicTacToe()
    {
        isXTurn = true;
        
        setTitle("Tic Tac Toe");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        //X = new ImageIcon("x.JPG");
        //O = new ImageIcon("O.JPG");
		
        buildGameButtonPanel();
		buildButtonPanel();
		buildPlayerPanel();
		
        add(players, BorderLayout.NORTH);
        add(gameButtonPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        
		setSize(500, 500);
		
        pack();
        setVisible(true);
    }
	
	public void checkWin() {
		if(button1.getText() == "X" && button2.getText() == "X" && button3.getText() == "X") {
			player1.addWin();
			player2.addLoss();
		} else if(button1.getText() == "O" && button2.getText() == "O" && button3.getText() == "O") {
			player2.addWin();
			player1.addLoss();
		}
		if(button4.getText() == "X" && button5.getText() == "X" && button6.getText() == "X") {
			player1.addWin();
			player2.addLoss();
		} else if(button4.getText() == "O" && button5.getText() == "O" && button6.getText() == "O") {
			player2.addWin();
			player1.addLoss();
		}
		if(button7.getText() == "X" && button8.getText() == "X" && button9.getText() == "X") {
			player1.addWin();
			player2.addLoss();
		} else if(button7.getText() == "O" && button8.getText() == "O" && button9.getText() == "O") {
			player2.addWin();
			player1.addLoss();
		}
		if(button1.getText() == "X" && button4.getText() == "X" && button7.getText() == "X") {
			player1.addWin();
			player2.addLoss();
		} else if(button1.getText() == "O" && button4.getText() == "O" && button7.getText() == "O") {
			player2.addWin();
			player1.addLoss();
		}
		if(button2.getText() == "X" && button5.getText() == "X" && button8.getText() == "X") {
			player1.addWin();
			player2.addLoss();
		} else if(button2.getText() == "O" && button5.getText() == "O" && button8.getText() == "O") {
			player2.addWin();
			player1.addLoss();
		}
		if(button3.getText() == "X" && button9.getText() == "X" && button6.getText() == "X") {
			player1.addWin();
			player2.addLoss();
		} else if(button3.getText() == "O" && button9.getText() == "O" && button6.getText() == "O") {
			player2.addWin();
			player1.addLoss();
		}
		if(button1.getText() == "X" && button5.getText() == "X" && button9.getText() == "X") {
			player1.addWin();
			player2.addLoss();
		} else if(button1.getText() == "O" && button5.getText() == "O" && button9.getText() == "O") {
			player2.addWin();
			player1.addLoss();
		}
		if(button3.getText() == "X" && button5.getText() == "X" && button7.getText() == "X") {
			player1.addWin();
			player2.addLoss();
		} else if(button3.getText() == "O" && button5.getText() == "O" && button7.getText() == "O") {
			player2.addWin();
			player1.addLoss();
		}
	}
	
	private void buildPlayerPanel() {
		players = new JPanel();
		
		player1 = new PlayerPanel(1);
        player2 = new PlayerPanel(2);
		
		players.add(player1);
		players.add(player2);
	}
	
	private void buildButtonPanel() {
		buttonPanel = new JPanel();
		
		buttonPanel.setLayout(new GridLayout(2, 2));
		
		newGame = new JButton("New Game");
        reset = new JButton("Reset");
        exit = new JButton("Exit");
		status = new JLabel("Welcome to Tic-Tac-Toe!");
		
		status.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		
		newGame.addActionListener(new NewGameListener());
        reset.addActionListener(new ResetListener());
        exit.addActionListener(new ExitListener());
		
		buttonPanel.add(newGame);
		buttonPanel.add(reset);
		buttonPanel.add(exit);
		buttonPanel.add(status);
	}

    private void buildGameButtonPanel() 
    {
        gameButtonPanel = new JPanel();
		
		gameButtonPanel.setLayout(new GridLayout(3, 3));

        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        button8 = new JButton();
        button9 = new JButton();
		
		button1.setPreferredSize(new Dimension(150,100));
		button2.setPreferredSize(new Dimension(150,100));
		button3.setPreferredSize(new Dimension(150,100));

        button1.addActionListener(new Button1Listener());
        button2.addActionListener(new Button2Listener());
        button3.addActionListener(new Button3Listener());
        button4.addActionListener(new Button4Listener());
        button5.addActionListener(new Button5Listener());
        button6.addActionListener(new Button6Listener());
        button7.addActionListener(new Button7Listener());
        button8.addActionListener(new Button8Listener());
        button9.addActionListener(new Button9Listener());
		
		button1.setEnabled(false);
		button2.setEnabled(false);
		button3.setEnabled(false);
		button4.setEnabled(false);
		button5.setEnabled(false);
		button6.setEnabled(false);
		button7.setEnabled(false);
		button8.setEnabled(false);
		button9.setEnabled(false);

        gameButtonPanel.add(button1);
        gameButtonPanel.add(button2);
        gameButtonPanel.add(button3);
        gameButtonPanel.add(button4);
        gameButtonPanel.add(button5);
        gameButtonPanel.add(button6);
        gameButtonPanel.add(button7);
        gameButtonPanel.add(button8);
        gameButtonPanel.add(button9);
        
        
    }

    private class Button1Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (isXTurn)
            {
                button1.setText("X");
				isXTurn = false;
				status.setText(player2.getName() + "'s turn.");
            }
            else
            {
                button1.setText("O");
				isXTurn = true;
				status.setText(player1.getName() + "'s turn.");
            }
			button1.setEnabled(false);
			checkWin();
        }
    }
	private class Button2Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (isXTurn)
            {
                button2.setText("X");
				isXTurn = false;
				status.setText(player2.getName() + "'s turn.");
            }
            else
            {
                button2.setText("O");
				isXTurn = true;
				status.setText(player1.getName() + "'s turn.");
            }
			button2.setEnabled(false);
			checkWin();
        }
    }
	private class Button3Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (isXTurn)
            {
                button3.setText("X");
				isXTurn = false;
				status.setText(player2.getName() + "'s turn.");
            }
            else
            {
                button3.setText("O");
				isXTurn = true;
				status.setText(player1.getName() + "'s turn.");
            }
			button3.setEnabled(false);
			checkWin();
        }
    }
	private class Button4Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (isXTurn)
            {
                button4.setText("X");
				isXTurn = false;
				status.setText(player2.getName() + "'s turn.");
            }
            else
            {
                button4.setText("O");
				isXTurn = true;
				status.setText(player1.getName() + "'s turn.");
            }
			button4.setEnabled(false);
			checkWin();
        }
    }
	private class Button5Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (isXTurn)
            {
                button5.setText("X");
				isXTurn = false;
				status.setText(player2.getName() + "'s turn.");
            }
            else
            {
                button5.setText("O");
				isXTurn = true;
				status.setText(player1.getName() + "'s turn.");
            }
			button5.setEnabled(false);
			checkWin();
        }
    }
	private class Button6Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (isXTurn)
            {
                button6.setText("X");
				isXTurn = false;
				status.setText(player2.getName() + "'s turn.");
            }
            else
            {
                button6.setText("O");
				isXTurn = true;
				status.setText(player1.getName() + "'s turn.");
            }
			button6.setEnabled(false);
			checkWin();
        }
    }
	private class Button7Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (isXTurn)
            {
                button7.setText("X");
				isXTurn = false;
				status.setText(player2.getName() + "'s turn.");
            }
            else
            {
                button7.setText("O");
				isXTurn = true;
				status.setText(player1.getName() + "'s turn.");
            }
			button7.setEnabled(false);
			checkWin();
        }
    }
	private class Button8Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (isXTurn)
            {
                button8.setText("X");
				isXTurn = false;
				status.setText(player2.getName() + "'s turn.");
            }
            else
            {
                button8.setText("O");
				isXTurn = true;
				status.setText(player1.getName() + "'s turn.");
            }
			button8.setEnabled(false);
			checkWin();
        }
    }
	private class Button9Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if (isXTurn)
            {
                button9.setText("X");
				isXTurn = false;
				status.setText(player2.getName() + "'s turn.");
            }
            else
            {
                button9.setText("O");
				isXTurn = true;
				status.setText(player1.getName() + "'s turn.");
            }
			button9.setEnabled(false);
			checkWin();
        }
    }
    
    private class NewGameListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
			isXTurn = true;
			
			button1.setText("");
			button2.setText("");
			button3.setText("");
			button4.setText("");
			button5.setText("");
			button6.setText("");
			button7.setText("");
			button8.setText("");
			button9.setText("");
			
            button1.setEnabled(true);
			button2.setEnabled(true);
			button3.setEnabled(true);
			button4.setEnabled(true);
			button5.setEnabled(true);
			button6.setEnabled(true);
			button7.setEnabled(true);
			button8.setEnabled(true);
			button9.setEnabled(true);
			
			status.setText(player1.getName() + "'s turn.");
			player1.inProgress();
			player2.inProgress();
        }
    }
    
    private class ResetListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            int choice = JOptionPane.showConfirmDialog(null, "This will end the game and set the win/loss stats to 0. Are you sure?", "Are you sure?", JOptionPane.YES_NO_OPTION);
			if(choice == JOptionPane.YES_OPTION) {
				player1.reset(1);
				player2.reset(2);
				
				button1.setEnabled(false);
				button2.setEnabled(false);
				button3.setEnabled(false);
				button4.setEnabled(false);
				button5.setEnabled(false);
				button6.setEnabled(false);
				button7.setEnabled(false);
				button8.setEnabled(false);
				button9.setEnabled(false);
				
				button1.setText("");
				button2.setText("");
				button3.setText("");
				button4.setText("");
				button5.setText("");
				button6.setText("");
				button7.setText("");
				button8.setText("");
				button9.setText("");
				
				status.setText("Welcome to Tic-Tac-Toe!");
			} else {
				remove(choice);
			}
        }
    }
    
    private class ExitListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.exit(0);
        }
    }
}
