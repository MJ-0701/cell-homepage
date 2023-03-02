package com.example.websevicedemo.domain.file.entity;

import com.example.websevicedemo.domain.photobook.entity.PhotoBook;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PhotoBookFiles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String originalFileName;

    private String filePath;

    private Long fileSize;

    @ManyToOne
    @JoinColumn(name = "photo_book_id")
    private PhotoBook photoBook;

    @Builder
    public PhotoBookFiles(String originalFileName, String filePath, Long fileSize){
        this.originalFileName = originalFileName;
        this.filePath = filePath;
        this.fileSize = fileSize;
    }

    public void setPhotoBook(PhotoBook photoBook) { // 연관관계 매핑
        this.photoBook = photoBook;

        // 게시글에 현재 파일이 존재하지 않는다면.
        if(!photoBook.getFiles().contains(this)){
            photoBook.getFiles().add(this);
        }
    }
}
