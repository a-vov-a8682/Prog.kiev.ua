package l3.yahooFinanceXml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class JSON {

    private Query query;

    public Query getQuery() {
        return query;
    }
    @XmlElement
    public void setQuery(Query query) {
        this.query = query;
    }
}
