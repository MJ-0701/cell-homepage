package com.example.websevicedemo.global.utils;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Getter
@PropertySource("classpath:real-application.yml")
public class AmazonS3Component {

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;


    private static String folderName;

    @Value("${cloud.aws.s3.folder.folderName}")
    public void setFolderName(String ymlAccessValue){
        folderName = ymlAccessValue;
    }

    public String getFolderName(){
        return folderName;
    }
}
