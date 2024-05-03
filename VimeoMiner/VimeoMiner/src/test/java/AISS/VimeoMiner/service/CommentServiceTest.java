package AISS.VimeoMiner.service;

import AISS.VimeoMiner.exception.MaxCommentsException;
import AISS.VimeoMiner.model.vimeo.comment.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CommentServiceTest {
    @Autowired
    CommentService commentService;

    @Test
    @DisplayName("Get an specific comment")
    void getComment(){
        Comment comment= commentService.getComment("","");
        System.out.println(comment);
    }

    @Test
    @DisplayName("Get comments from a video")
    void getVideoComments() throws MaxCommentsException {
        List<Comment> comments=commentService.getVideoComments("715547149",0);
        comments.stream().forEach(c->System.out.println(c+"\n"));
    }

}