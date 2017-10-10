package com.fuuziii.test;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.text.DecimalFormat;

/**
 * @author yinlei
 * @since 2017/10/10 16:15
 */
public class FileSizeTest {

    @Test
    public void test() {
        File file = new File("D:\\1.jpg");
        try {
            FileInputStream fis = new FileInputStream(file);
            byte[] bytes = IOUtils.toByteArray(fis);
            IOUtils.closeQuietly(fis);
            DecimalFormat df = new DecimalFormat("######0.00");
            System.out.println(df.format(bytes.length / 1024.0) + "KB");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
