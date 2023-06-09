import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class HigherLowerCardGameUI {
    private List<String> deck;
    private int score;
    private int attempts;
    private JFrame frame;
    private JLabel cardLabel;
    private JButton higherButton;
    private JButton lowerButton;
    private JButton quitButton;
    private JLabel scoreLabel;
    private JLabel attemptsLabel;

    public static void main(String[] args) {
        HigherLowerCardGameUI game = new HigherLowerCardGameUI();
        game.start();
    }

    public void start() {
        deck = createDeck();
        Collections.shuffle(deck);

        score = 0;
        attempts = 0;

        frame = new JFrame("Higher or Lower Card Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        cardLabel = new JLabel();
        cardLabel.setFont(new Font("Arial", Font.BOLD, 50));
        cardLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(cardLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();

        higherButton = new JButton("Higher");
        higherButton.addActionListener(new ButtonListener());
        buttonPanel.add(higherButton);

        lowerButton = new JButton("Lower");
        lowerButton.addActionListener(new ButtonListener());
        buttonPanel.add(lowerButton);

        quitButton = new JButton("Quit");
        quitButton.addActionListener(new ButtonListener());
        buttonPanel.add(quitButton);

        panel.add(buttonPanel, BorderLayout.SOUTH);

        scoreLabel = new JLabel("Score: 0");
        attemptsLabel = new JLabel("Attempts: 0");

        panel.add(scoreLabel, BorderLayout.WEST);
        panel.add(attemptsLabel, BorderLayout.EAST);

        frame.getContentPane().add(panel);
        frame.setSize(400, 250);
        frame.setVisible(true);

        updateCard();
    }

    private void updateCard() {
        if (deck.isEmpty()) {
            showGameOverDialog();
            return;
        }

        String currentCard = deck.remove(0);
        cardLabel.setText(currentCard);

        if (deck.isEmpty()) {
            showGameOverDialog();
        }

        attempts++;
        attemptsLabel.setText("Attempts: " + attempts);
    }

    private void showGameOverDialog() {
        JOptionPane.showMessageDialog(frame, "No more cards in the deck.\nGame Over!\nFinal Score: " + score);
        System.exit(0);
    }

    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            String guess = "";

            if (source == higherButton) {
                guess = "H";
            } else if (source == lowerButton) {
                guess = "L";
            } else if (source == quitButton) {
                System.exit(0);
            }

            String currentCard = cardLabel.getText();
            String nextCard = deck.get(0);

            if (compareCards(currentCard, nextCard, guess)) {
                score++;
                scoreLabel.setText("Score: " + score);
            } else {
                showGameOverDialog();
            }

            updateCard();
        }
    }

    private static List<String> createDeck() {
        List<String> deck = new ArrayList<>();
        String[] suits = {"♠", "♥", "♦", "♣"};
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

        for (String suit : suits) {
            for (String rank : ranks) {
                deck.add(rank + suit);
            }
        }

        return deck;
    }

    private static boolean compareCards(String currentCard, String nextCard, String guess) {
        int currentCardValue = getCardValue(currentCard);
        int nextCardValue = getCardValue(nextCard);

        if (guess.equals("H")) {
            return nextCardValue > currentCardValue;
        } else if (guess.equals("L")) {
            return nextCardValue < currentCardValue;
        }

        return false;
    }

    private static int getCardValue(String card) {
        String rank = card.substring(0, card.length() - 1);

        if (rank.equals("A")) {
            return 1;
        } else if (rank.equals("J") || rank.equals("Q") || rank.equals("K")) {
            return 10;
        } else {
            return Integer.parseInt(rank);
        }
    }
}
