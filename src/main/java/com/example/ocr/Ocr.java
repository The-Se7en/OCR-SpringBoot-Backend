package com.example.ocr;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

import java.io.File;

public class Ocr {
    public String performOcr(File file){
        ITesseract ins=new Tesseract();
        try{
            String result=ins.doOCR(file);
            return result;
        }catch (Exception e)
        {
            return e.toString();
        }
    }
}
