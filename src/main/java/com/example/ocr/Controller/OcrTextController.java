package com.example.ocr.Controller;

import com.example.ocr.Model.OcrText;
import com.example.ocr.Repository.OcrTextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/textapi/")
public class OcrTextController {
    @Autowired
    OcrTextRepository ocrTextRepository;

    @PostMapping("postOcrText")
    public void saveOcrText(@RequestBody OcrText ocrText)
    {
        ocrTextRepository.save(ocrText);
    }
}
