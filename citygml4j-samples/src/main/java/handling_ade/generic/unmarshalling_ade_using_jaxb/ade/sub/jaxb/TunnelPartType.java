//
// Generated with ade-xjc - XML Schema binding compiler for CityGML ADEs, version 2.6.1
// ade-xjc is part of the citygml4j project, see https://github.com/citygml4j
// Any modifications to this file will be lost upon recompilation of the source
// Generated: Sun Jan 21 21:03:34 CET 2018
//


package handling_ade.generic.unmarshalling_ade_using_jaxb.ade.sub.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java-Klasse für TunnelPartType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="TunnelPartType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.citygml.org/ade/sub/0.9.0}AbstractTunnelType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.citygml.org/ade/sub/0.9.0}_GenericApplicationPropertyOfTunnelPart" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TunnelPartType", propOrder = {
    "_GenericApplicationPropertyOfTunnelPart"
})
public class TunnelPartType
    extends AbstractTunnelType
{

    protected List<Object> _GenericApplicationPropertyOfTunnelPart;

    /**
     * Gets the value of the genericApplicationPropertyOfTunnelPart property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfTunnelPart property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfTunnelPart().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> get_GenericApplicationPropertyOfTunnelPart() {
        if (_GenericApplicationPropertyOfTunnelPart == null) {
            _GenericApplicationPropertyOfTunnelPart = new ArrayList<Object>();
        }
        return this._GenericApplicationPropertyOfTunnelPart;
    }

    public boolean isSet_GenericApplicationPropertyOfTunnelPart() {
        return ((this._GenericApplicationPropertyOfTunnelPart!= null)&&(!this._GenericApplicationPropertyOfTunnelPart.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfTunnelPart() {
        this._GenericApplicationPropertyOfTunnelPart = null;
    }

}
