import java.util.*;

/**
 * A very stupid computer strategy, everything random. In order to make this
 * smarter, you would need a Board method that lets the computer know whether
 * the most recent firing hit a ship and/or some information about the progress
 * of the game.
 * 
 * @author Dan Longo
 */
public class BattleshipAI {

    /** computer game board */
    private Board computerBoard;

    /** random number generator */
    private Random rand;

    /**
     * Constructor initializes instance variables, sets up the random number
     * sequence based on the provided seed and places the ships
     * 
     * @param computerBoard the computer's game board; used for placing the ships
     * @param shipLengths   lengths of ships used in the game
     * @param seed          the random number seed
     */
    public BattleshipAI(Board computerBoard, int[] shipLengths, long seed) {
        this.computerBoard = computerBoard;
        rand = new Random(seed);
        setUpShips(shipLengths);
    }

    /**
     * Constructor initializes instance variables, sets up the random number
     * sequence and places the ships
     * 
     * @param computerBoard the computer's game board; used for placing the ships
     * @param shipLengths   lengths of ships used in the game
     */
    public BattleshipAI(Board computerBoard, int[] shipLengths) {
        this.computerBoard = computerBoard;
        rand = new Random();
        setUpShips(shipLengths);
    }

    /**
     * Sets up ships in a random fashion
     * 
     * @param shipLengths lengths of ships used in the game
     */
    private void setUpShips(int[] shipLengths) {
        for (int i = 0; i < shipLengths.length; i++) {
            boolean successful = false;
            while (!successful) {
                int orientation = rand.nextInt(2);
                boolean horizontal = true;
                if (orientation == 1) {
                    horizontal = false;
                }
                int row = rand.nextInt(computerBoard.getNumberOfRows());
                int col = rand.nextInt(computerBoard.getNumberOfColumns());
                if (computerBoard.addShip(shipLengths[i], horizontal, row, col)) {
                    successful = true;
                }
            }
        }
    }

    /**
     * Chooses a random position for firing at the board of the human player
     * 
     * @param humanBoard human player's board
     */
    public void fireAtHumanBoard(Board humanBoard) {
        boolean successful = false;
        while (!successful) {
            int row = rand.nextInt(computerBoard.getNumberOfRows());
            int col = rand.nextInt(computerBoard.getNumberOfColumns());
            if (!humanBoard.hasBeenHit(row, col)) {
                humanBoard.fireAtLocation(row, col);
                successful = true;
            }
        }
    }
}
