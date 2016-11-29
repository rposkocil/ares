package com.hi.aresservice;

import com.hi.aresservice.standard.StandardRecord;
import com.hi.aresservice.standard.StandardResponse;
import com.hi.aresservice.standard.StandardResponseTemplate;
import com.hi.aresservice.standard.StandardResponses;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import cz.mfcr.wwwinfo.ares.xml_doc.schemas.ares.ares_answer.v_1_0.*;
import cz.mfcr.wwwinfo.ares.xml_doc.schemas.ares.ares_datatypes.v_1_0.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class StandardResponseTemplateTest {

    private static StandardResponses standardResponses;
    private static Zaznam zaznam;

    @BeforeClass
    public static void init(){
        StandardResponseTemplate responseTemplate = new StandardResponseTemplate();
        standardResponses = responseTemplate.transform(generateAresOdpovedi());
    }

    @Test
    public void testStandardResponsesTransformation(){
        Assert.assertEquals("Id is NOT correct.", "id", standardResponses.getId());
        Assert.assertEquals("Error is NOT correct.", null, standardResponses.getFail());
        Assert.assertEquals("Type is NOT correct.", AresDotazTyp.STANDARD, standardResponses.getType());
        Assert.assertEquals("Count of responses is NOT correct.", 3, standardResponses.getStandardResponseList().size());
    }

    @Test
    public void testStandardResponseTransformation(){
        StandardResponse response1 = standardResponses.getStandardResponseList().get(0);
        StandardResponse response2 = standardResponses.getStandardResponseList().get(1);
        StandardResponse response3 = standardResponses.getStandardResponseList().get(2);

        Assert.assertEquals("SecondId is NOT correct.", 1, response1.getSecondId());
        Assert.assertEquals("SecondId is NOT correct.", 2, response2.getSecondId());
        Assert.assertEquals("SecondId is NOT correct.", 3, response3.getSecondId());

        Assert.assertEquals("Count of records is NOT correct.", 0, response1.getRecords().size());
        Assert.assertEquals("Count of records is NOT correct.", 1, response2.getRecords().size());
        Assert.assertEquals("Count of records is NOT correct.", 3, response3.getRecords().size());

        for(StandardResponse response : standardResponses.getStandardResponseList()) {
            Assert.assertEquals("Search type is not FREE.", AresVyberTyp2.FREE, response.getSearchType());
        }
    }

    @Test
    public void testStandardRecordTransfromation(){
        StandardRecord record = standardResponses.getStandardResponseList().get(1).getRecords().get(0);
        Assert.assertEquals("IcoStatus.K is NOT correct.", zaznam.getShodaICO().getK(), record.getIcoStatus().getK());
        Assert.assertEquals("IdStatus.V is NOT correct.", zaznam.getShodaRC().getT(), record.getIdStatus().getT());
        Assert.assertEquals("CompanyStatus is NOT correct.", zaznam.getShodaOF().getK(), record.getCompanyStatus().getK());
        Assert.assertEquals("SearchBy is NOT correct.", zaznam.getVyhledanoDle(), record.getSearchBy());
        Assert.assertEquals("CatalogType is NOT correct.", zaznam.getTypRegistru().getT(), record.getCatalogType().getT());
        Assert.assertEquals("LegalForm is NOT correct.", zaznam.getPravniForma().getKPF(), record.getLegalForm().getKPF());
        Assert.assertEquals("Ico is NOT correct.", zaznam.getICO(), record.getIco());
        Assert.assertEquals("Company is NOT correct.", zaznam.getObchodniFirma(), record.getCompany());
        Assert.assertEquals("Identification is NOT correct.", zaznam.getIdentifikace().getOsoba().getP(), record.getIdentification().getOsoba().getP());
        Assert.assertEquals("Code is NOT correct.", zaznam.getKodFU(), record.getCode());
        Assert.assertEquals("Properties are NOT correct.", zaznam.getPriznakySubjektu(), record.getProperties());
    }

    private static AresOdpovedi generateAresOdpovedi() {

        AresOdpovedi aresOdpovedi = new AresOdpovedi();
        aresOdpovedi.setId("id");
        aresOdpovedi.setFault(null);
        aresOdpovedi.setOdpovedTyp(AresDotazTyp.STANDARD);

        Odpoved odpoved1 = generateOdpoved(1, 0);
        Odpoved odpoved2 = generateOdpoved(2, 1);
        Odpoved odpoved3 = generateOdpoved(3, 3);

        aresOdpovedi.getOdpoved().add(odpoved1);
        aresOdpovedi.getOdpoved().add(odpoved2);
        aresOdpovedi.getOdpoved().add(odpoved3);

        return aresOdpovedi;
    }

    private static Odpoved generateOdpoved(int id, int countOfZaznam) {
        Odpoved odpoved = new Odpoved();
        odpoved.setPomocneID(id);
        odpoved.setPocetZaznamu(countOfZaznam);
        odpoved.setTypVyhledani(AresVyberTyp2.FREE);
        generateZaznam();
        for(int i = 0; i < countOfZaznam; i++) {
            odpoved.getZaznam().add(zaznam);
        }
        return odpoved;
    }

    private static Zaznam generateZaznam() {
        zaznam = new Zaznam();

        ShodaICO2 shodaICO2 = new ShodaICO2();
        shodaICO2.setK(1);
        shodaICO2.setT("1");

        ShodaRC2 shodaRC2 = new ShodaRC2();
        shodaRC2.setK(2);
        shodaRC2.setT("2");

        ShodaOF2 shodaOF2 = new ShodaOF2();
        shodaOF2.setK(3);
        shodaOF2.setT("3");

        zaznam.setShodaICO(shodaICO2);
        zaznam.setShodaRC(shodaRC2);
        zaznam.setShodaOF(shodaOF2);

        zaznam.setVyhledanoDle(VyhledanoDle.ICO);

        TypRegistru2 typRegistru2 = new TypRegistru2();
        typRegistru2.setK(4);
        typRegistru2.setT("4");

        zaznam.setTypRegistru(typRegistru2);
        zaznam.setDatumVzniku(new XMLGregorianCalendarImpl());
        zaznam.setDatumZaniku(new XMLGregorianCalendarImpl());
        zaznam.setDatumPlatnosti(new XMLGregorianCalendarImpl());

        PravniForma2 pravniForma2 = new PravniForma2();
        pravniForma2.setDdo(new XMLGregorianCalendarImpl());
        pravniForma2.setDod(new XMLGregorianCalendarImpl());
        pravniForma2.setKPF(new Short("1"));
        pravniForma2.setNPF("npf");
        pravniForma2.setPFO(PfOsoba2.P);
        pravniForma2.setTZU(TzuOsoba2.TUZEMSKÁ);
        pravniForma2.setZdroj(ZdrojType2.ARES);

        zaznam.setPravniForma(pravniForma2);
        zaznam.setICO("ico");
        zaznam.setObchodniFirma("company");

        Identifikace identifikace = new Identifikace();
        AdresaARES2 adresaARES2 = new AdresaARES2();
        adresaARES2.setKS("ks");
        identifikace.setAdresaARES(adresaARES2);
        identifikace.setAdrPuv(adresaARES2);
        FyzickaOsoba2 fyzickaOsoba2 = new FyzickaOsoba2();
        fyzickaOsoba2.setP("p");
        identifikace.setOsoba(fyzickaOsoba2);

        zaznam.setIdentifikace(identifikace);
        zaznam.setKodFU(new Short("1"));
        zaznam.setPriznakySubjektu("priznaky");
        return zaznam;
    }
}
