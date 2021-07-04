package CreateXML;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="config")
@XmlAccessorType(XmlAccessType.FIELD)
public class Fun {
    @XmlElement
    private String function;

    public String getFunction() {
        return function;
    }
    public void setFunction(String function) {
        this.function = function;
    }
}
