package com.hi.aresservice.basic;

import cz.mfcr.wwwinfo.ares.xml_doc.schemas.ares.ares_datatypes.v_1_0.AresDotazTyp2;
import cz.mfcr.wwwinfo.ares.xml_doc.schemas.ares.ares_datatypes.v_1_0.VystupFormat2;
import cz.mfcr.wwwinfo.ares.xml_doc.schemas.ares.ares_request_orrg.v_1_0.AresDotazy;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class BasicRequestTemplate {

    private AresDotazy request;
    private int counter = 0;

    public BasicRequestTemplate() {
        request = new AresDotazy();
        request.setDotazPocet(0);
        request.setDotazTyp(AresDotazTyp2.BASIC);
        request.setId("ares_dotaz");
        request.setVystupFormat(VystupFormat2.XML);
        request.setUserMail("r.poskocil@gmc.net");
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(new Date());
        try {
            XMLGregorianCalendar date = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
            request.setDotazDatumCas(date);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void addQuery(BasicQuery basicQuery) {
        counter++;
        basicQuery.setSecondId(counter);
        request.getDotaz().add(basicQuery.toDotaz());
        request.setDotazPocet(counter);
    }

    public AresDotazy getRequest() {
        return request;
    }
}
