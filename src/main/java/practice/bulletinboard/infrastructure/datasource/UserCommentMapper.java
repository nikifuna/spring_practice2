package practice.bulletinboard.infrastructure.datasource;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import practice.bulletinboard.application.dto.UserCommentDto;

@Mapper
public interface UserCommentMapper {
    @Insert("sql/insertUserComment.sql")
    void insert(@Param("dto") UserCommentDto dto);
}