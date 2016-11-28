package com.hi.aresservice;

import com.hi.aresservice.standard.StandardRequestTemplate;
import cz.mfcr.wwwinfo.ares.xml_doc.schemas.ares.ares_datatypes.v_1_0.AresDotazTyp2;
import cz.mfcr.wwwinfo.ares.xml_doc.schemas.ares.ares_datatypes.v_1_0.VystupFormat2;
import cz.mfcr.wwwinfo.ares.xml_doc.schemas.ares.ares_request.v_1_0.AresDotazy;
import cz.mfcr.wwwinfo.ares.xml_doc.schemas.ares.ares_request.v_1_0.Dotaz;
import org.junit.Assert;
import org.junit.Test;

public class StandardRequestTemplateTest {

    @Test
    public void testQueryCounter() {
        StandardRequestTemplate requestTemplate = new StandardRequestTemplate();
        Assert.assertEquals("Counter is NOT initialized to zero.", 0, requestTemplate.getRequest().getDotazPocet());
        Assert.assertEquals("List of queries is NOT empty.", 0, requestTemplate.getRequest().getDotaz().size());

        requestTemplate.addQuery(new Dotaz());
        Assert.assertEquals("Counter wasn't incremented.", 1, requestTemplate.getRequest().getDotazPocet());
        Assert.assertEquals("Size of queries list is NOT 1.", 1, requestTemplate.getRequest().getDotaz().size());

        requestTemplate.addQuery(new Dotaz());
        requestTemplate.addQuery(new Dotaz());
        Assert.assertEquals("Counter is NOT 3.", 3, requestTemplate.getRequest().getDotazPocet());
        Assert.assertEquals("Size of queries list is NOT 3.", 3, requestTemplate.getRequest().getDotaz().size());
    }

    @Test
    public void testStandardSettings() {
        StandardRequestTemplate requestTemplate = new StandardRequestTemplate();
        AresDotazy request = requestTemplate.getRequest();

        Assert.assertEquals("Type of request is NOT set.", AresDotazTyp2.STANDARD, request.getDotazTyp());
        Assert.assertEquals("ID of request is NOT set.", "ares_dotaz", request.getId());
        Assert.assertEquals("Output format of request is NOT set.", VystupFormat2.XML, request.getVystupFormat());
    }
}