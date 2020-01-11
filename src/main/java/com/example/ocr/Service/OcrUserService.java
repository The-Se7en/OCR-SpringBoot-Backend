package com.example.ocr.Service;
import com.example.ocr.Model.OcrUser;
import com.example.ocr.Repository.OcrUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OcrUserService {
    @Autowired
    OcrUserRepository ocrUserRepository;

    public OcrUserService(OcrUserRepository ocrUserRepository) {
        this.ocrUserRepository=ocrUserRepository;
    }

    public List<OcrUser>getAll(){
        return (List<OcrUser>) ocrUserRepository.findAll();
    }
}
