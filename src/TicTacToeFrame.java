import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionListener;

public class TicTacToeFrame extends JFrame {
   // private ArrayList<String> fortunes;

    JPanel main, top, middle, bottom;
    JLabel label;
    JButton gameButton, quitBtn;
    JTextArea fortune;
    TicTacToeTile[][] board;
    private boolean winner;
    private boolean gameTied;
    private int counter;
    private String currentPlayer;

    public TicTacToeFrame()
    {
        super("Tic Tac Toe");
        // configure the GUI
        main = new JPanel();

        createTopPanel();
        createMiddlePanel();
        createBottomPanel();


        main.setLayout(new BorderLayout());
        main.add(top,BorderLayout.NORTH);
        main.add(middle,BorderLayout.CENTER);
        main.add(bottom,BorderLayout.SOUTH);

        // And add Main to the JFrame
        add(main);

       // generateFortune();
        setSize(400, 400);
        //frame.pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        winner = false;
        gameTied = false;
        counter = 0;
        currentPlayer = "X";

    }

    private void createTopPanel()
    {
        // Top panel

        top = new JPanel();


        label = new JLabel();
        label.setText("Tic Tac Toe!!!");
        label.setFont(new Font("Helvetica", Font.PLAIN, 36));
        label.setForeground(Color.orange);
        top.add(label);

    }

    private void createMiddlePanel()
    {
        middle = new JPanel();
        middle.setLayout(new GridLayout(3,3));
        board = new TicTacToeTile[3][3];
        for(int r= 0; r < 3; r++){
            for(int c=0; c<3; c++){
                TicTacToeTile tile = new TicTacToeTile(r,c);
                tile.setText("");
                tile.addActionListener(new ClickListener());
                middle.add(tile);
                board[r][c] = tile;
            }
        }

    }
    private void togglePlayer() {
        if (currentPlayer.equals("X")){
            currentPlayer = "O";
        } else{
            currentPlayer = "X";

        }
    }
    class ClickListener implements ActionListener
    {


        @Override
        public void actionPerformed(ActionEvent a)
        {
            TicTacToeTile tile = (TicTacToeTile) a.getSource();
            tile.setText(currentPlayer);

        }
    }

    private void createBottomPanel()
    {
        //Control Panel
        bottom = new JPanel();
        gameButton = new JButton("New Game");
        // clicker = new ClickListener();

        gameButton.addActionListener((ActionEvent ae) -> {



        });
        gameButton.setFont(new Font("Arial", Font.PLAIN, 14));
        gameButton.setForeground(Color.pink);
        quitBtn = new JButton("Quit");
        quitBtn.addActionListener((ActionEvent ae) -> {
            System.exit(0);
        });
        quitBtn.setFont(new Font("Arial", Font.PLAIN, 14));
        quitBtn.setForeground(Color.red);
        bottom.add(gameButton);
        bottom.add(quitBtn);
    }






}
