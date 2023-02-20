package practice.bulletinboard.domain.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.util.CollectionUtils;
import practice.bulletinboard.domain.type.Comment;
import practice.bulletinboard.domain.type.DateTime;
import practice.bulletinboard.domain.type.MailAddress;
import practice.bulletinboard.domain.type.Name;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UserComments {
    private final List<UserComment> values;

    public static UserComments from(List<UserComment> comments) {
        if (CollectionUtils.isEmpty(comments)) return new UserComments(Collections.emptyList());
        return new UserComments(comments);
    }

    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    @Getter
    public static class UserComment {
        private final int id;
        private final Name name;
        private final MailAddress mailAddress;
        private final Comment comment;
        private final DateTime dateTime;

        public static UserComment from(
                int id,
                String name,
                String mailAddress,
                String comment,
                LocalDateTime dateTime
        ) {
            return new UserComment(
                    id,
                    Name.from(name),
                    MailAddress.from(mailAddress),
                    Comment.from(comment),
                    DateTime.from(dateTime)
            );
        }
    }
}
