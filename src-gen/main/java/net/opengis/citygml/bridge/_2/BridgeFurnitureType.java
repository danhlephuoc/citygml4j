//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.01.28 um 10:00:07 PM CET 
//


package net.opengis.citygml.bridge._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import net.opengis.citygml._2.AbstractCityObjectType;
import net.opengis.citygml._2.ImplicitRepresentationPropertyType;
import net.opengis.gml.CodeType;
import net.opengis.gml.GeometryPropertyType;


/**
 * Type for bridge furnitures. As subclass of _CityObject, a BridgeFurniture inherits all attributes and
 * 				relations, in particular an id, names, external references, generic attributes and generalization relations.
 * 			
 * 
 * <p>Java-Klasse für BridgeFurnitureType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="BridgeFurnitureType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.opengis.net/citygml/2.0}AbstractCityObjectType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="class" type="{http://www.opengis.net/gml}CodeType" minOccurs="0"/&gt;
 *         &lt;element name="function" type="{http://www.opengis.net/gml}CodeType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="usage" type="{http://www.opengis.net/gml}CodeType" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="lod4Geometry" type="{http://www.opengis.net/gml}GeometryPropertyType" minOccurs="0"/&gt;
 *         &lt;element name="lod4ImplicitRepresentation" type="{http://www.opengis.net/citygml/2.0}ImplicitRepresentationPropertyType" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/citygml/bridge/2.0}_GenericApplicationPropertyOfBridgeFurniture" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BridgeFurnitureType", propOrder = {
    "clazz",
    "function",
    "usage",
    "lod4Geometry",
    "lod4ImplicitRepresentation",
    "_GenericApplicationPropertyOfBridgeFurniture"
})
public class BridgeFurnitureType
    extends AbstractCityObjectType
{

    @XmlElement(name = "class")
    protected CodeType clazz;
    protected List<CodeType> function;
    protected List<CodeType> usage;
    protected GeometryPropertyType lod4Geometry;
    protected ImplicitRepresentationPropertyType lod4ImplicitRepresentation;
    @XmlElementRef(name = "_GenericApplicationPropertyOfBridgeFurniture", namespace = "http://www.opengis.net/citygml/bridge/2.0", type = JAXBElement.class, required = false)
    protected List<JAXBElement<Object>> _GenericApplicationPropertyOfBridgeFurniture;

    /**
     * Ruft den Wert der clazz-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getClazz() {
        return clazz;
    }

    /**
     * Legt den Wert der clazz-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setClazz(CodeType value) {
        this.clazz = value;
    }

    public boolean isSetClazz() {
        return (this.clazz!= null);
    }

    /**
     * Gets the value of the function property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the function property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFunction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CodeType }
     * 
     * 
     */
    public List<CodeType> getFunction() {
        if (function == null) {
            function = new ArrayList<CodeType>();
        }
        return this.function;
    }

    public boolean isSetFunction() {
        return ((this.function!= null)&&(!this.function.isEmpty()));
    }

    public void unsetFunction() {
        this.function = null;
    }

    /**
     * Gets the value of the usage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the usage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUsage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CodeType }
     * 
     * 
     */
    public List<CodeType> getUsage() {
        if (usage == null) {
            usage = new ArrayList<CodeType>();
        }
        return this.usage;
    }

    public boolean isSetUsage() {
        return ((this.usage!= null)&&(!this.usage.isEmpty()));
    }

    public void unsetUsage() {
        this.usage = null;
    }

    /**
     * Ruft den Wert der lod4Geometry-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link GeometryPropertyType }
     *     
     */
    public GeometryPropertyType getLod4Geometry() {
        return lod4Geometry;
    }

    /**
     * Legt den Wert der lod4Geometry-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link GeometryPropertyType }
     *     
     */
    public void setLod4Geometry(GeometryPropertyType value) {
        this.lod4Geometry = value;
    }

    public boolean isSetLod4Geometry() {
        return (this.lod4Geometry!= null);
    }

    /**
     * Ruft den Wert der lod4ImplicitRepresentation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ImplicitRepresentationPropertyType }
     *     
     */
    public ImplicitRepresentationPropertyType getLod4ImplicitRepresentation() {
        return lod4ImplicitRepresentation;
    }

    /**
     * Legt den Wert der lod4ImplicitRepresentation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ImplicitRepresentationPropertyType }
     *     
     */
    public void setLod4ImplicitRepresentation(ImplicitRepresentationPropertyType value) {
        this.lod4ImplicitRepresentation = value;
    }

    public boolean isSetLod4ImplicitRepresentation() {
        return (this.lod4ImplicitRepresentation!= null);
    }

    /**
     * Gets the value of the genericApplicationPropertyOfBridgeFurniture property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the genericApplicationPropertyOfBridgeFurniture property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    get_GenericApplicationPropertyOfBridgeFurniture().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * 
     */
    public List<JAXBElement<Object>> get_GenericApplicationPropertyOfBridgeFurniture() {
        if (_GenericApplicationPropertyOfBridgeFurniture == null) {
            _GenericApplicationPropertyOfBridgeFurniture = new ArrayList<JAXBElement<Object>>();
        }
        return this._GenericApplicationPropertyOfBridgeFurniture;
    }

    public boolean isSet_GenericApplicationPropertyOfBridgeFurniture() {
        return ((this._GenericApplicationPropertyOfBridgeFurniture!= null)&&(!this._GenericApplicationPropertyOfBridgeFurniture.isEmpty()));
    }

    public void unset_GenericApplicationPropertyOfBridgeFurniture() {
        this._GenericApplicationPropertyOfBridgeFurniture = null;
    }

    public void setFunction(List<CodeType> value) {
        this.function = value;
    }

    public void setUsage(List<CodeType> value) {
        this.usage = value;
    }

    public void set_GenericApplicationPropertyOfBridgeFurniture(List<JAXBElement<Object>> value) {
        this._GenericApplicationPropertyOfBridgeFurniture = value;
    }

}
