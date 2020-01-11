package com.example.ocr.Controller;

import com.example.ocr.Model.OcrImage;
import com.example.ocr.Model.OcrText;
import com.example.ocr.Repository.OcrImageRepository;
import com.example.ocr.Service.OcrImageService;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("/imageApi/")
public class OcrImageController {
    @Autowired
    OcrImageRepository ocrImageRepository;
    @Autowired
    OcrImageService ocrImageService;
    @Autowired
    OcrTextController ocrTextController;

    @PostMapping("postImage")
    public String postImg(@RequestParam("image") MultipartFile file)
    {
        try {
            if (file == null) {
                System.out.println("null file");
            }else
            {
                byte[] imageBytes = file.getBytes();
                String fileDirPath = "C:\\Users\\Home\\Documents\\OMG\\images";
                File fileDir = new File(fileDirPath);
                File dest = new File(fileDir,  file.getOriginalFilename());
                file.transferTo(dest);
                //OcrImage image=new OcrImage(1,"amal",fileDir.toString()+"\\"+file.getOriginalFilename());
                OcrImage image=new OcrImage(1,"amal",dest.toString());
                ocrImageRepository.save(image);

                File fileImag=new File(image.getImgPath());
                ITesseract ins=new Tesseract();
                try{
                    String result=ins.doOCR(fileImag);
                    OcrText ocrText=new OcrText(1,1,result);
                    ocrTextController.saveOcrText(ocrText);
                    return result;
                }catch (Exception e)
                {
                    System.out.println("excep");
                }
            }
        }catch (Exception e)
        {
            System.out.println("exception");
        }
        return "";
    }
}

