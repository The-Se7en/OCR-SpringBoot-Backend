package com.example.ocr.Controller;

import com.example.ocr.Model.OcrUser;
import com.example.ocr.Repository.OcrUserRepository;
import com.example.ocr.Service.OcrUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ocrUserApi/")
public class OcrUserController {
    @Autowired
    OcrUserRepository ocrUserRepository;
    @Autowired
    OcrUserService ocrUserService;

    @PostMapping("postOcr")
    public String postUser(@RequestBody OcrUser ocrUser)
    {
        if(getbyUsername(ocrUser.getUsername())==null)
        {
            ocrUserRepository.save(ocrUser);
            return  "Success";
        }else {
            return "Already exists";
        }

    }

    @GetMapping("getall")
    public List<OcrUser>getAll()
    {
        return (List<OcrUser>) ocrUserRepository.findAll();
    }

    @GetMapping("userbyname/{name}")
    public OcrUser getbyUsername(@PathVariable String name)
    {
        return ocrUserRepository.findOcrUsersByUsername(name);
    }

    @PostMapping("loginReq")
    public String getunameAndPass(@RequestBody OcrUser ocrUser)
    {
        String enteredPasword=ocrUser.getPassword();
        String correctPaasword=checkUserLogin(ocrUser.getUsername()).getPassword();
        if(enteredPasword.equals(correctPaasword))
        {
            return "Correct Password";
        }else
        {
            return "Wrong Password";
        }
    }

    @GetMapping("getLoginInfo")
    public OcrUser checkUserLogin(@RequestParam String name)
    {
        return  ocrUserRepository.findOcrUsersByUsername(name);
    }

}
