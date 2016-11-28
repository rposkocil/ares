package com.hi.aresservice;

import com.hi.aresservice.basic.BasicClient;
import com.hi.aresservice.basic.BasicQuery;
import com.hi.aresservice.standard.StandardClient;
import com.hi.aresservice.standard.StandardQuery;
import cz.mfcr.wwwinfo.ares.xml_doc.schemas.ares.ares_answer.v_1_0.AresOdpovedi;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        StandardClient standardClient = new StandardClient();
        StandardQuery standardQuery = new StandardQuery();
        standardQuery.setCompany("Schellex");
        standardQuery.setCity("Chrudim");
        standardClient.addQuery(standardQuery);
        AresOdpovedi standardResponse = standardClient.call();

        System.out.println(standardResponse.getOdpoved().get(0).getZaznam().get(0).getObchodniFirma());
        System.out.println(standardResponse.getOdpoved().get(0).getZaznam().get(0).getICO());

        BasicClient basicClient = new BasicClient();
        BasicQuery basicQuery = new BasicQuery();
        basicQuery.setIco("15053202");
        basicClient.addQuery(basicQuery);
        basicClient.call();
        cz.mfcr.wwwinfo.ares.xml_doc.schemas.ares.ares_answer_basic.v_1_0.AresOdpovedi answer2 = basicClient.call();

        System.out.println(answer2.getOdpoved().get(0).getVBAS().get(0).getOF().getValue());
    }
}
