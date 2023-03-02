package com.example.websevicedemo.global.utils;

import com.amazonaws.services.s3.model.ObjectMetadata;

import java.io.InputStream;

public interface S3FileService {

    void uploadFile(InputStream inputStream, ObjectMetadata objectMetadata, String fileName);

    void deleteFile(String fileName);

    String getFileUrl(String fileName);

    String getFileFolder(FileFolder fileFolder);
}
