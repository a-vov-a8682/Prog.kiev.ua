package l3.yahooFinanceXml;

import javax.xml.bind.annotation.XmlElement;
import java.util.Arrays;

public class Results {
    private Rate[] rate;

    public Rate[] getRate() {
        return rate;
    }
    @XmlElement
    public void setRate(Rate[] rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('{' + "\n" + "        Rate = " + Arrays.toString(rate) + "\n" )
                .append("       }");
        return sb.toString();
    }
}
