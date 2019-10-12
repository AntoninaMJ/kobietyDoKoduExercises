package kobietyDoKodu;

import java.util.ArrayList;
import java.util.List;

public class CatDAO {

    private List<Cat> cats;

    public CatDAO() {
        this.cats = new ArrayList<Cat>();
    }

    public void addCat(Cat kot){
        this.cats.add(kot);
        System.out.println("Dziękuję, dodałeś kota do kolekcji!");
    }

    public List<Cat> getCats(){
        return cats;
    }
}
