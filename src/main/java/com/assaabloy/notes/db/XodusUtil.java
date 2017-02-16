package com.assaabloy.notes.db;

import jetbrains.exodus.entitystore.*;

import javax.validation.constraints.NotNull;

public class XodusUtil {

    private final String databaseFolder = "/Users/marcusleander/.myXodusAppData";
    private final PersistentEntityStore entityStore = PersistentEntityStores.newInstance(databaseFolder);

    public int createUser(String userName) {

        /*
        entityStore.executeInTransaction(new StoreTransactionalExecutable() {
            @Override
            public void execute(@NotNull final StoreTransaction txn) {
                final Entity message = txn.newEntity("Message");
                message.setProperty("hello", "World!");
            }
        });
        entityStore.close();
        */
        return 1;
    }

}
