package com.assaabloy.notes.db;

import jetbrains.exodus.entitystore.PersistentEntityStore;
import jetbrains.exodus.entitystore.PersistentEntityStores;

public class XodusUtil {

    private final PersistentEntityStore entityStore;

    public XodusUtil(String databaseFolder) {
        entityStore = PersistentEntityStores.newInstance(databaseFolder);
    }

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
