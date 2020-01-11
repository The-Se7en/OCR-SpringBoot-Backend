package com.example.ocr.Repository;
import com.example.ocr.Model.OcrImage;
import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface OcrImageRepository extends CrudRepository<OcrImage,Integer>{
}
