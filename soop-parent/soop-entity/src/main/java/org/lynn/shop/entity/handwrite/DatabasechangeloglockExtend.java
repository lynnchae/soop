package org.lynn.soop.entity.handwrite;

import org.lynn.soop.entity.Databasechangeloglock;
import org.lynn.soop.entity.handwrite.originEntityBuilder.DatabasechangeloglockOriginBuilder;

public class DatabasechangeloglockExtend extends Databasechangeloglock {

    public static DatabasechangeloglockExtend generateFromOriginEntity(Databasechangeloglock origin) {
        return DatabasechangeloglockOriginBuilder.buildOrigin(origin);
    }
}