package AISS.VimeoMiner.service;

import AISS.VimeoMiner.model.vimeo.comment.User;
import AISS.VimeoMiner.model.videominer.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {
    @Autowired
    RestTemplate restTemplate;
    public User getUser(String id){
        String uri= "https://api.vimeo.com/users/"+ id;
        HttpHeaders httpHeaders= new HttpHeaders();
        String token= "25ea87773a8779c13f997ee68b9fad10";
        httpHeaders.set("Authorization","bearer "+ token);
        HttpEntity<User> request= new HttpEntity<>(null,httpHeaders);
        ResponseEntity<User> response= restTemplate.exchange(uri, HttpMethod.GET,request, User.class);
        return response.getBody();
    }
}
