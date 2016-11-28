package com.hi.aresservice.standard;

import cz.mfcr.wwwinfo.ares.xml_doc.schemas.ares.ares_answer.v_1_0.AresOdpovedi;
import cz.mfcr.wwwinfo.ares.xml_doc.wsdl.standard_wsdl.GetHttpStandardFault;
import cz.mfcr.wwwinfo.ares.xml_doc.wsdl.standard_wsdl.HttpSoapStandard;
import cz.mfcr.wwwinfo.ares.xml_doc.wsdl.standard_wsdl.StandardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StandardClient {

    private static final Logger logger = LoggerFactory.getLogger(StandardClient.class);

    private HttpSoapStandard soapStandard;
    private StandardRequestTemplate requestTemplate;

    public StandardClient() {
        soapStandard = new StandardService().getStandardHttpSoapPort();
        requestTemplate = new StandardRequestTemplate();
    }

    public void addQuery(StandardQuery query) {
        requestTemplate.addQuery(query.toDotaz());
    }

    public StandardResponses call() {
        AresOdpovedi response = null;
        try {
            response = soapStandard.getXmlFile(requestTemplate.getRequest());
        } catch (GetHttpStandardFault getHttpStandardFault) {
            logger.debug("Call request problem.", getHttpStandardFault);
        }
        StandardResponseTemplate responseTemplate = new StandardResponseTemplate();
        return responseTemplate.transform(response);
    }
}
