package practice.bulletinboard.infrastructure.datasource;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import practice.bulletinboard.application.dto.UserCommentDto;
import practice.bulletinboard.domain.model.UserComment;
import practice.bulletinboard.domain.model.UserCommentRepository;

@RequiredArgsConstructor
@Repository
public class UserCommentDatasource implements UserCommentRepository {
    private final UserCommentMapper mapper;
    @Override
    public void save(UserComment userComment){
        mapper.insert(UserCommentDto.from(userComment));
    }
}
