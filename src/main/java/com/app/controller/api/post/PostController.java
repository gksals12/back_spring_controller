package com.app.controller.api.post;

import com.app.controller.mapper.PostMapper;
import com.app.domain.vo.PostVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.DeleteExchange;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/posts/*")
@Slf4j
@RequiredArgsConstructor
public class PostController {
    private final PostMapper postMapper;

    @GetMapping("/list")
    public List<PostVO> selectAll() {
        log.info("화면에서 리스트 요청 들어옴");
        return postMapper.selectAll();
    }

    @PostMapping("/write")
    public void insert(@RequestBody PostVO postVO) {
        log.info("화면에서 글 등록 요청 들어옴");
        log.info("글등록: {}", postVO);
        postMapper.insert(postVO);
    }

    @GetMapping("/read/{id}")
    public PostVO findPost(@PathVariable Long id) {
        log.info("id = {}",id);
        log.info("화면에서 상세페이지 요청 들어옴");
        postMapper.updateReadCount(id);
        Optional<PostVO> foundPost = postMapper.selectById(id);
        if(foundPost.isPresent()){
            log.info("상세페이지 요청 조건식 들어옴");
            return  foundPost.get();
        }
        return new  PostVO();
    }

    @PutMapping("/update")
    public void updatePost(@RequestBody PostVO postVO) {
        log.info(postVO.toString());
        log.info("화면에서 업데이트 요청 들어옴");
        postMapper.update(postVO);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePost(@PathVariable Long id) {
        log.info("id = {}", id);
        log.info("화면에서 삭제 요청 들어옴");
        postMapper.delete(id);
    }
}
