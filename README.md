# Tic Tac Toe Game

This is a simple Tic Tac Toe game implemented in Java using Swing for the graphical user interface. The game allows two players to take turns placing their marks ("X" and "O") on a 3x3 grid. The first player to get three marks in a row (horizontally, vertically, or diagonally) wins the game.

## Features

- 3x3 grid for the Tic Tac Toe game.
- Two-player mode: Players take turns to place "X" and "O".
- A player wins if they get three of their marks in a row.
- Automatically removes the oldest mark if a player tries to place a fourth mark.
- Displays a message indicating the winner and closes the game when the message window is closed.

## How to Run

1. **Prerequisites**: Make sure you have Java installed on your machine. You can download it from [here](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).

2. **Download the Code**: Clone or download this repository to your local machine.

3. **Compile the Code**: Open a terminal (or command prompt) and navigate to the directory where you saved the code. Run the following command to compile the Java file:

    ```bash
    javac Main.java
    ```

4. **Run the Game**: After compiling, run the game with the following command:

    ```bash
    java Main
    ```

## Code Explanation

Here is a brief overview of the code:

- **Main Class**: The entry point of the application.
- **JFrame**: The main window of the game.
- **JPanel**: Used to create a grid layout for the buttons.
- **JButton**: Each cell in the Tic Tac Toe grid is a button.
- **ActionListener**: Handles the click events for the buttons.
- **Queue**: Used to keep track of the last three moves for each player.

### Game Logic

- The game starts with "X" as the first player.
- Players take turns to place their marks on the grid by clicking on the buttons.
- If a player tries to place a fourth mark, the oldest mark of that player is removed.
- The game checks for a winner after each move. If a player has three marks in a row, a message is displayed indicating the winner and the game window closes when the message window is closed.

### Button Styling

- The buttons have a matte black background with a gradient effect to give them a 3D look.
- The text on the buttons is white and bold.

## Example Usage

1. Player X clicks on an empty cell to place an "X".
2. Player O clicks on an empty cell to place an "O".
3. If Player X or O has three marks in a row, a message is displayed indicating the winner.
4. The game window closes when the message window is closed.
