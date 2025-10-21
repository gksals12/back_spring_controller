package com.app.controller.api.member;

import com.app.controller.mapper.MemberMapper;
import com.app.domain.vo.MemberVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/members/*")
@RequiredArgsConstructor
@Slf4j
public class MemberAPI {

    final private MemberMapper memberMapper;

    @PostMapping("/register")
    public void registerMember(@RequestBody MemberVO memberVO){
        log.info("memberVO: {}", memberVO);
        memberMapper.insert(memberVO);
        log.info("회원가입 성공");
    }

    @PostMapping("/login")
    public MemberVO login(@RequestBody MemberVO memberVO){
        log.info("memberVO: {}", memberVO);
        Optional<MemberVO> foundMember = memberMapper.selectByMemberEmailAndMemberPassword(memberVO);
        log.info("foundMember: {}", foundMember);
        if(foundMember.isPresent()){
            return foundMember.get();
        }
        return new MemberVO();
    }

    @PostMapping("/find")
    public MemberVO findMember(@RequestBody MemberVO memberVO){
        log.info("memberVO: {}", memberVO);
        Long id = memberMapper.selectIdByMemberEmail(memberVO.getMemberEmail());
        Optional<MemberVO> foundMember = memberMapper.selectById(id);
        if(foundMember.isPresent()){
            return foundMember.get();
        }
        return new MemberVO();
    }

    @PutMapping("/modify")
    public void modifyMember(@RequestBody MemberVO memberVO){
        memberMapper.update(memberVO);
    }

    @DeleteMapping("/unregister")
    public void unRegisterMember(@RequestBody MemberVO memberVO){
        Long id = memberMapper.selectIdByMemberEmail(memberVO.getMemberEmail());
        memberMapper.delete(id);
    }
}
