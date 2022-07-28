package com.maximus.boot.service.posts;

import com.maximus.boot.domain.posts.PostsRepository;
import com.maximus.boot.domain.posts.posts;
import com.maximus.boot.web.dto.PostsListResponseDto;
import com.maximus.boot.web.dto.PostsResponseDto;
import com.maximus.boot.web.dto.PostsSaveRequestDto;
import com.maximus.boot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service

public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional

    public Long saves(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional

    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    @Transactional
    public void delete(Long id) {
        posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. Id="+ id));

        postsRepository.delete(posts);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    public PostsResponseDto findById (Long id) {
        posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        return new PostsResponseDto(entity);
    }



}
