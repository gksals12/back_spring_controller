package com.app.controller.member;

import com.app.controller.mapper.MemberMapper;
import com.app.domain.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class MemberAPITest {
    @Autowired
    MemberMapper memberMapper;
    @Test
    public void select() {
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("test123@gmail.com");
        memberVO.setMemberPassword("test123!@#");
        log.info(memberVO.toString());
        memberMapper.selectByMemberEmailAndMemberPassword(memberVO);
        log.info("체크 : {}",memberMapper.selectByMemberEmailAndMemberPassword(memberVO));
    }
}
