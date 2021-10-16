package model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Books {  

private long bcode ;
private String bprice ;
private String bname ;
private String blang;
private String bdate ;
private String authcode ;
private String authfname ;
private String authlname ;
private String pcode ;
private String pfname;
private String plname ;
private String pcountry ;
public Books() {
}
public Books(long bcode, String bprice, String bname, String blang, String bdate, String authcode, String authfname,
        String authlname, String pcode, String pfname, String plname, String pcountry) {
    this.bcode = bcode;
    this.bprice = bprice;
    this.bname = bname;
    this.blang = blang;
    this.bdate = bdate;
    this.authcode = authcode;
    this.authfname = authfname;
    this.authlname = authlname;
    this.pcode = pcode;
    this.pfname = pfname;
    this.plname = plname;
    this.pcountry = pcountry;
}


@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "bcode",nullable = false)
public long getBcode() {
    return bcode;
}
public void setBcode(long bcode) {
    this.bcode = bcode;
}

@Column(name = "bprice",nullable = false)
public String getBprice() {
    return bprice;
}
public void setBprice(String bprice) {
    this.bprice = bprice;
}

@Column(name = "bname",nullable = false)
public String getBname() {
    return bname;
}
public void setBname(String bname) {
    this.bname = bname;
}

@Column(name = "blang",nullable = false)
public String getBlang() {
    return blang;
}
public void setBlang(String blang) {
    this.blang = blang;
}

@Column(name = "bdate",nullable = false)
public String getBdate() {
    return bdate;
}
public void setBdate(String bdate) {
    this.bdate = bdate;
}

@Column(name = "authcode",nullable = false)
public String getAuthcode() {
    return authcode;
}
public void setAuthcode(String authcode) {
    this.authcode = authcode;
}

@Column(name = "authfname",nullable = false)
public String getAuthfname() {
    return authfname;
}

public void setAuthfname(String authfname) {
    this.authfname = authfname;
}

@Column(name = "authlname",nullable = false)
public String getAuthlname() {
    return authlname;
}
public void setAuthlname(String authlname) {
    this.authlname = authlname;
}

@Column(name = "pcode",nullable = false)
public String getPcode() {
    return pcode;
}
public void setPcode(String pcode) {
    this.pcode = pcode;
}

@Column(name = "pfname",nullable = false)
public String getPfname() {
    return pfname;
}
public void setPfname(String pfname) {
    this.pfname = pfname;
}

@Column(name = "plname",nullable = false)
public String getPlname() {
    return plname;
}
public void setPlname(String plname) {
    this.plname = plname;
}

@Column(name = "pcountry",nullable = false)
public String getPcountry() {
    return pcountry;
}
public void setPcountry(String pcountry) {
    this.pcountry = pcountry;
}


    
}
