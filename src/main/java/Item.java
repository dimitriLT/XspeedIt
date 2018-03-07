import java.util.Objects;
import java.util.logging.Logger;

public class Item implements Comparable<Item>, Cloneable {

    private static final Logger LOGGER = Logger.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
    private int size;

    public Item(int size) {
        if (size == 0) {
            LOGGER.warning("The size item should be upper than 0");
        } else {
            this.size = size;
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public int compareTo(Item item) {
        return Integer.compare(size, item.size);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return size == item.size;
    }

    @Override
    public int hashCode() {

        return Objects.hash(size);
    }

    public Item clone() {
        Item item = null;
        try {
            item = (Item) super.clone();
        } catch (CloneNotSupportedException cnse) {
            cnse.printStackTrace(System.err);
        }
        return item;
    }
}
