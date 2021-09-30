package z;

import java.io.*;

public class file {
    BufferedWriter buffer;
    FileWriter writer;
    file() throws IOException {
        File files = new File("/home/inc15/z-kart/zusers_db.txt");
        files.createNewFile();
        System.out.println(files);
        writer = new FileWriter("/home/inc15/z-kart/zusers_db.txt",true);

    }
    public void fileProcess(String result) throws IOException {
        buffer = new BufferedWriter(writer);
       // buffer.write("Email  Name  Mobile  Password");
        buffer.newLine();
        buffer.write(result);
        //buffer.close();
        System.out.println("Created");
    }
    public void readFromFile() throws IOException {
        FileReader fr = new FileReader("/home/inc15/z-kart/zusers_db.txt");
        BufferedReader br = new BufferedReader(fr);
        String i = null;
        while (i.equals(br.read())){

            System.out.println(i);
        }
        br.close();
        fr.close();
    }
//    public void closeFiles() throws IOException {
//        buffer.close();
//    }
}
