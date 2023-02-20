package practice.bulletinboard.infrastructure.datasource;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import practice.bulletinboard.application.dto.UserCommentDto;
import practice.bulletinboard.application.dto.UserCommentReadDto;
import practice.bulletinboard.domain.model.UserComment;
import practice.bulletinboard.domain.model.UserCommentRepository;
import practice.bulletinboard.domain.model.UserComments;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
public class UserCommentDatasource implements UserCommentRepository {
    private final UserCommentMapper mapper;

    @Override
    public void save(UserComment userComment) {
        mapper.insert(UserCommentDto.from(userComment));
    }

    @Override
    public UserComments select() {
        List<UserCommentReadDto> dtos = mapper.select();
        return UserComments.from(
                dtos.stream().map(dto -> UserComments.UserComment.from(
                        dto.getId(),
                        dto.getName(),
                        dto.getMailAddres(),
                        dto.getComment(),
                        dto.getCreatedAt()
                        )).collect(Collectors.toUnmodifiableList())
        );
    }
}
