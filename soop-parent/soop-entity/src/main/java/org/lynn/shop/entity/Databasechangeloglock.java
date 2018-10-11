package org.lynn.soop.entity;

import java.io.Serializable;
import java.util.Date;

public class Databasechangeloglock implements Serializable {
    private Integer ID;

    private Boolean LOCKED;

    private Date LOCKGRANTED;

    private String LOCKEDBY;

    private static final long serialVersionUID = 1L;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Boolean getLOCKED() {
        return LOCKED;
    }

    public void setLOCKED(Boolean LOCKED) {
        this.LOCKED = LOCKED;
    }

    public Date getLOCKGRANTED() {
        return LOCKGRANTED;
    }

    public void setLOCKGRANTED(Date LOCKGRANTED) {
        this.LOCKGRANTED = LOCKGRANTED;
    }

    public String getLOCKEDBY() {
        return LOCKEDBY;
    }

    public void setLOCKEDBY(String LOCKEDBY) {
        this.LOCKEDBY = LOCKEDBY == null ? null : LOCKEDBY.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", ID=").append(ID);
        sb.append(", LOCKED=").append(LOCKED);
        sb.append(", LOCKGRANTED=").append(LOCKGRANTED);
        sb.append(", LOCKEDBY=").append(LOCKEDBY);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}