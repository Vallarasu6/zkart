package z;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMaphandler {
    HashMap<String,Register> map = new HashMap<>();
    public void store(String email, Register register){

            map.put(email,register);
            System.out.println(map);

    }
    public HashMap<String,Register> returnHashMap(){
        return map;
    }



    public static HashMap<String, ArrayList<Products>> productMap = new HashMap<>();
    ArrayList<Products> arrayList = new ArrayList<>();
    public void storeProducts(String category, Products products){

        if(productMap.containsKey(category)){
           ArrayList<Products> a =  productMap.get(category);
           a.add(products);
            System.out.println("ALready "+productMap);
        }else{
            arrayList.add(products);
            productMap.put(category,arrayList);
            System.out.println("New "+productMap);
        }



    }
    public static HashMap<String, ArrayList<Products>> returnProductMap(){
        System.out.println("Return "+productMap);
        return productMap;
    }
    public static HashMap<String,Discount> discountHashMap = new HashMap<>();

    public static void customerDiscount(String email, Discount discount){
         discountHashMap.put(email,discount);
    }
    public static HashMap<String,Discount> returnDiscountHashMap(){
        return discountHashMap;
    }
}
