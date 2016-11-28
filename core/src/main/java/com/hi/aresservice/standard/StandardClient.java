package com.hi.aresservice.standard;

import cz.mfcr.wwwinfo.ares.xml_doc.schemas.ares.ares_answer.v_1_0.AresOdpovedi;
import cz.mfcr.wwwinfo.ares.xml_doc.wsdl.standard_wsdl.GetHttpStandardFault;
import cz.mfcr.wwwinfo.ares.xml_doc.wsdl.standard_wsdl.HttpSoapStandard;
import cz.mfcr.wwwinfo.ares.xml_doc.wsdl.standard_wsdl.StandardService;

public class StandardClient {

    private HttpSoapStandard soapStandard;
    private StandardRequestTemplate requestTemplate;

    public StandardClient() {
        soapStandard = new StandardService().getStandardHttpSoapPort();
        requestTemplate = new StandardRequestTemplate();
    }

    public void addQuery(StandardQuery query) {
        requestTemplate.addQuery(query.toDotaz());
    }

    public AresOdpovedi call() {
        AresOdpovedi response = null;
        try {
            response = soapStandard.getXmlFile(requestTemplate.getRequest());
        } catch (GetHttpStandardFault getHttpStandardFault) {
            getHttpStandardFault.printStackTrace();
        }
        return response;
    }
}
