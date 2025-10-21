package com.app.controller.mapper;

import com.app.domain.vo.PostVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PostMapper {
//  insert
    public void insert(PostVO postVO);
//  select
    public List<PostVO> selectAll();
    public Optional<PostVO> selectById(Long id);
//  update
    public void update(PostVO postVO);
    public void updateReadCount(Long id);
//  delete
    public void delete(Long id);
}
