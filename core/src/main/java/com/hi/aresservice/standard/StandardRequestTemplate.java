package com.hi.aresservice.standard;

import cz.mfcr.wwwinfo.ares.xml_doc.schemas.ares.ares_datatypes.v_1_0.AresDotazTyp2;
import cz.mfcr.wwwinfo.ares.xml_doc.schemas.ares.ares_datatypes.v_1_0.VystupFormat2;
import cz.mfcr.wwwinfo.ares.xml_doc.schemas.ares.ares_request.v_1_0.AresDotazy;
import cz.mfcr.wwwinfo.ares.xml_doc.schemas.ares.ares_request.v_1_0.Dotaz;

public class StandardRequestTemplate {

    private AresDotazy request;
    private int counter = 0;

    public StandardRequestTemplate() {
        request = new AresDotazy();
        request.setDotazPocet(0);
        request.setDotazTyp(AresDotazTyp2.STANDARD);
        request.setId("ares_dotaz");
        request.setVystupFormat(VystupFormat2.XML);
        request.setUserMail("r.poskocil@gmc.net");
    }

    public void addQuery(Dotaz query) {
        counter++;
        query.setPomocneID(counter);
        request.getDotaz().add(query);
        request.setDotazPocet(counter);
    }

    public AresDotazy getRequest() {
        return request;
    }
}
