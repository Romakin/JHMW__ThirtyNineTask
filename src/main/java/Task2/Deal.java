package Task2;

public class Deal {

    private int width;
    private int length;
    private long cost;

    public Deal(int width, int length, long cost) {
        this.width = width;
        this.length = length;
        this.cost = cost;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public long getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Deal " +
                "width: " + width +
                ", length: " + length +
                ", cost: " + cost;
    }
}
