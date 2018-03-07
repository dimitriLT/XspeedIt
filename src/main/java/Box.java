import java.util.ArrayList;
import java.util.List;

public class Box implements Cloneable {

    private List<Item> itemList;

    public Box() {
        itemList = new ArrayList<>();
    }

    public Box(List<Item> items) {
        itemList = items;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public Box clone() {
        Box box = new Box();
        List<Item> items = new ArrayList<>(itemList.size());
        for (Item item : itemList){
            items.add(item.clone());
        }
        box.itemList.addAll(items);
        return box;
    }
}
