package l3.yahooFinanceXml;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Main {
    
    public static void main(String[] args) throws Exception {

        String request = "http://query.yahooapis.com/v1/public/yql?format=json&q=select%20*%20from%20" +
                "yahoo.finance.xchange%20where%20pair%20in%20(\"USDEUR\",%20\"USDUAH\")&env=store://datatables.org/alltableswithkeys";

        File file = new File("C:\\Tmp\\yahooFinanceXml.xml");
        saveAsXml(request, file);
        JSON s = readFromXml(file);
        System.out.println(s.getQuery().toString());
    }

    private static String performRequest(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        StringBuilder sb = new StringBuilder();

        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()));
            char[] buf = new char[1000000];

            int r = 0;
            do {
                if ((r = br.read(buf)) > 0)
                    sb.append(new String(buf, 0, r));
            } while (r > 0);
        } finally {
            http.disconnect();
        }

        return sb.toString();
    }
    private static void saveAsXml(String request , File path) throws IOException {
        String result = performRequest(request);

        FileWriter fw = new FileWriter(path);
        try {
            fw.write(result);
        }finally {
            fw.close();
        }
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
        JSON json = (JSON)gson.fromJson(sb.toString(),JSON.class);
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(JSON.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(json, path);
        }catch (JAXBException e){
            e.printStackTrace();
        }
    }
    private static JSON readFromXml(File path){
        JSON result = new JSON();
        JSON json = new JSON();
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(JSON.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            json = (JSON)unmarshaller.unmarshal(path);
            result.setQuery(json.getQuery());
        }catch (JAXBException e){
            e.printStackTrace();
        }
        return result;
    }
}