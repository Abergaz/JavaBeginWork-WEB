
package ru.javabegin.training.flight.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for searchFlight complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="searchFlight">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="cityFrom" type="{http://javabegin.ru/training/ws}city" minOccurs="0"/>
 *         &lt;element name="cityTo" type="{http://javabegin.ru/training/ws}city" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "searchFlight", propOrder = {
    "date",
    "cityFrom",
    "cityTo"
})
public class SearchFlight {

    protected long date;
    protected City cityFrom;
    protected City cityTo;

    /**
     * Gets the value of the date property.
     * 
     */
    public long getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     */
    public void setDate(long value) {
        this.date = value;
    }

    /**
     * Gets the value of the cityFrom property.
     * 
     * @return
     *     possible object is
     *     {@link City }
     *     
     */
    public City getCityFrom() {
        return cityFrom;
    }

    /**
     * Sets the value of the cityFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link City }
     *     
     */
    public void setCityFrom(City value) {
        this.cityFrom = value;
    }

    /**
     * Gets the value of the cityTo property.
     * 
     * @return
     *     possible object is
     *     {@link City }
     *     
     */
    public City getCityTo() {
        return cityTo;
    }

    /**
     * Sets the value of the cityTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link City }
     *     
     */
    public void setCityTo(City value) {
        this.cityTo = value;
    }

}
