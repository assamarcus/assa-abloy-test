package com.assaabloy.notes.db;

import jetbrains.exodus.entitystore.*;

import javax.validation.constraints.NotNull;

public class XodusManager {

    String databaseFolder = "/Users/marcusleander/.myXodusAppData";

    public void doIt() {


        final PersistentEntityStore entityStore = PersistentEntityStores.newInstance(databaseFolder);
        entityStore.executeInTransaction(new StoreTransactionalExecutable() {
            @Override
            public void execute(@NotNull final StoreTransaction txn) {
                final Entity message = txn.newEntity("Message");
                message.setProperty("hello", "World!");
            }
        });
        entityStore.close();
    }

}
