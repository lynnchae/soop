package org.lynn.soop.entity;

import java.io.Serializable;
import java.util.Date;

public class Databasechangelog implements Serializable {
    private String ID;

    private String AUTHOR;

    private String FILENAME;

    private Date DATEEXECUTED;

    private Integer ORDEREXECUTED;

    private String EXECTYPE;

    private String MD5SUM;

    private String DESCRIPTION;

    private String COMMENTS;

    private String TAG;

    private String LIQUIBASE;

    private static final long serialVersionUID = 1L;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID == null ? null : ID.trim();
    }

    public String getAUTHOR() {
        return AUTHOR;
    }

    public void setAUTHOR(String AUTHOR) {
        this.AUTHOR = AUTHOR == null ? null : AUTHOR.trim();
    }

    public String getFILENAME() {
        return FILENAME;
    }

    public void setFILENAME(String FILENAME) {
        this.FILENAME = FILENAME == null ? null : FILENAME.trim();
    }

    public Date getDATEEXECUTED() {
        return DATEEXECUTED;
    }

    public void setDATEEXECUTED(Date DATEEXECUTED) {
        this.DATEEXECUTED = DATEEXECUTED;
    }

    public Integer getORDEREXECUTED() {
        return ORDEREXECUTED;
    }

    public void setORDEREXECUTED(Integer ORDEREXECUTED) {
        this.ORDEREXECUTED = ORDEREXECUTED;
    }

    public String getEXECTYPE() {
        return EXECTYPE;
    }

    public void setEXECTYPE(String EXECTYPE) {
        this.EXECTYPE = EXECTYPE == null ? null : EXECTYPE.trim();
    }

    public String getMD5SUM() {
        return MD5SUM;
    }

    public void setMD5SUM(String MD5SUM) {
        this.MD5SUM = MD5SUM == null ? null : MD5SUM.trim();
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION == null ? null : DESCRIPTION.trim();
    }

    public String getCOMMENTS() {
        return COMMENTS;
    }

    public void setCOMMENTS(String COMMENTS) {
        this.COMMENTS = COMMENTS == null ? null : COMMENTS.trim();
    }

    public String getTAG() {
        return TAG;
    }

    public void setTAG(String TAG) {
        this.TAG = TAG == null ? null : TAG.trim();
    }

    public String getLIQUIBASE() {
        return LIQUIBASE;
    }

    public void setLIQUIBASE(String LIQUIBASE) {
        this.LIQUIBASE = LIQUIBASE == null ? null : LIQUIBASE.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ID=").append(ID);
        sb.append(", AUTHOR=").append(AUTHOR);
        sb.append(", FILENAME=").append(FILENAME);
        sb.append(", DATEEXECUTED=").append(DATEEXECUTED);
        sb.append(", ORDEREXECUTED=").append(ORDEREXECUTED);
        sb.append(", EXECTYPE=").append(EXECTYPE);
        sb.append(", MD5SUM=").append(MD5SUM);
        sb.append(", DESCRIPTION=").append(DESCRIPTION);
        sb.append(", COMMENTS=").append(COMMENTS);
        sb.append(", TAG=").append(TAG);
        sb.append(", LIQUIBASE=").append(LIQUIBASE);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}