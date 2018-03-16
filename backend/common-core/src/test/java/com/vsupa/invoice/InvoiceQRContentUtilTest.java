package com.vsupa.invoice;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Maxwell.Lee
 * @date 2018-01-17 17:42
 * @since   1.0.0
 */
public class InvoiceQRContentUtilTest {

    private static final String Original = "01,10,011001605111,80100798,64.9,20161018,85342965681116380258";
    private static final String WrongCase1 = "02,10,011001605111,80100798,64.9,20161018,85342965681116380258";
    private static final String WrongCase2 = "02,10,011001605111,80100798,64.9,20161018";
    private static final String TestCase = " 01, 10,011001605111,80100798,64.9 ,20161018,85342965681116380258 ";

    @Test
    public void prepare() {
        String real;

        real = InvoiceQRContentUtil.prepare(TestCase);
        Assert.assertEquals(Original, real);
    }

    @Test
    public void parseVATQRContent() {
        VATInvoiceQRContent actual;

        actual = InvoiceQRContentUtil.parseVATQRContent(Original);
        Assert.assertNotNull(actual);
        System.out.println(actual);

        actual = InvoiceQRContentUtil.parseVATQRContent(WrongCase1);
        Assert.assertNull(actual);

        actual = InvoiceQRContentUtil.parseVATQRContent(WrongCase2);
        Assert.assertNull(actual);
    }
}