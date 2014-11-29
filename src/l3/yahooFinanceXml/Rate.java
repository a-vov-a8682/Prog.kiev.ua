package l3.yahooFinanceXml;

import javax.xml.bind.annotation.XmlElement;

public class Rate {
    private String id;
    private String Name;
    private double Rate;
    private String Date;
    private String Time;
    private String Ask;
    private String Bid;

    public String getId() {
        return id;
    }
    @XmlElement
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }
    @XmlElement
    public void setName(String name) {
        Name = name;
    }

    public double getRate() {
        return Rate;
    }
    @XmlElement
    public void setRate(double rate) {
        Rate = rate;
    }

    public String getDate() {
        return Date;
    }
    @XmlElement
    public void setDate(String date) {
        Date = date;
    }

    public String getTime() {
        return Time;
    }
    @XmlElement
    public void setTime(String time) {
        Time = time;
    }

    public String getAsk() {
        return Ask;
    }
    @XmlElement
    public void setAsk(String ask) {
        Ask = ask;
    }

    public String getBid() {
        return Bid;
    }
    @XmlElement
    public void setBid(String bid) {
        Bid = bid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n" + "          {Id = " + id + "\n")
                .append("           Name = " + Name + "\n")
                .append("           Rate = " + Rate + "\n")
                .append("           Date = " + Date +  "\n")
                .append("           Time = " + Time +  "\n")
                .append("           Ask = " + Ask +  "\n")
                .append("           Bid = " + Bid + '}' + "\n");


        return sb.toString();
    }
}
