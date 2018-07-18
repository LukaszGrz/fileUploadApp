package com.example.springbootfileuploadmysql.service;

import com.example.springbootfileuploadmysql.model.DBfile;
import com.example.springbootfileuploadmysql.repository.DBFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class DBFileStorageService {

    @Autowired
    private DBFileRepository dbFileRepository;

    public DBfile storeFile(MultipartFile file){
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            //check if the file name contains invalid characters
            if (fileName.contains("..")){
                throw new FileStorageException("sorry fileName contains invalid path sewuence " + fileName);
            }

            DBfile dBfile = new DBfile(fileName, file.getContentType(), file.getBytes());

            return dbFileRepository.save(dBfile);
        }catch (IOException ex){
            throw new FileStorageException("could not store file " + fileName + ". please try again", ex);
        }
    }

    public DBfile getFile(String fileId){
        return dbFileRepository.findById(fileId).orElseThrow(()-> new MyFileNotFoundException(" file not found with id " + fileId));
    }
}
