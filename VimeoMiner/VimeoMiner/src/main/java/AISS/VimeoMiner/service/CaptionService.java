package AISS.VimeoMiner.service;

import AISS.VimeoMiner.model.videominer.Caption;
import AISS.VimeoMiner.model.vimeo.channel.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CaptionService {
    @Autowired
    RestTemplate restTemplate;
    public Caption getCaption(String Videoid, String id){
        String uri= "https://api.vimeo.com/videos/"+ Videoid+"/texttracks/"+ id;
        HttpHeaders httpHeaders= new HttpHeaders();
        String token= "25ea87773a8779c13f997ee68b9fad10";
        httpHeaders.set("Authorization","bearer "+ token);
        HttpEntity<Caption> request= new HttpEntity<>(null,httpHeaders);
        ResponseEntity<Caption> response= restTemplate.exchange(uri, HttpMethod.GET,request, Caption.class);
        return response.getBody();
    }
}
