package com.hi.aresservice.basic;

import cz.mfcr.wwwinfo.ares.xml_doc.schemas.ares.ares_request_orrg.v_1_0.Dotaz;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import java.util.Date;
import java.util.GregorianCalendar;

public class BasicQuery {

    private Dotaz query = new Dotaz();

    public Dotaz toDotaz() {
        return query;
    }

    public void setSecondId(Integer secondId) {
        addToContent(secondId, Integer.class, "Pomocne_ID");
    }

    public void setIco(String ico) {
        addToContent(ico, String.class, "ICO");
    }

    public void setExpirationDate(Date expirationDate) {
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(new Date());
        XMLGregorianCalendar date = null;
        try {
            date = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        addToContent(date, GregorianCalendar.class, "Datum_platnosti");
    }

    public void isActive(boolean isActive) {
        addToContent(isActive, Boolean.class, "Aktivni");
    }

    public void setAresKey(Integer aresKey) {
        addToContent(aresKey, Integer.class, "Klic_ARES");
    }

    public void setSentenceId(Integer sentenceId) {
        addToContent(sentenceId, Integer.class, "ID_vety");
    }

    public void setRange(Short range) {
        addToContent(range, Integer.class, "Rozsah");
    }

    public void useOriginalAddress(boolean use) {
        addToContent(use, Boolean.class, "Adr_puv");
    }

    private void addToContent(Object obj, Class cls, String elementTag) {
        query.getContent().add(getJAXBElement(obj, cls, elementTag));
    }

    private JAXBElement getJAXBElement(Object object, Class myclass, String tagName) {
        QName qname = new QName("http://wwwinfo.mfcr.cz/aresservice/xml_doc/wsdl/basic.wsdl", tagName);
        return new JAXBElement(qname, myclass, object);
    }
}
