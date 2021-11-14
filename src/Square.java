package src;

public class Square {
    private boolean hasBeenHit;
    private Ship ship;

    /**
     * Constructor for Square class
     */
    public Square() {
        hasBeenHit = false;
        ship = null;
    }

    public boolean hasBeenHit() {
        return hasBeenHit;
    }

    public void addShip(Ship ship) {
        this.ship = ship;
    }

    public boolean hasShip() {
        if (ship == null) {
            return false;
        } else {
            return true;
        }
    }

    public Ship getShip() {
        if (hasShip() == true) {
            return ship;
        } else {
            return null;
        }
    }

    public void fireAt() {
        if (hasBeenHit() == true) {
            throw new IllegalStateException("Already hit");
        }
        if (hasShip() == true) {
            ship.hit();
        }

        hasBeenHit = true;
    }

    public boolean equals(Object o) {
        if (o instanceof Square) {
            Square b = (Square) o;
            if (this.hasBeenHit == b.hasBeenHit()) {
                if (this.hasShip() && b.hasShip()) {
                    if (this.getShip().equals(b.getShip())) {
                        return true;
                    }
                } else if (this.hasShip() != b.hasShip()) {
                    return false;
                } else {
                    return true;
                }
            }
        } else {
            return false;
        }
        return false;
    }

    public String toString() {

    }

}
