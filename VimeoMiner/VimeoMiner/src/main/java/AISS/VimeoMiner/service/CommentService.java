package AISS.VimeoMiner.service;


import AISS.VimeoMiner.model.videominer.Caption;
import AISS.VimeoMiner.model.vimeo.comment.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CommentService {
    @Autowired
    RestTemplate restTemplate;
    public Comment getComment(String Videoid, String id){
        String uri= "https://api.vimeo.com/videos/"+ Videoid+"/comments/"+ id;
        HttpHeaders httpHeaders= new HttpHeaders();
        String token= "25ea87773a8779c13f997ee68b9fad10";
        httpHeaders.set("Authorization","bearer "+ token);
        HttpEntity<Comment> request= new HttpEntity<>(null,httpHeaders);
        ResponseEntity<Comment> response= restTemplate.exchange(uri, HttpMethod.GET,request, Comment.class);
        return response.getBody();
    }
}
