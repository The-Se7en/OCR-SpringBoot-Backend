package com.example.ocr.Repository;
import com.example.ocr.Model.OcrUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OcrUserRepository extends CrudRepository<OcrUser,String> {
    OcrUser findOcrUsersByUsername(String username);
}
