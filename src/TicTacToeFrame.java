import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class TicTacToeFrame extends JFrame {
    private ArrayList<String> fortunes;

    JPanel main, top, middle, bottom;
    JLabel label;
    JButton fortuneButton, quitBtn;
    JTextArea fortune;
    JScrollPane scrollPane;

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
        main.add(scrollPane,BorderLayout.CENTER);
        main.add(bottom,BorderLayout.SOUTH);

        // And add Main to the JFrame
        add(main);

        generateFortune();
        setSize(400, 400);
        //frame.pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



    }

    private void createTopPanel()
    {
        // Top panel

        top = new JPanel();
//        ImageIcon temp = new ImageIcon(this.getClass().getResource("fortunetellerpic.jpg"));
//        ImageIcon fortuneTeller = new ImageIcon(temp.getImage().getScaledInstance(100,100,Image.SCALE_SMOOTH));

        label = new JLabel();
//      label.setIcon(fortuneTeller);
        label.setText("Fortune Teller!");
        label.setFont(new Font("Helvetica", Font.PLAIN, 36));
        label.setForeground(Color.orange);
        top.add(label);

    }
    private void createMiddlePanel()
    {
        this.fortune = new JTextArea();
        this.scrollPane = new JScrollPane(this.fortune);
    }

    private void createBottomPanel()
    {
        //Control Panel
        bottom = new JPanel();
        fortuneButton = new JButton("New Game");
        // clicker = new ClickListener();

        fortuneButton.addActionListener((ActionEvent ae) -> {

            Random rnd = new Random();
            String nextFortune = fortunes.get(rnd.nextInt(fortunes.size())) + "\n";

            while (fortune.getText().endsWith(nextFortune)) {
                nextFortune = fortunes.get(rnd.nextInt(fortunes.size())) + "\n";
            }

            fortune.append(nextFortune);


        });
        fortuneButton.setFont(new Font("Arial", Font.PLAIN, 14));
        fortuneButton.setForeground(Color.pink);
        quitBtn = new JButton("Quit");
        quitBtn.addActionListener((ActionEvent ae) -> {
            System.exit(0);
        });
        quitBtn.setFont(new Font("Arial", Font.PLAIN, 14));
        quitBtn.setForeground(Color.red);
        bottom.add(fortuneButton);
        bottom.add(quitBtn);
    }
    private void generateFortune(){
        this.fortunes = new ArrayList<String>(12);
        fortunes.add("You will get eaten by a bear");
        fortunes.add("You might get robbed");
        fortunes.add("You will be friendless");
        fortunes.add("Tomorrow you are not gonna get dessert");
        fortunes.add("You are gonna fail your math quiz (sorry)");
        fortunes.add("Everyone is gonna start putting pineapples on pizza");
        fortunes.add("You will be poor");
        fortunes.add("There won't be a tomorrow");
        fortunes.add("UC Tuition is gonna be raised");
        fortunes.add("Gonna be broke because of college debt");
        fortunes.add("Minions are coming for you");
        fortunes.add("You gonna be homeless");
    }




}
