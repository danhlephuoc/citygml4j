//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.1 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2018.11.12 um 10:17:11 PM CET 
//


package net.opengis.gml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für RectifiedGridCoverageType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="RectifiedGridCoverageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.opengis.net/gml}AbstractDiscreteCoverageType"&gt;
 *       &lt;sequence&gt;
 *         &lt;group ref="{http://www.opengis.net/gml}StandardObjectProperties"/&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}boundedBy" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}rectifiedGridDomain"/&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}rangeSet"/&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}coverageFunction" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RectifiedGridCoverageType")
public class RectifiedGridCoverageType
    extends AbstractDiscreteCoverageType
{


}
