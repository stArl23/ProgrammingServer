package com.huidi.spring.boot.initializer.utils;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StringUtilsTest {

    @Test
    public void appendItem() throws Exception {
        String s1 = "1", s2 = "1&2", s3 = "";
        Assert.assertEquals("1", StringUtils.appendItem(s1, "1"));
        Assert.assertEquals("1&3", StringUtils.appendItem(s1, "3"));
        Assert.assertEquals("1&2&3", StringUtils.appendItem(s2, "3"));
        Assert.assertEquals("1", StringUtils.appendItem(s3, "1"));
    }

    @Test
    public void deleteItem() throws Exception {
        String s1 = "1&2", s2 = "", s3 = "1";
        Assert.assertEquals("2", StringUtils.deleteItem(s1, "1"));
        Assert.assertEquals("", StringUtils.deleteItem(s2, "1"));
        Assert.assertEquals("", StringUtils.deleteItem(s3, "1"));
    }

}