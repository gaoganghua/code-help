package com.code.help.others;

import com.code.help.BaseApplicationTests;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class PdfTest {
    @Test
    public void test() throws IOException {
        PDDocument pdDocument = PDDocument.load(new File("/Users/chancelee/Desktop/aa.pdf"));
        PDFTextStripper textStripper = new PDFTextStripper();

        int endPage = pdDocument.getNumberOfPages();

        textStripper.setStartPage(1);
        textStripper.setEndPage(endPage);

        System.out.println(textStripper.getText(pdDocument));
        System.out.println(endPage);

    }
}
