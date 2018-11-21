//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package org.w3._2001.smil20;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für syncBehaviorType.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * <p>
 * <pre>
 * &lt;simpleType name="syncBehaviorType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="canSlip"/&gt;
 *     &lt;enumeration value="locked"/&gt;
 *     &lt;enumeration value="independent"/&gt;
 *     &lt;enumeration value="default"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "syncBehaviorType")
@XmlEnum
public enum SyncBehaviorType {

    @XmlEnumValue("canSlip")
    CAN_SLIP("canSlip"),
    @XmlEnumValue("locked")
    LOCKED("locked"),
    @XmlEnumValue("independent")
    INDEPENDENT("independent"),
    @XmlEnumValue("default")
    DEFAULT("default");
    private final String value;

    SyncBehaviorType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SyncBehaviorType fromValue(String v) {
        for (SyncBehaviorType c: SyncBehaviorType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
