//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.3.2 generiert 
// Siehe <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2019.01.28 um 10:00:07 PM CET 
//


package net.opengis.gml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * A discrete coverage type whose domain is defined by a collection of surface patches (includes polygons, triangles, rectangles, etc).
 * 
 * <p>Java-Klasse für MultiSurfaceCoverageType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="MultiSurfaceCoverageType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.opengis.net/gml}AbstractDiscreteCoverageType"&gt;
 *       &lt;sequence&gt;
 *         &lt;group ref="{http://www.opengis.net/gml}StandardObjectProperties"/&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}boundedBy" minOccurs="0"/&gt;
 *         &lt;element ref="{http://www.opengis.net/gml}multiSurfaceDomain"/&gt;
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
@XmlType(name = "MultiSurfaceCoverageType")
public class MultiSurfaceCoverageType
    extends AbstractDiscreteCoverageType
{


}
