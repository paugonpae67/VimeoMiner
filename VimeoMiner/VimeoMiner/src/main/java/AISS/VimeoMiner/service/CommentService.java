package AISS.VimeoMiner.service;


import AISS.VimeoMiner.exception.MaxCommentsException;
import AISS.VimeoMiner.model.videominer.Caption;
import AISS.VimeoMiner.model.vimeo.comment.Comment;
import AISS.VimeoMiner.model.vimeo.comments.Comments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    RestTemplate restTemplate;
    public Comment getComment(String videoId, String id){
        String uri= "https://api.vimeo.com/videos/"+ videoId+"/comments/"+ id;
        HttpHeaders httpHeaders= new HttpHeaders();
        String token= "25ea87773a8779c13f997ee68b9fad10";
        httpHeaders.set("Authorization","bearer "+ token);
        HttpEntity<Comment> request= new HttpEntity<>(null,httpHeaders);
        ResponseEntity<Comment> response= restTemplate.exchange(uri, HttpMethod.GET,request, Comment.class);
        return response.getBody();
    }

    public List<Comment> getVideoComments(String videoId, Integer maxComments) throws MaxCommentsException {
        if(maxComments==null || maxComments<0){
            throw new MaxCommentsException();
        }else if(maxComments>0){
            String uri= "https://api.vimeo.com/videos/"+ videoId+"/comments/?per_page="+maxComments
                    +"&fields=created_on,text,uri,user"; //Field filtering
            HttpHeaders httpHeaders= new HttpHeaders();
            String token= "25ea87773a8779c13f997ee68b9fad10";
            httpHeaders.set("Authorization","bearer "+ token);
            HttpEntity<Comments> request= new HttpEntity<>(null,httpHeaders);
            ResponseEntity<Comments> response= restTemplate.exchange(uri, HttpMethod.GET,request, Comments.class);
            if(response.hasBody()) {
                return response.getBody().getData();
            }else{
                return new LinkedList<Comment>();
            }
        }else{
            return new LinkedList<Comment>();
        }

    }
}
