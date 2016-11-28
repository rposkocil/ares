package com.hi.aresservice.standard;

import cz.mfcr.wwwinfo.ares.xml_doc.schemas.ares.ares_answer.v_1_0.AresOdpovedi;
import cz.mfcr.wwwinfo.ares.xml_doc.schemas.ares.ares_answer.v_1_0.Odpoved;
import cz.mfcr.wwwinfo.ares.xml_doc.schemas.ares.ares_answer.v_1_0.Zaznam;

import java.util.List;

public class StandardResponseTemplate {

    public StandardResponses transform(AresOdpovedi responses) {

        StandardResponses standardResponses = new StandardResponses();
        standardResponses.setId(responses.getId());
        standardResponses.setType(responses.getOdpovedTyp());
        standardResponses.setResponseDate(responses.getOdpovedDatumCas().toGregorianCalendar().getTime());
        standardResponses.setFail(responses.getFault());

        List<Odpoved> odpovedList = responses.getOdpoved();
        for(Odpoved o : odpovedList) {
            StandardResponse standardResponse = toStandardResponse(o);
            List<Zaznam> zaznamList = o.getZaznam();
            for(Zaznam z : zaznamList) {
                standardResponse.getRecords().add(toStandardRecord(z));
            }
            standardResponses.getStandardResponseList().add(standardResponse);
        }
        return standardResponses;
    }

    private StandardResponse toStandardResponse(Odpoved odpoved) {
        StandardResponse standardResponse = new StandardResponse();
        standardResponse.setSecondId(odpoved.getPomocneID());
        standardResponse.setSearchType(odpoved.getTypVyhledani());
        standardResponse.getErrors().addAll(odpoved.getError());
        return standardResponse;
    }

    private StandardRecord toStandardRecord(Zaznam zaznam) {
        StandardRecord standardRecord = new StandardRecord();
        standardRecord.setIcoStatus(zaznam.getShodaICO());
        standardRecord.setIdStatus(zaznam.getShodaRC());
        standardRecord.setCompanyStatus(zaznam.getShodaOF());
        standardRecord.setSearchBy(zaznam.getVyhledanoDle());
        standardRecord.setCatalogType(zaznam.getTypRegistru());
        if(zaznam.getDatumVzniku() != null) {
            standardRecord.setCreated(zaznam.getDatumVzniku().toGregorianCalendar().getTime());
        }
        if(zaznam.getDatumZaniku() != null) {
            standardRecord.setCeased(zaznam.getDatumZaniku().toGregorianCalendar().getTime());
        }
        if(zaznam.getDatumPlatnosti() != null) {
            standardRecord.setValidity(zaznam.getDatumPlatnosti().toGregorianCalendar().getTime());
        }
        standardRecord.setLegalForm(zaznam.getPravniForma());
        standardRecord.setIco(zaznam.getICO());
        standardRecord.setCompany(zaznam.getObchodniFirma());
        standardRecord.setIdentification(zaznam.getIdentifikace());
        standardRecord.setCode(zaznam.getKodFU());
        standardRecord.setProperties(zaznam.getPriznakySubjektu());
        return standardRecord;
    }
}
