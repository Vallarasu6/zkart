package z;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class kart {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String code = "zoho";
        ArrayList<String> invoice = new ArrayList<>();
        LogicLayer logicLayer = new LogicLayer();
        Register register;
        Products products;
        Discount discount;
        HashMaphandler hashMaphandler=new HashMaphandler();
        int choice = 0;
        do{
            System.out.println("Enter your option\n1.Register\n2.Login\n3.Admin\n4.Invoice\n5.Exit");
            choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1: {
                    System.out.println("Enter the email");
                    String email = scan.nextLine();
                    System.out.println("Enter the name");
                    String name = scan.nextLine();
                    System.out.println("Enter the Mobile number");
                    long mobile = scan.nextLong();
                    scan.nextLine();
                    System.out.println("Enter your password");
                    String password = scan.nextLine();
                    System.out.println("Enter your confirm password");
                    String confirmPassword = scan.nextLine();
                    String s = logicLayer.checkPassword(password,confirmPassword);
                    if(s.equals("yes")){
                        String s1 = logicLayer.encryptPassword(password);
                        register = new Register(email,name,mobile,s1);

                        logicLayer.registerData(email,register);

                    }else {
                        System.out.println("Enter the confirm password correctly");
                    }
                    break;
                }
                case 2:{
                    System.out.println("Enter the email");
                    String email = scan.nextLine();
                    System.out.println("Enter your password");
                    String password = scan.nextLine();
                    String s = logicLayer.encryptPassword(password);
                    String s1 = logicLayer.checkLogin(email,s);
                    if(s1.equals("yes")){
                        System.out.println("welcome");
//                        HashMap<String, ArrayList<Products>> map = hashMaphandler.returnProductMap();
//                        System.out.println(hashMaphandler.returnProductMap());
                        HashMap<String, ArrayList<Products>> map =HashMaphandler.returnProductMap();
                        //System.out.println("Static return"+map);
                        //System.out.println("1");
                        System.out.println(map);

                        Set<String> set = map.keySet();
                        System.out.println(set);
                        System.out.println("ENter your choice");
                        String category = scan.nextLine();
                        ArrayList<Products> arrayList = map.get(category);
                        System.out.println(arrayList);
                        System.out.println("Enter the product");
                        String brand = scan.nextLine();
                        System.out.println("Enter the code");
                        String coupon = scan.nextLine();

                        for (int i = 0; i < arrayList.size(); i++) {
                            Products products1 = arrayList.get(i);
                            if(brand.equals(products1.getBrand())){
                                int stock = products1.getStock();
                                stock--;
                                products1.setStock(stock);
                                HashMap<String,Discount> discountHashMap = HashMaphandler.returnDiscountHashMap();
                                Discount discount1 = new Discount();
                                int initial= products1.getPrice();
                                discount1 = discountHashMap.get(email);
                                System.out.println("Discount "+discount1);
                                if(discount1==null) {
                                    HashMaphandler.customerDiscount(email,new Discount());
                                    HashMap<String,Discount> discountHashMap1 = HashMaphandler.returnDiscountHashMap();
                                    Discount discount2 = discountHashMap1.get(email);
                                    int count = discount2.getCount();
                                    count++;
                                    discount2.setCount(count);
                                    discount2.setPurchaseAmount(initial);
                                    discount2.setEmail(email);
                                    System.out.println(HashMaphandler.returnDiscountHashMap());
                                    System.out.println("You r not eligible for discount");

                                }else {
                                    if ((discount1.getCount() > 3 && discount1.getCount() < 6) || discount1.getPurchaseAmount() > 20000 && coupon.equals(code)) {
                                        int a = (int) (20 + (Math.random() * 30));
                                        int temp = initial * (a / 100);
                                        initial = initial-temp;
                                    } else if(discount1.getCount()>1){
                                        int tempCount = discount1.getCount();
                                        int tempAmount = discount1.getPurchaseAmount();
                                        tempCount++;
                                        tempAmount +=initial;
                                        discount1.setCount(tempCount);
                                        discount1.setPurchaseAmount(tempAmount);
                                        System.out.println(HashMaphandler.returnDiscountHashMap());

                                    }

                                    else {
                                        System.out.println("You r not eligible for discount");
                                    }
                                }
                                String s2 = category+" "+brand+" "+initial;
                                invoice.add(s2);
                                discount = new Discount();
                                discount.setEmail(email);
                                int count = discount.getCount();
                                count++;
                                int price = discount.getPurchaseAmount();
                                price+= products1.getPrice();
                                discount.setPurchaseAmount(price);
                                HashMaphandler.customerDiscount(email,discount);
                                //System.out.println(HashMaphandler.returnDiscountHashMap());
                            }

                        }
                        //System.out.println(map);

                    }else{
                        System.out.println(s1);
                    }
                    break;

                }
                case 3:{
                    System.out.println("Enter name");
                    String adminName  = scan.nextLine();
                    System.out.println("Enter password");
                    String adminPassword = scan.nextLine();
                    String s = logicLayer.adminLoginCheck(adminName,adminPassword);
                    if(s.equals("yes")) {
                        System.out.println("1.Add products\n2.show products");
                        int adminchoice = scan.nextInt();
                        scan.nextLine();
                        if (adminchoice == 1) {
                            System.out.println("Enter the category");
                            String category = scan.nextLine();
                            System.out.println("Enter the brand");
                            String brand = scan.nextLine();
                            System.out.println("Enter the model");
                            String model = scan.nextLine();
                            System.out.println("Enter the price");
                            int price = scan.nextInt();
                            System.out.println("Enter the stock");
                            int stock = scan.nextInt();
                            products = new Products(brand, model, price, stock);
                            logicLayer.adminInsert(category, products);


                        } else if (adminchoice == 2) {
                            HashMap<String, ArrayList<Products>> map = HashMaphandler.returnProductMap();
                            System.out.println(map);
                        }
                    }else {
                        System.out.println("Admin Check your password");
                    }
                    break;
                }
                case 4:{
                    System.out.println(invoice);
                }
            }
        }while (choice<5);
    }
}
