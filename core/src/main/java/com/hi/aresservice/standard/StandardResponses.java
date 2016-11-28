package com.hi.aresservice.standard;

import cz.mfcr.wwwinfo.ares.xml_doc.schemas.ares.ares_datatypes.v_1_0.AresDotazTyp;
import cz.mfcr.wwwinfo.ares.xml_doc.schemas.ares.ares_datatypes.v_1_0.ChybovaOdpoved;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StandardResponses {

    private String id;
    private AresDotazTyp type;
    private Date responseDate;
    private ChybovaOdpoved fail;

    private List<StandardResponse> standardResponseList = new ArrayList<>();

    public String getId() {
        return id;
    }

    public AresDotazTyp getType() {
        return type;
    }

    public Date getResponseDate() {
        return responseDate;
    }

    public ChybovaOdpoved getFail() {
        return fail;
    }

    public List<StandardResponse> getStandardResponseList() {
        return standardResponseList;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(AresDotazTyp type) {
        this.type = type;
    }

    public void setResponseDate(Date responseDate) {
        this.responseDate = responseDate;
    }

    public void setFail(ChybovaOdpoved fail) {
        this.fail = fail;
    }

    @Override
    public String toString() {
        return "StandardResponses{" +
                "id='" + id + '\'' +
                ", type=" + type +
                ", responseDate=" + responseDate +
                ", fail=" + fail +
                ", standardResponseList=" + standardResponseList +
                '}';
    }
}
