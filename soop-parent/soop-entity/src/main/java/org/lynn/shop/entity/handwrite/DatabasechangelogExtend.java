package org.lynn.soop.entity.handwrite;

import org.lynn.soop.entity.Databasechangelog;
import org.lynn.soop.entity.handwrite.originEntityBuilder.DatabasechangelogOriginBuilder;

public class DatabasechangelogExtend extends Databasechangelog {

    public static DatabasechangelogExtend generateFromOriginEntity(Databasechangelog origin) {
        return DatabasechangelogOriginBuilder.buildOrigin(origin);
    }
}