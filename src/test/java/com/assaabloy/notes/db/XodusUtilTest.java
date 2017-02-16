package com.assaabloy.notes.db;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class XodusUtilTest {

    @Test
    public void createdUserShouldReturnNewUserId() throws Exception {

        final XodusUtil xodusUtil = new XodusUtil();
        final int userId = xodusUtil.createUser("Steffe");
        assertThat(userId, is(1));
    }
}