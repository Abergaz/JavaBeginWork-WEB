
package ru.javabegin.training.flight.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for buyTicket complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="buyTicket">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://ws.flight.training.javabegin.ru/}flight" minOccurs="0"/>
 *         &lt;element name="arg1" type="{http://ws.flight.training.javabegin.ru/}place" minOccurs="0"/>
 *         &lt;element name="arg2" type="{http://ws.flight.training.javabegin.ru/}passenger" minOccurs="0"/>
 *         &lt;element name="arg3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "buyTicket", propOrder = {
    "arg0",
    "arg1",
    "arg2",
    "arg3"
})
public class BuyTicket {

    protected Flight arg0;
    protected Place arg1;
    protected Passenger arg2;
    protected String arg3;

    /**
     * Gets the value of the arg0 property.
     * 
     * @return
     *     possible object is
     *     {@link Flight }
     *     
     */
    public Flight getArg0() {
        return arg0;
    }

    /**
     * Sets the value of the arg0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Flight }
     *     
     */
    public void setArg0(Flight value) {
        this.arg0 = value;
    }

    /**
     * Gets the value of the arg1 property.
     * 
     * @return
     *     possible object is
     *     {@link Place }
     *     
     */
    public Place getArg1() {
        return arg1;
    }

    /**
     * Sets the value of the arg1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Place }
     *     
     */
    public void setArg1(Place value) {
        this.arg1 = value;
    }

    /**
     * Gets the value of the arg2 property.
     * 
     * @return
     *     possible object is
     *     {@link Passenger }
     *     
     */
    public Passenger getArg2() {
        return arg2;
    }

    /**
     * Sets the value of the arg2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Passenger }
     *     
     */
    public void setArg2(Passenger value) {
        this.arg2 = value;
    }

    /**
     * Gets the value of the arg3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArg3() {
        return arg3;
    }

    /**
     * Sets the value of the arg3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArg3(String value) {
        this.arg3 = value;
    }

}
