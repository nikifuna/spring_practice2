package practice.bulletinboard.application.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import practice.bulletinboard.domain.model.UserComment;
import practice.bulletinboard.domain.model.UserCommentRepository;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UserCommentDto {
    private final String name;
    private final String mailAddress;
    private final String comment;

    public static UserCommentDto from(UserComment userComment) {
        return new UserCommentDto(
                userComment.getName().toString(),
                userComment.getMailAddress().toString(),
                userComment.getComment().toString()
        );
    }
}
