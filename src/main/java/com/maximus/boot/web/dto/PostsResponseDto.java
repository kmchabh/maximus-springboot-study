package com.maximus.boot.web.dto;

import com.maximus.boot.domain.posts.posts;
import lombok.Getter;

@Getter

public class PostsResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }

}
