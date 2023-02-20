package practice.bulletinboard.domain.model;

public interface UserCommentRepository {
    void save(UserComment dto);
    UserComments select();
}
