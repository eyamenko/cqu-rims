package yamenko.rims;

/**
 * Ratings for Product entity.
 */
public enum Rating {
    PG("PG"), G("G"), M("M"), MPlus("M+"), R("R");

    /*
    * Attributes
    * */

    private String stringRepresentation;

    /*
    * Constructors
    * */

    Rating(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }

    @Override
    public String toString() {
        return this.stringRepresentation;
    }

    /*
    * Getters & Setters
    * */

    public String getStringRepresentation() {
        return stringRepresentation;
    }

    public void setStringRepresentation(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }
}
