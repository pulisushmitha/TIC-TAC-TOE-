import java.util.Arrays;
import java.util.Scanner;

public class EnhancedTicTac {
    private static final int Size = 9; //Constant for total board cells (3x3 = 9).
    // Using a constant makes the code easier to change and read.
    private static final Scanner input = new Scanner(System.in);

    private String[] board = new String[Size];
    private String turn; // X or O

    public static void main(String[] args) {
        EnhancedTicTac game = new EnhancedTicTac();
        game.run();
        input.close();
    }

    /**
     * Top-level game loop which supports replaying matches.
     */
    private void run(){
        //Top-level method that manages repeated matches and overall program flow.
        System.out.println("Welcome to Tic Tac Toe Game.");
        boolean playAgain; //Variable used to control the replay loop.

        //A do/while loop that runs at least once and repeats if the players choose to play again.
        do {
            resetBoard();
            turn = askPlayerTurn();
            System.out.println(turn + " will play first.");
            printBoard();

            String winner = playSingleMatch();

            //Show final result
            if ("draw".equalsIgnoreCase(winner)){
                System.out.println("It's a draw! Thanks for playing.");
            }else {
                System.out.println("Congratulations! " +winner+ " has won! Thanks for playing.");
            }

            //Ask player if they want to play again
            playAgain = askYesOrNo("Do you want to play again ? (Y/N)");
        }while (playAgain);

        System.out.println("Thanks for playing the game.");
    }

    /**
     * Plays a single match until there's a winner or a draw. Returns "X", "O", or "draw".
     */
    private String playSingleMatch(){
        String winner = null;

        while (winner == null){
            System.out.println(turn + " 's turn; Enter a slot number to place " + turn + " in (1-9): ");
            int numInt = readSlotNumber();

            if (numInt < 1 || numInt >9){
                System.out.println("Invalid input: please enter a number between 1 to 9.");
                continue;
            }

            //Check if slot is available
            if (board[numInt - 1].equals(String.valueOf(numInt))) {
                board[numInt - 1] = turn;
            } else {
                System.out.println("Slot already taken; re-enter slot number.");
                continue; // Skip rest of loop and re-ask for input
            }

            // Show board after a valid move
            printBoard();

            // Check if someone has won or if it's a draw
            winner = checkWinner();

            // If no winner yet, switch turns
            if (winner == null) {
                turn = turn.equals("X") ? "O" : "X";
            }

        }
        return winner;
    }

    /**
     * Ask user whether X or O plays first.
     */
    private String askPlayerTurn(){
        while (true){
            System.out.println("Who should play first ? (X/O): ");
            String inputXO = input.nextLine().trim().toUpperCase();
            if (inputXO.equals("X") || inputXO.equals("O")){
                return inputXO;
            }
            System.out.println("Invalid choice. Please type X or O.");
        }
    }


    /**
     * Read an integer slot number robustly, handling non-integer input.
     */
    private int readSlotNumber(){
        while (true){
            try{
                int n = Integer.parseInt(input.nextLine().trim());
                return n;
            }catch (NumberFormatException e){
                System.out.println("Invalid input; please enter a number (1-9): ");
            }
        }
    }

    /**
     * Reset board to initial numeric labels 1..9.
     */
    private void resetBoard(){
        for (int i=0; i<Size; i++){
            board[i] = String.valueOf(i+1);
        }
    }

    /**
     * Check for a winner or draw. Returns "X", "O", "draw" or null if the game should continue.
     */
    private String checkWinner(){
        //2D array lists all possible winning positions
        int[][] lines = {
                //Each small array {a,b,c} represents indices in the board[] array
                // that form a line (row, column, or diagonal).
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Rows
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columns
                {0, 4, 8}, {2, 4, 6}             // Diagonals
        };

        //It picks the three symbols from the board at those positions.
        //
        //Example: for {0,1,2}, it checks board[0], board[1], and board[2].
        for (int[] line : lines){
            String a = board[line[0]];
            String b = board[line[1]];
            String c = board[line[2]];

            //It joins those three symbols into one string (like "XXX", "OOO", or "X1O").
            String triplet = a+b+c;
            if ("XXX".equals(triplet)) return "X";
            if ("OOO".equals(triplet)) return "O";
        }
        // Check if any cell still has a number (game still in progress)
        boolean anyNumericLeft = Arrays.stream(board).anyMatch(s -> s.matches("\\d"));
        if (!anyNumericLeft) return "draw";
//s.matches("\\d") checks if the string s is still a single digit (meaning it’s an unused slot).
//If no numeric cells remain, it means the board is full and no one has won → return "draw".
        return null;
    }

    /**
     * Print the board in a readable 3x3 format.
     */
    private void printBoard() {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("|---|---|---|");
    }

    /**
     * Ask user a yes/no question and return true for yes, false for no.
     */
    private boolean askYesOrNo(String ans) {
        while (true) {
            System.out.print(ans);
            String line = input.nextLine().trim().toLowerCase();
            if (line.isEmpty()) continue;
            char ch = line.charAt(0);
            if (ch == 'y') return true;
            if (ch == 'n') return false;
            System.out.println("Please type Y or N.");
        }
    }
}