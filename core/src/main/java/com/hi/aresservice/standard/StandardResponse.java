package com.hi.aresservice.standard;

import cz.mfcr.wwwinfo.ares.xml_doc.schemas.ares.ares_datatypes.v_1_0.AresVyberTyp2;
import cz.mfcr.wwwinfo.ares.xml_doc.schemas.ares.ares_datatypes.v_1_0.ErrorARES2;

import java.util.ArrayList;
import java.util.List;

public class StandardResponse {

    private int secondId;
    private AresVyberTyp2 searchType;
    private List<ErrorARES2> errors = new ArrayList<>();
    private List<StandardRecord> records = new ArrayList<>();

    public int getSecondId() {
        return secondId;
    }

    public AresVyberTyp2 getSearchType() {
        return searchType;
    }

    public List<ErrorARES2> getErrors() {
        return errors;
    }

    public List<StandardRecord> getRecords() {
        return records;
    }

    public void setSecondId(int secondId) {
        this.secondId = secondId;
    }

    public void setSearchType(AresVyberTyp2 searchType) {
        this.searchType = searchType;
    }

    @Override
    public String toString() {
        return "StandardResponse{" +
                "secondId=" + secondId +
                ", searchType=" + searchType +
                ", errors=" + errors +
                ", records=" + records +
                '}';
    }
}
