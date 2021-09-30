package z;

import java.util.HashMap;

public class LogicLayer {
    String adminName = "a";
    String adminPass = "a";
    Database database = new Database();
    HashMaphandler hashMaphandler = new HashMaphandler();
    public String checkPassword(String password, String confirmPassword){
        if(password.equals(confirmPassword)){
            return "yes";
        }else{
            return "no";
        }
    }

    public String encryptPassword(String password){
        String pass = password;
        char encrypt_password[] = pass.toCharArray();
        for (int i = 0; i < encrypt_password.length; i++) {
            if(encrypt_password[i]!='9') {
                int temp = encrypt_password[i];
                encrypt_password[i] = (char) (temp + 1);
//                System.out.println(encrypt_password);
           }else{
                encrypt_password[i]='0';

            }
        }
       return String.valueOf(encrypt_password);
    }
    public void registerData(String email, Register register){
        HashMap<String,Register> map =hashMaphandler.returnHashMap();
        if(map.containsKey(email)){
            System.out.println("You are a existing user");
        }else {
            hashMaphandler.store(email, register);
            database.insertRegister(register);
        }
    }

    public String checkLogin(String email,String s){
        HashMap<String,Register> map =  hashMaphandler.returnHashMap();
        if(map.containsKey(email)){
            Register register = map.get(email);
           if(s.equals(register.getPassword())){
               return "yes";
           }else {
               return "Password is wrong";
           }
        }else{
            return "Not registered or email id wrong";
        }

    }
    public void adminInsert(String category, Products products){
        hashMaphandler.storeProducts(category,products);
    }
    public String adminLoginCheck(String name, String password){
        if(name.equals(adminName) && password.equals(adminPass)){
            return "yes";
        }else {
            return "no";
        }
    }
}
