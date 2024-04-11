package AISS.VimeoMiner.service;

import AISS.VimeoMiner.model.videominer.Caption;
import AISS.VimeoMiner.model.videominer.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class VideoService {
    @Autowired
    RestTemplate restTemplate;
    public Video getVideo(String id){
        String uri= "https://api.vimeo.com/videos/"+ id;
        HttpHeaders httpHeaders= new HttpHeaders();
        String token= "25ea87773a8779c13f997ee68b9fad10";
        httpHeaders.set("Authorization","bearer "+ token);
        HttpEntity<Video> request= new HttpEntity<>(null,httpHeaders);
        ResponseEntity<Video> response= restTemplate.exchange(uri, HttpMethod.GET,request, Video.class);
        return response.getBody();
    }
}
