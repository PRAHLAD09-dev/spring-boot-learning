package com.prahlad.rest.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileService 
{

    private static final String UPLOAD_DIR =
            System.getProperty("user.dir") + "/uploads/";

    public String upload(MultipartFile file) throws IOException 
    {

        if (file.isEmpty()) 
        {
            throw new IllegalArgumentException("File is empty");
        }

        File dir = new File(UPLOAD_DIR);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        String fileName =
                System.currentTimeMillis() + "_" + file.getOriginalFilename();

        File dest = new File(dir, fileName);
        file.transferTo(dest);

        return UPLOAD_DIR + fileName;
    }
}