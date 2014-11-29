package l3.jsonParser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String path = "C:\\Tmp\\jsonParser.json";
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
            String str = "";
            while ((str = br.readLine()) != null){
                sb.append(str).append("\r\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sb.toString();

        Gson gson = new GsonBuilder().create();
        Person person = (Person)gson.fromJson(sb.toString(),Person.class);
        System.out.println(person.toString());
    }
}
