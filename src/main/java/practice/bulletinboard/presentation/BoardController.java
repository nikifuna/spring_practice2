package practice.bulletinboard.presentation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import practice.bulletinboard.application.form.CommentForm;
import practice.bulletinboard.application.usecase.UserCommentUseCase;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final UserCommentUseCase userCommentUseCase;

    @GetMapping("/board")
    public ModelAndView viewBoard(ModelAndView mav) {
        mav.setViewName("board");
        mav.addObject("commentForm", new CommentForm());
        return mav;
    }

    @PostMapping("/board")
    public ModelAndView postComment(@Validated @ModelAttribute CommentForm comment, BindingResult result) {
        if (result.hasErrors()) {
            ModelAndView mav = new ModelAndView("/board");
            mav.addObject("commentForm", comment);
            return mav;
        }
        //エラーが無ければ保存する
        userCommentUseCase.write(comment);
        return new ModelAndView("redirect:/board");
    }
}
