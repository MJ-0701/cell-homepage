package com.example.websevicedemo.domain.photobook.entity;

import com.example.websevicedemo.domain.file.entity.Files;
import com.example.websevicedemo.global.entity.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class PhotoBook extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @OneToMany(mappedBy = "photoBook", cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true)
    private List<Files> files = new ArrayList<>();

    private String contents;

    @Builder
    public PhotoBook(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }


    // PhotoBook에서 파일 처리 위함.
    public void addFiles(Files files){
        this.files.add(files);

        // 게시글에 파일이 저장되어있지 않은 경우
        if(files.getPhotoBook() != this){
            // 파일 저장
            files.setPhotoBook(this);
        }
    }





}
