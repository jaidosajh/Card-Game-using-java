## Higher or Lower Card Game

The "Higher or Lower Card Game" is a simple card game implemented in Java. The objective of the game is to guess whether the next card in a shuffled deck of playing cards will be higher or lower in value compared to the current card. The player earns points for correct guesses and the game continues until there are no more cards in the deck or the player makes an incorrect guess.

### Game Rules

1. The game starts with a shuffled deck of 52 playing cards.
2. The player is presented with the first card from the deck.
3. The player must guess whether the next card will be higher (H) or lower (L) in value compared to the current card.
4. The player earns one point for each correct guess.
5. If the player makes an incorrect guess, the game ends, and the final score is displayed.
6. The player can choose to quit the game at any time by clicking the "Quit" button.
7. If the player correctly guesses all the cards in the deck, a message is displayed indicating that there are no more cards, and the game ends.

### Prerequisites

To run the "Higher or Lower Card Game," you need to have Java Development Kit (JDK) installed on your machine. You can download the latest version of JDK from the official Oracle website: [Java SE Downloads](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)

### How to Run the Game

1. Open a text editor and create a new Java file.
2. Copy the code from the file `HigherLowerCardGameUI.java` into your newly created Java file.
3. Save the file with a `.java` extension, for example, `HigherLowerCardGame.java`.
4. Open a command prompt or terminal and navigate to the directory where you saved the Java file.
5. Compile the Java file by running the following command:
   ```
   javac HigherLowerCardGame.java
   ```
6. After a successful compilation, run the game by executing the following command:
   ```
   java HigherLowerCardGame
   ```

### User Interface

The game features a graphical user interface (GUI) created using Java's Swing library. The GUI provides the player with a window displaying the current card, buttons for making guesses, and labels for the score and number of attempts.


- **Current Card Label**: Displays the current card from the deck.
- **Higher Button**: Click this button to guess that the next card will be higher in value.
- **Lower Button**: Click this button to guess that the next card will be lower in value.
- **Quit Button**: Click this button to exit the game.
- **Score Label**: Displays the current score.
- **Attempts Label**: Displays the number of attempts made.

### Customization and Extension

The code provides a basic implementation of the "Higher or Lower Card Game." You can customize and extend the game according to your requirements. Here are some ideas for customization and extension:

- Add additional graphical elements such as backgrounds, card animations, or sound effects to enhance the user experience.
- Modify the scoring system to assign different point values based on the difficulty of the guess (e.g., higher-value cards earn more points).
- Implement a high score system to track and display the top scores achieved by different players.
- Introduce time limits for making guesses, creating a time-based challenge.
- Add levels of difficulty by adjusting the number of cards in the deck or introducing special cards with unique effects.

####Feel free to experiment and make the game your own by implementing additional features or customizations! and if you believe thatI can make this better then please let me know and i will make the neccesary updates and changes.

