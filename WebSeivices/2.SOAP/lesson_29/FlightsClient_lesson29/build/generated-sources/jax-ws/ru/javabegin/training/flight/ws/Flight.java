
package ru.javabegin.training.flight.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for flight complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="flight">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="aircraft" type="{http://javabegin.ru/training/ws}aircraft" minOccurs="0"/>
 *         &lt;element name="cityFrom" type="{http://javabegin.ru/training/ws}city" minOccurs="0"/>
 *         &lt;element name="cityTo" type="{http://javabegin.ru/training/ws}city" minOccurs="0"/>
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dateCome" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="dateDepart" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="duration" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="existFreePlaces" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "flight", propOrder = {
    "aircraft",
    "cityFrom",
    "cityTo",
    "code",
    "dateCome",
    "dateDepart",
    "duration",
    "existFreePlaces",
    "id"
})
public class Flight {

    protected Aircraft aircraft;
    protected City cityFrom;
    protected City cityTo;
    protected String code;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateCome;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateDepart;
    protected String duration;
    protected boolean existFreePlaces;
    protected long id;

    /**
     * Gets the value of the aircraft property.
     * 
     * @return
     *     possible object is
     *     {@link Aircraft }
     *     
     */
    public Aircraft getAircraft() {
        return aircraft;
    }

    /**
     * Sets the value of the aircraft property.
     * 
     * @param value
     *     allowed object is
     *     {@link Aircraft }
     *     
     */
    public void setAircraft(Aircraft value) {
        this.aircraft = value;
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

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the dateCome property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateCome() {
        return dateCome;
    }

    /**
     * Sets the value of the dateCome property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateCome(XMLGregorianCalendar value) {
        this.dateCome = value;
    }

    /**
     * Gets the value of the dateDepart property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDateDepart() {
        return dateDepart;
    }

    /**
     * Sets the value of the dateDepart property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDateDepart(XMLGregorianCalendar value) {
        this.dateDepart = value;
    }

    /**
     * Gets the value of the duration property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDuration() {
        return duration;
    }

    /**
     * Sets the value of the duration property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDuration(String value) {
        this.duration = value;
    }

    /**
     * Gets the value of the existFreePlaces property.
     * 
     */
    public boolean isExistFreePlaces() {
        return existFreePlaces;
    }

    /**
     * Sets the value of the existFreePlaces property.
     * 
     */
    public void setExistFreePlaces(boolean value) {
        this.existFreePlaces = value;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

}
