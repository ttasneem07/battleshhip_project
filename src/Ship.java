package src;

public class Ship {
    private int length;
    private int hits;
    private boolean isHorizontal;
    private int startRow;
    private int startCol;

    /**
     * Ship constructor
     * 
     * @param length       length of ship
     * @param isHorizontal returns orientation of ship
     * @param startRow     returns row of upper left hand corner
     * @param startCol     returns column of uper left hand corner
     */
    public Ship(int length, boolean isHorizontal, int startRow, int startCol) {
        hits = 0;
        this.length = length;
        this.isHorizontal = isHorizontal;
        this.startRow = startRow;
        this.startCol = startCol;

        if (length < 1) {
            throw new IllegalArgumentException("Invalid length");
        }

        if (startRow < 0) {
            throw new IllegalArgumentException("Invalid row");
        }

        if (startCol < 0) {
            throw new IllegalArgumentException("Invalid col");
        }

    }

    /**
     * gets length of ship
     * 
     * @return length of ship
     */
    public int getLength() {
        return length;

    }

    /**
     * 
     * @return startRow row of upper left hand corner
     */
    public int getStartRow() {
        return startRow;
    }

    public int getStartCol() {
        return startCol;
    }

    public boolean isHorizontal() {
        return isHorizontal;
    }

    public boolean isSunk() {
        if (hits == length) {
            return true; // Ship is sunk if hits is the same as length
        } else {
            return false; // Return false otherwise
        }
    }

    public void hit() {
        length -= 1;

        if (length < 0) {
            throw new IllegalStateException("Too many hits");
        }

    }

    public boolean equals(Object o) {
        if ((o instanceof Ship) && (this.length == length) && (this.isHorizontal == isHorizontal)
                && (this.startRow == startRow) && (this.startCol == startCol)) {
            return true;
        } else {
            return false;
        }

    }

    public String toString() {
        String output = "";
        String Orientation = "";
        String numOfHits = "";
        String sunkTF = "";

        // uses isHorizontal() Method
        if (isHorizontal()) {
            Orientation = "Horizontal";
        } else {
            Orientation = "Vertical";
        }

        // Returns boolean of isSunk() as String
        if (isSunk()) {
            sunkTF = "true";
        } else {
            sunkTF = "false";
        }

        numOfHits = String.valueOf(length);

        // Puts number of hits into string

        output = "Length: " + length + "\n" + "Location: (" + startRow + "," + startCol + ")\n" + "Orientation: "
                + Orientation + "\n" + "Number of hits: " + numOfHits + "\n" + "Sunk: " + sunkTF + "\n";

        return output;
    }
}
