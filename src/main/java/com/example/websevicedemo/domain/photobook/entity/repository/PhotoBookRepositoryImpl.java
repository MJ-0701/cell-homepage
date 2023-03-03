package com.example.websevicedemo.domain.photobook.entity.repository;

import com.example.websevicedemo.domain.file.entity.QPhotoBookFiles;
import com.example.websevicedemo.domain.photobook.entity.PhotoBook;
import com.example.websevicedemo.domain.photobook.entity.QPhotoBook;
import com.example.websevicedemo.domain.photobook.web.dto.PhotoBookFileDto;
import com.example.websevicedemo.domain.photobook.web.dto.PhotoBookSearchCondition;
import com.example.websevicedemo.domain.photobook.web.dto.QPhotoBookFileDto;
import com.example.websevicedemo.global.support.QuerydslSupportCustom;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.data.support.PageableExecutionUtils;

import javax.persistence.EntityManager;
import java.util.List;

import static com.example.websevicedemo.domain.file.entity.QPhotoBookFiles.photoBookFiles;
import static com.example.websevicedemo.domain.photobook.entity.QPhotoBook.photoBook;
import static io.jsonwebtoken.lang.Strings.hasText;

public class PhotoBookRepositoryImpl extends QuerydslRepositorySupport implements PhotoBookRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    public PhotoBookRepositoryImpl(EntityManager em) {
        super(PhotoBook.class);
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public List<PhotoBookFileDto> search(PhotoBookSearchCondition condition) {
        return null;
    }

    @Override
    public Page<PhotoBookFileDto> searchPageSimple(PhotoBookSearchCondition condition, Pageable pageable) {
        return null;
    }

    @Override
    public Page<PhotoBookFileDto> searchPageComplex(PhotoBookSearchCondition condition, Pageable pageable) {

        List<PhotoBookFileDto> content = queryFactory
                .select(new QPhotoBookFileDto(
                                        photoBook.id.as("photoBookId"),
                                        photoBook.title,
                                        photoBook.contents,
                        photoBookFiles.id.as("photoBookFileId"),
                        photoBookFiles.filePath,
                        photoBook.cratedAt
                                        ))
                .from(photoBook)
                .leftJoin(photoBook.files, photoBookFiles)
                .where(
                        titleLike(condition.getTitle()),
                        contentsLike(condition.getContents()),
                        photoBookId(condition.getPhotoBookId())
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(photoBook.cratedAt.desc())
                .fetch();

        JPAQuery<Long> countQuery = queryFactory
                .select(photoBook.count())
                .from(photoBook)
                .leftJoin(photoBook.files, photoBookFiles)
                .where(titleLike(condition.getTitle()),
                        contentsLike(condition.getContents()),
                        photoBookId(condition.getPhotoBookId())
                );

        return PageableExecutionUtils.getPage(content, pageable,
                countQuery::fetchOne);
    }


    private BooleanExpression titleLike(String title) {
        return hasText(title) ? photoBook.title.like(title) : null;
    }

    private BooleanExpression contentsLike(String contents) {
        return hasText(contents) ? photoBook.title.like(contents) : null;
    }

    private BooleanExpression photoBookId(Long photoBookId) {
        return photoBookId != null ? photoBook.id.eq(photoBookId) : null;
    }

}
