package Game;

/**
 * Represents a side in dots and boxes
 */
public class Side {
    private boolean claimed;

    public Side() {
        this.claimed = false;
    }

    public boolean setClaimed() {
        if(!getClaimed()) {
            this.claimed = true;
            return true;
        } else {
            return false;
        }
    }

    public boolean getClaimed() {
        return this.claimed;
    }
}
