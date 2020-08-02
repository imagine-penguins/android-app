package com.startuppro;


import com.google.firebase.firestore.Exclude;

public class Note {
    private String documentId;
    private String name;
    private String designation;
    private String email;
    private String number;
    private String companyname;
    private String companywebsite;
    private String companyaddress;
    private String description;
    private String companytype;
    private String establishment;
    private String turnover;



    public Note(){

    }

    @Exclude
    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public Note(String names, String designation,String email,String number, String companyname,String companywebsite, String address,
                 String companytype, String establishment, String turnover,String description) {
        this.name = names;
        this.designation = designation;
        this.email= email;
        this.number= number;
        this.companyname = companyname;
        this.companywebsite= companywebsite;
        this.companyaddress = address;
        this.companytype = companytype;
        this.establishment = establishment;
        this.turnover = turnover;
        this.description= description;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public String getEmail() {
        return email;
    }

    public String getNumber() {
        return number;
    }

    public String getCompanyname() {
        return companyname;
    }

    public String getCompanywebsite() {
        return companywebsite;
    }

    public String getCompanyaddress() {
        return companyaddress;
    }


    public String getCompanytype() {
        return companytype;
    }

    public String getEstablishment() {
        return establishment;
    }

    public String getTurnover() {
        return turnover;
    }
    public String getDescription() {
        return description;
    }
}
