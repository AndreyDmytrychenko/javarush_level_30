package task33.task3308;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@XmlType(name = "shop")
@XmlRootElement
public class Shop {


    public Goods goods;
    public int count;
    public double profit;
    public String[] secretData;


    public static class Goods {

       public List<String> names = new ArrayList<>();

        @Override
        public String toString() {
            return "Goods{" +
                    "names=" + names +
                    '}';
        }
        public Goods() {

        }
    }

    @Override
    public String toString() {
        return "Shop{" +
                "goods=" + goods +
                ", count=" + count +
                ", profit=" + profit +
                ", secretData='" + Arrays.toString(secretData)
                + '\'' +
                '}';
    }
    public Shop() {

    }
}
