package com.hi.aresservice.standard;

import cz.mfcr.wwwinfo.ares.xml_doc.schemas.ares.ares_datatypes.v_1_0.AresVyberTyp;
import cz.mfcr.wwwinfo.ares.xml_doc.schemas.ares.ares_datatypes.v_1_0.TypRegistru;
import cz.mfcr.wwwinfo.ares.xml_doc.schemas.ares.ares_request.v_1_0.Dotaz;
import cz.mfcr.wwwinfo.ares.xml_doc.schemas.ares.ares_request.v_1_0.KlicovePolozky;

import javax.xml.datatype.XMLGregorianCalendar;

public class StandardQuery {

    private Dotaz query = new Dotaz();
    private KlicovePolozky keyValues = new KlicovePolozky();

    public Dotaz toDotaz() {
        query.setKlicovePolozky(keyValues);
        return query;
    }

    public void setQueryType(AresVyberTyp type) {
        query.setTypVyhledani(type);
    }

    public void setIco(String ico) {
        keyValues.setICO(ico);
    }

    public void setIdNumber(String idNumber) {
        keyValues.setRodneCislo(idNumber);
    }

    public void setCompany(String company) {
        keyValues.setObchodniFirma(company);
    }

    public void setCity(String city) {
        query.setNazevObce(city);
    }

    public void setLegalForm(Short legalForm) {
        query.setPravniForma(legalForm);
    }

    public void setExpiration(XMLGregorianCalendar calendar) {
        query.setDatumPlatnosti(calendar);
    }

    public void setCatalogType(int code) {
        TypRegistru typRegistru = new TypRegistru();
        typRegistru.setKod(code);
        query.setTypRegistru(typRegistru);
    }

    public void setCatalogType(int code, String text) {
        TypRegistru typRegistru = new TypRegistru();
        typRegistru.setKod(code);
        typRegistru.setText(text);
        query.setTypRegistru(typRegistru);
    }

    public void setMaxFinds(int count) {
        query.setMaxPocet(count);
    }

    public void enableDiacritic(boolean enabled) {
        query.setDiakritika(enabled);
    }

    public void onlyActive(boolean isActive) {
        query.setAktivni(isActive);
    }

    public void originalAddress(boolean origAddrEnabled) {
        query.setAdrPuv(origAddrEnabled);
    }
}
