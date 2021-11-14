public class Board {
    private int numberOfRows;
    private int numberOfColumns;
    private Square[][] grid;
    private int maximumNumberOfShips;
    private Ship[] ships;
    private int numberOfShips;

    /**
     * 
     * @param numberOfRows
     * @param numberOfColumns
     * @param maximumNumberOfShips
     */
    public Board(int numberOfRows, int numberOfColumns, int maximumNumberOfShips) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.maximumNumberOfShips = maximumNumberOfShips;
        if (numberOfRows < 1) {
            throw new IllegalArgumentException("Invalid rows");
        }

        if (numberOfColumns < 1) {
            throw new IllegalArgumentException("Invalid cols");
        }

        if (maximumNumberOfShips < 1) {
            throw new IllegalArgumentException("Invalid ships");
        }
    }

    /**
     * 
     * @return
     */
    public int getNumberOfRows() {
        return numberOfRows;
    }

    /**
     * 
     * @return
     */
    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    /**
     * 
     * @return
     */
    public int getNumberOfShips() {
        return numberOfShips;
    }

    /**
     * 
     * @param length
     * @param isHorizontal
     * @param startRow
     * @param startCol
     * @return
     */
    public boolean addShip(int length, boolean isHorizontal, int startRow, int startCol) {
        Ship ship = new Ship(length, isHorizontal, startRow, startCol);
        Ship[] ships = new Ship[maximumNumberOfShips];
        grid = new Square[getNumberOfRows()][getNumberOfColumns()];

        // Throw statements
        if (length < 1) {
            throw new IllegalArgumentException("Invalid length");
        }

        if (startRow < 0 || startRow >= numberOfRows) {
            throw new IllegalArgumentException("Invalid row");
        }

        if (startCol < 0 || startCol >= numberOfColumns) {
            throw new IllegalArgumentException("Invalid col");
        }

        // ER

        if (isHorizontal) {

            if (ships.length > maximumNumberOfShips) {
                return false;
            } else {
                for (int i = 0; i < length - 1; i++) {
                    if (grid[startRow][startCol + i].hasShip()) {
                        return false; // Return false if one of the squares has a ship
                    } else {
                        grid[startRow][startCol + i].addShip(ship);
                    }
                }
                ships[numberOfShips] = ship;
                numberOfShips++;
                return true;

            }
        } else {
            if (ships.length > maximumNumberOfShips) {
                return false;
            } else {
                for (int i = 0; i < length - 1; i++) {
                    if (grid[startRow + i][startCol].hasShip()) {
                        return false;
                    } else {
                        grid[startRow + i][startCol].addShip(ship);
                    }
                }
                ships[numberOfShips] = ship;
                numberOfShips++;
                return true;
            }
        }

        // if (isHorizontal) {
        // for (int i = 1; i < length + 1; i++) {
        // if (startCol + i >= numberOfColumns) {
        // return false;
        // }

        // if (grid[startRow][startCol + i].hasShip()) {
        // return false; // Return false if one of the squares has a ship
        // }
        // }

        // for (int i = 0; i < length + 1; i++) {
        // grid[startRow][startCol + i].addShip(ship);
        // }

        // } else {
        // for (int i = 0; i < length + 1; i++) {
        // if (startRow + i >= numberOfRows) {
        // return false;
        // }

        // if (grid[startRow + i][startCol].hasShip()) {
        // return false;
        // }
        // }

        // for (int i = 0; i < length + 1; i++) {
        // grid[startRow + i][startCol].addShip(ship);
        // }
        // }

        // ships[numberOfShips] = ship;
        // numberOfShips++;
        // return true;

    }

    /**
     * 
     * @param row
     * @param col
     * @return
     */
    public Ship getShip(int row, int col) {
        // Throw statements
        if (row < 0 || row >= numberOfRows) {
            throw new IllegalArgumentException("Invalid row");
        }

        if (col < 0 || col >= numberOfColumns) {
            throw new IllegalArgumentException("Invalid col");
        }

        // Checks whether square contains a ship
        if (grid[row][col].hasShip()) {
            return grid[row][col].getShip();
        } else {
            return null;
        }

    }

    /**
     * 
     * @return
     */
    public Ship[] getShips() {
        return ships;
    }

    /**
     * 
     * @param row
     * @param col
     * @return
     */
    public boolean fireAtLocation(int row, int col) {
        grid = new Square[getNumberOfRows()][getNumberOfColumns()];

        // Throw statements
        if (row < 0 || row >= numberOfRows) {
            throw new IllegalArgumentException("Invalid row");
        }
        if (col < 0 || col >= numberOfColumns) {
            throw new IllegalArgumentException("Invalid col");
        }

        // First check whether the square has already been hit or not
        if (grid[row][col].hasBeenHit()) {
            return false;
        } else {
            grid[row][col].fireAt();
            return true;
        }

    }

    /**
     * 
     * @param row
     * @param col
     * @return
     */
    public boolean hasBeenHit(int row, int col) {
        // Throw statements
        if (row < 0 || row >= numberOfRows) {
            throw new IllegalArgumentException("Invalid row");
        }
        if (col < 0 || col >= numberOfColumns) {
            throw new IllegalArgumentException("Invalid col");
        }

        if (grid[row][col].hasBeenHit()) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * 
     * @return
     */
    public boolean areAllShipsSunk() {
        boolean Sunk = true;
        for (int i = 0; i < ships.length; i++) {
            if (ships[i].isSunk() == false) {
                Sunk = false;
            }
        }
        return Sunk;
    }

    /**
     * @return output
     */
    public String toString() {
        String output = "";

        return output;
    }

}
