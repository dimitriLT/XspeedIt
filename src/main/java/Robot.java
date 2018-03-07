import java.util.Collections;
import java.util.stream.Collectors;

public class Robot {

    private static final int MAX_SIZE_ITEM = 10;

    public static String getActuel(Box box) {
        int setOfTen = 0;
        int nbBox = 1;
        StringBuilder stringItemListActuel = new StringBuilder("Robot actuel    : ");


        for (int i = 0; i < box.getItemList().size(); i++) {

            setOfTen = setOfTen + box.getItemList().get(i).getSize();

            if (i + 1 < box.getItemList().size() && setOfTen + box.getItemList().get(i + 1).getSize() > 10) {
                stringItemListActuel.append(box.getItemList().get(i).getSize());
                stringItemListActuel.append("/");
                setOfTen = 0;
                nbBox++;
            } else {
                stringItemListActuel.append(box.getItemList().get(i).getSize());
            }


        }
        return String.valueOf(stringItemListActuel) + " => " + nbBox + " cartons utilises";

    }

    public static String getOptimise(Box box) {
        int nbBox = 1;

        StringBuilder stringItemListOptimize = new StringBuilder("Robot optimise : ");
        Collections.sort(box.getItemList());

        Box boxCopy = box.clone();

        Item maxComplementItem;

        for (int i = box.getItemList().size() - 1; i >= box.getItemList().size() / 2; i--) {
            Item higherItem = box.getItemList().get(i);
            maxComplementItem = new Item(MAX_SIZE_ITEM - higherItem.getSize());

            if (boxCopy.getItemList().contains(maxComplementItem)) {
                stringItemListOptimize.append(higherItem.getSize()).append(maxComplementItem.getSize()).append("/");
                boxCopy.getItemList().remove(boxCopy.getItemList().indexOf(higherItem));
                boxCopy.getItemList().remove(boxCopy.getItemList().indexOf(maxComplementItem));
                nbBox++;


            } else if (boxCopy.getItemList().size() != 1) {
                for (int j = maxComplementItem.getSize(); j > 0; j--) {
                    Item currentItem = new Item(j);
                    if (boxCopy.getItemList().contains(currentItem)) {
                        stringItemListOptimize.append(higherItem.getSize()).append(j).append("/");
                        boxCopy.getItemList().remove(boxCopy.getItemList().indexOf(higherItem));
                        boxCopy.getItemList().remove(boxCopy.getItemList().indexOf(currentItem));
                        nbBox++;
                        break;
                    }
                }
            }
        }

        stringItemListOptimize.append(boxCopy.getItemList().stream().map(i -> String.valueOf(i.getSize())).collect(Collectors.joining("/")));


        return stringItemListOptimize + " => " + nbBox + " cartons utilises";
    }

}
