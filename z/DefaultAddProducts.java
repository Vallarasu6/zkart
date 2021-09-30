package z;

import java.util.ArrayList;
import java.util.HashMap;

public class DefaultAddProducts {
    HashMaphandler hashMaphandler = new HashMaphandler();
    public void add(){
        HashMap<String, ArrayList<Products>> map =  hashMaphandler.returnProductMap();

    }
}
