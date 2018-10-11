package org.lynn.soop.entity.handwrite.originEntityBuilder;

import org.lynn.soop.entity.Databasechangelog;
import org.lynn.soop.entity.handwrite.DatabasechangelogExtend;

public class DatabasechangelogOriginBuilder extends Databasechangelog {

    public static DatabasechangelogExtend buildOrigin(Databasechangelog origin) {
        DatabasechangelogExtend returnValue=new DatabasechangelogExtend();
        returnValue.setID(origin.getID());
        returnValue.setAUTHOR(origin.getAUTHOR());
        returnValue.setFILENAME(origin.getFILENAME());
        returnValue.setDATEEXECUTED(origin.getDATEEXECUTED());
        returnValue.setORDEREXECUTED(origin.getORDEREXECUTED());
        returnValue.setEXECTYPE(origin.getEXECTYPE());
        returnValue.setMD5SUM(origin.getMD5SUM());
        returnValue.setDESCRIPTION(origin.getDESCRIPTION());
        returnValue.setCOMMENTS(origin.getCOMMENTS());
        returnValue.setTAG(origin.getTAG());
        returnValue.setLIQUIBASE(origin.getLIQUIBASE());
        return returnValue;
    }
}