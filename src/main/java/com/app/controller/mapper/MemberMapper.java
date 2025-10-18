package com.app.controller.mapper;

import com.app.domain.vo.MemberVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MemberMapper {
//    회원가입
    public void insert(MemberVO memberVO);
//    로그인
    public Optional<MemberVO> selectByMemberEmailAndMemberPassword(MemberVO memberVO);
//    이메일로 id조회
    public Long selectIdByMemberEmail(String memberEmail);
//    id로 회원정보 조회
    public Optional<MemberVO> selectById(Long id);

//    회원 정보 수정
    public void update(MemberVO memberVO);
//    회원탈퇴
    public void delete(Long id);

}
