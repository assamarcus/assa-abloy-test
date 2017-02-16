package com.assaabloy.notes.db;

import jetbrains.exodus.util.IOUtil;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class XodusUtilTest {

    @Test
    public void createdUserShouldReturnNewUserId() throws Exception {
        final XodusUtil xodusUtil = new XodusUtil("/Users/marcusleander/.myXodusAppData");
        final int userId = xodusUtil.createUser("Steffe");
        assertThat(userId, is(1));
    }

    private void cleanUp(String location) {
        final File tempFolder = new File(location);
        IOUtil.deleteRecursively(tempFolder);
        IOUtil.deleteFile(tempFolder);
    }
}