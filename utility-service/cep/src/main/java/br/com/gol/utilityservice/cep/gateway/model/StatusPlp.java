//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.0 
// See <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.06.17 at 11:34:58 AM BRT 
//


package br.com.gol.utilityservice.cep.gateway.model;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for statusPlp.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="statusPlp"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Aberta"/&gt;
 *     &lt;enumeration value="Fechada"/&gt;
 *     &lt;enumeration value="Postada"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "statusPlp")
@XmlEnum
public enum StatusPlp {

    @XmlEnumValue("Aberta")
    ABERTA("Aberta"),
    @XmlEnumValue("Fechada")
    FECHADA("Fechada"),
    @XmlEnumValue("Postada")
    POSTADA("Postada");
    private final String value;

    StatusPlp(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static StatusPlp fromValue(String v) {
        for (StatusPlp c: StatusPlp.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
