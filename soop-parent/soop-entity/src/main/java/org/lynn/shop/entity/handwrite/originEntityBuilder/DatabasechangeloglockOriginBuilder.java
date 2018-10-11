package org.lynn.soop.entity.handwrite.originEntityBuilder;

import org.lynn.soop.entity.Databasechangeloglock;
import org.lynn.soop.entity.handwrite.DatabasechangeloglockExtend;

public class DatabasechangeloglockOriginBuilder extends Databasechangeloglock {

    public static DatabasechangeloglockExtend buildOrigin(Databasechangeloglock origin) {
        DatabasechangeloglockExtend returnValue=new DatabasechangeloglockExtend();
        returnValue.setID(origin.getID());
        returnValue.setLOCKED(origin.getLOCKED());
        returnValue.setLOCKGRANTED(origin.getLOCKGRANTED());
        returnValue.setLOCKEDBY(origin.getLOCKEDBY());
        return returnValue;
    }
}