package com.example.ocr.Service;
import com.example.ocr.Repository.OcrTextMobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OcrTextService {
    @Autowired
    OcrTextMobileRepository ocrTextMobileRepository;

    public OcrTextService(OcrTextMobileRepository ocrTextMobileRepository) {
        this.ocrTextMobileRepository = ocrTextMobileRepository;
    }
}
