package com.hi.aresservice.basic;

import cz.mfcr.wwwinfo.ares.xml_doc.schemas.ares.ares_answer_basic.v_1_0.AresOdpovedi;
import cz.mfcr.wwwinfo.ares.xml_doc.wsdl.basic_wsdl.BasicService;
import cz.mfcr.wwwinfo.ares.xml_doc.wsdl.basic_wsdl.GetHttpBasicFault;
import cz.mfcr.wwwinfo.ares.xml_doc.wsdl.basic_wsdl.HttpSoapBasic;

public class BasicClient {

    private HttpSoapBasic soapBasic;
    private BasicRequestTemplate requestTemplate;

    public BasicClient() {
        soapBasic = new BasicService().getBasicHttpSoapPort();
        requestTemplate = new BasicRequestTemplate();
    }

    public void addQuery(BasicQuery query) {
        requestTemplate.addQuery(query);
    }

    public AresOdpovedi call() {
        AresOdpovedi response = null;
        try {
            response = soapBasic.getXmlFile(requestTemplate.getRequest());
        } catch (GetHttpBasicFault getHttpBasicFault) {
            getHttpBasicFault.printStackTrace();
        }
        return response;
    }
}
