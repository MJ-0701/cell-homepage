package com.example.websevicedemo.global.utils;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@Service
@RequiredArgsConstructor
public class AmazonS3Service implements S3FileService{

    private final AmazonS3 amazonS3;
    private final AmazonS3Component amazonS3Component;

    @Override
    public void uploadFile(InputStream inputStream, ObjectMetadata objectMetadata, String fileName) {
        amazonS3.putObject(new PutObjectRequest(amazonS3Component.getBucket(), fileName, inputStream, objectMetadata).withCannedAcl(CannedAccessControlList.PublicReadWrite));
    }

    @Override
    public void deleteFile(String fileName) {
        amazonS3.deleteObject(new DeleteObjectRequest(amazonS3Component.getBucket(), fileName));
    }

    @Override
    public String getFileUrl(String fileName) {
        return amazonS3.getUrl(amazonS3Component.getBucket(), fileName).toString();
    }

    @Override
    public String getFileFolder(FileFolder fileFolder) {
        String folder = "";
        System.out.println("폴더 확인 : " + fileFolder.toString());
        if (fileFolder == FileFolder.YOOJINCELL_IMAGES) {
            folder = amazonS3Component.getFolderName();
        }
        return folder;
    }
}
