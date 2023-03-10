package practice.bulletinboard.application.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.bulletinboard.application.form.CommentForm;
import practice.bulletinboard.domain.model.UserComment;
import practice.bulletinboard.domain.model.UserCommentRepository;
import practice.bulletinboard.domain.model.UserComments;

@Service
@RequiredArgsConstructor
public class UserCommentUseCase {
    private final UserCommentRepository repository;
    /**
     * ユーザの書き込みをDBに反映し、表示するデータをプレゼンテーション層に渡す
     *
     * @param commentForm ユーザの入力データ
     * @return 表示するデータ
     */
    public void write(CommentForm commentForm){
        //フォームオブジェクトからドメインオブジェクトへ変換
        UserComment userComment = UserComment.from(
                commentForm.getName(),
                commentForm.getMailAddress(),
                commentForm.getComment()
        );
        //例えばここで、直近の投稿の一覧を取得し、今回と同じ内容の投稿がないかチェックする

        repository.save(userComment);
    }
    public UserComments read(){
        return repository.select();
    }
}
