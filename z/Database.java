package z;

import java.sql.*;

public class Database {
    static Connection con=null;
    Database(){
        try {
            if(con==null){
                //Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/zkart","root","vallaK@6");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void insertRegister(Register register){

        try {
            PreparedStatement st=null;
        Register register1 = register;
        String email  = register1.getEmail();
        String name = register1.getName();
        long mobile = register1.getMobile();
        String password = register1.getPassword();

String query = "INSERT INTO register (email,name,mobile,password) VALUES(?,?,?,?)";
            st = con.prepareStatement(query);
            st.setString(1,email);
            st.setString(2,name);
            st.setLong(3,mobile);
            st.setString(4,password);
            st.execute();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
