package com.app.controller.post;

import com.app.controller.mapper.PostMapper;
import com.app.domain.vo.PostVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class PostTest {
    @Autowired
    PostMapper postMapper;

    @Test
    public void selectAll() {
        List<PostVO> posts = postMapper.selectAll();
        log.info("posts: {}", posts);
    }
}
