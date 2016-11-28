package com.hi.aresservice.standard;

import cz.mfcr.wwwinfo.ares.xml_doc.schemas.ares.ares_answer.v_1_0.Identifikace;
import cz.mfcr.wwwinfo.ares.xml_doc.schemas.ares.ares_answer.v_1_0.VyhledanoDle;
import cz.mfcr.wwwinfo.ares.xml_doc.schemas.ares.ares_datatypes.v_1_0.*;

import java.util.Date;

public class StandardRecord {

    private ShodaICO2 icoStatus;
    private ShodaRC2 idStatus;
    private ShodaOF2 companyStatus;

    private VyhledanoDle searchBy;
    private TypRegistru2 catalogType;

    private Date created;
    private Date ceased;
    private Date validity;

    private PravniForma2 legalForm;
    private String company;
    private String ico;
    private Identifikace identification;
    private Short code;
    private String properties;

    public ShodaICO2 getIcoStatus() {
        return icoStatus;
    }

    public void setIcoStatus(ShodaICO2 icoStatus) {
        this.icoStatus = icoStatus;
    }

    public ShodaRC2 getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(ShodaRC2 idStatus) {
        this.idStatus = idStatus;
    }

    public ShodaOF2 getCompanyStatus() {
        return companyStatus;
    }

    public void setCompanyStatus(ShodaOF2 companyStatus) {
        this.companyStatus = companyStatus;
    }

    public VyhledanoDle getSearchBy() {
        return searchBy;
    }

    public void setSearchBy(VyhledanoDle searchBy) {
        this.searchBy = searchBy;
    }

    public TypRegistru2 getCatalogType() {
        return catalogType;
    }

    public void setCatalogType(TypRegistru2 catalogType) {
        this.catalogType = catalogType;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getCeased() {
        return ceased;
    }

    public void setCeased(Date ceased) {
        this.ceased = ceased;
    }

    public Date getValidity() {
        return validity;
    }

    public void setValidity(Date validity) {
        this.validity = validity;
    }

    public PravniForma2 getLegalForm() {
        return legalForm;
    }

    public void setLegalForm(PravniForma2 legalForm) {
        this.legalForm = legalForm;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getIco() {
        return ico;
    }

    public void setIco(String ico) {
        this.ico = ico;
    }

    public Identifikace getIdentification() {
        return identification;
    }

    public void setIdentification(Identifikace identification) {
        this.identification = identification;
    }

    public Short getCode() {
        return code;
    }

    public void setCode(Short code) {
        this.code = code;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "StandardRecord{" +
                "icoStatus=" + icoStatus +
                ", idStatus=" + idStatus +
                ", companyStatus=" + companyStatus +
                ", searchBy=" + searchBy +
                ", catalogType=" + catalogType +
                ", created=" + created +
                ", ceased=" + ceased +
                ", validity=" + validity +
                ", legalForm=" + legalForm +
                ", company='" + company + '\'' +
                ", ico='" + ico + '\'' +
                ", identification=" + identification +
                ", code=" + code +
                ", properties='" + properties + '\'' +
                '}';
    }
}
