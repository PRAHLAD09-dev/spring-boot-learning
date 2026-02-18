package com.prahlad.rest.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileService 
{

    private static final String UPLOAD_DIR = "uploads/";

    public String upload(MultipartFile file) throws IOException 
    {

        File dir = new File(UPLOAD_DIR);
        if (!dir.exists()) {
            dir.mkdir();
        }

        String path = UPLOAD_DIR + file.getOriginalFilename();
        file.transferTo(new File(path));

        return path;
    }
}