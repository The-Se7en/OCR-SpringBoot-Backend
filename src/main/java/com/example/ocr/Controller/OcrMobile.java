package com.example.ocr.Controller;

import com.example.ocr.Model.OcrTextMobile;
import com.example.ocr.Ocr;
import com.example.ocr.Repository.OcrTextMobileRepository;
import com.example.ocr.Service.OcrTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.List;

@RestController
@RequestMapping("ocrMobileApi")
public class OcrMobile {

    @Autowired
    OcrTextMobileRepository ocrTextMobileRepository;
    @Autowired
    OcrTextService ocrTextService;
    OcrTextController ocrTextMobileController;

    @PostMapping("mobilePost")
    public String postImg(@RequestParam("image") MultipartFile file)
    {
        try {
            if (file == null) {
                System.out.println("null file");
            }else
            {
                byte[] imageBytes = file.getBytes();
                ByteArrayInputStream bis = new ByteArrayInputStream(imageBytes);
                BufferedImage bImage2 = ImageIO.read(bis);
                String path="C:\\Users\\Home\\Documents\\OMG\\mobileOutput\\output.jpg";
                ImageIO.write(bImage2, "jpg", new File(path) );
                Ocr ocr=new Ocr();
                String result= ocr.performOcr(new File(path));
                System.out.println(result);
                saveText(new OcrTextMobile(1,1,result));
                return result;

            }
        }catch (Exception e)
        {
            System.out.println(e.toString());
            return "excp";
        }
            return "returning";
    }


    @PutMapping("postText")
    public void saveText(@RequestBody OcrTextMobile ocrTextMobile)
    {
        ocrTextMobileRepository.save(ocrTextMobile);
    }

    @GetMapping("getText")
    public List<OcrTextMobile> getRest()
    {
        return (List<OcrTextMobile>) ocrTextMobileRepository.findAll();
    }
}
