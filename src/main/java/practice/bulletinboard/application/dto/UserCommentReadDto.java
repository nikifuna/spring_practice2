package practice.bulletinboard.application.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UserCommentReadDto {
   private final int id;
   private final String name;
   private final String mailAddres;
   private final String comment;
   private final LocalDateTime createdAt;
}
