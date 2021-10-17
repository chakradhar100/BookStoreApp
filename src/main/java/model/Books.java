package model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "books")
public class Books {  

    @Id
    @NotEmpty
	@GeneratedValue(strategy=GenerationType.IDENTITY)   
    private long bcode ;     
    @NotEmpty
    private String bprice ;   
    @NotEmpty
    private String bname ;
    @NotEmpty    
    private String blang;   
    @NotEmpty
    private String bdate ;   
    @NotEmpty 
    private String authcode ;   
    @NotEmpty
    private String authfname ;    
    @NotEmpty
    private String authlname ;    
    @NotEmpty
    private String pcode ;   
    @NotEmpty
    private String pfname;   
    @NotEmpty 
    private String plname ;    
    @NotEmpty
    private String pcountry ;

public Books() {
}
public Books(long bcode,String bprice, String bname, String blang, String bdate, String authcode, String authfname,
        String authlname, String pcode, String pfname, String plname, String pcountry) {
    this.bcode=bcode;
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



public long getBcode() {
    return bcode;
}
public void setBcode(long bcode) {
    this.bcode = bcode;
}


public String getBprice() {
    return bprice;
}
public void setBprice(String bprice) {
    this.bprice = bprice;
}


public String getBname() {
    return bname;
}
public void setBname(String bname) {
    this.bname = bname;
}


public String getBlang() {
    return blang;
}
public void setBlang(String blang) {
    this.blang = blang;
}


public String getBdate() {
    return bdate;
}
public void setBdate(String bdate) {
    this.bdate = bdate;
}


public String getAuthcode() {
    return authcode;
}
public void setAuthcode(String authcode) {
    this.authcode = authcode;
}


public String getAuthfname() {
    return authfname;
}

public void setAuthfname(String authfname) {
    this.authfname = authfname;
}


public String getAuthlname() {
    return authlname;
}
public void setAuthlname(String authlname) {
    this.authlname = authlname;
}


public String getPcode() {
    return pcode;
}
public void setPcode(String pcode) {
    this.pcode = pcode;
}


public String getPfname() {
    return pfname;
}
public void setPfname(String pfname) {
    this.pfname = pfname;
}


public String getPlname() {
    return plname;
}
public void setPlname(String plname) {
    this.plname = plname;
}


public String getPcountry() {
    return pcountry;
}
public void setPcountry(String pcountry) {
    this.pcountry = pcountry;
}


    
}
