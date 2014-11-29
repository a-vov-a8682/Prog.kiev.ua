package l3.yahooFinanceXml;

import javax.xml.bind.annotation.XmlElement;

public class Query {
    private int count;
    private String created;
    private String lang;
    private Results results;

    public int getCount() {
        return count;
    }
    @XmlElement
    public void setCount(int count) {
        this.count = count;
    }

    public String getCreated() {
        return created;
    }
    @XmlElement
    public void setCreated(String created) {
        this.created = created;
    }

    public String getLang() {
        return lang;
    }
    @XmlElement
    public void setLang(String lang) {
        this.lang = lang;
    }

    public Results getResults() {
        return results;
    }
    @XmlElement
    public void setResults(Results results) {
        this.results = results;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Query{" + "\n")
                .append("   Count = " + count + "\n")
                .append("   Created = " + created + "\n")
                .append("   Lang = " + lang + "\n")
                .append("   Results = " + results + "\n" + '}');
        return sb.toString();
    }
}
