
import java.util.*;
import java.util.stream.Collectors;

public class Xspeedlt {

    public static void main(String[] arg) {

        String stringItemList = "163841689525773";
        Box box = new Box(Arrays.stream(stringItemList.split("\\B"))
                .map(s -> new Item(Integer.valueOf(s)))
                .collect(Collectors.toList()));

        System.out.println("Articles      : " + stringItemList);
        System.out.println(Robot.getActuel(box));
        System.out.println(Robot.getOptimise(box));
    }
}
