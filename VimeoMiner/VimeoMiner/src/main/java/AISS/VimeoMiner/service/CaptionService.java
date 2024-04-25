package AISS.VimeoMiner.service;

import AISS.VimeoMiner.model.vimeo.caption.Caption;
import AISS.VimeoMiner.model.vimeo.caption.Captions;
import AISS.VimeoMiner.model.vimeo.channel.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;
import java.util.List;


@Service
public class CaptionService {
    @Autowired
    RestTemplate restTemplate;
    public AISS.VimeoMiner.model.vimeo.caption.Caption getCaption(String videoId, String id){
        String uri= "https://api.vimeo.com/videos/"+ videoId+"/texttracks/"+ id;
        HttpHeaders httpHeaders= new HttpHeaders();
        String token= "25ea87773a8779c13f997ee68b9fad10";
        httpHeaders.set("Authorization","bearer "+ token);
        HttpEntity<AISS.VimeoMiner.model.vimeo.caption.Caption> request= new HttpEntity<>(null,httpHeaders);
        ResponseEntity<Caption> response= restTemplate.exchange(uri, HttpMethod.GET,request, AISS.VimeoMiner.model.vimeo.caption.Caption.class);
        return response.getBody();
    }

    public List<Caption> getVideoCaptions(String videoId){
        String uri= "https://api.vimeo.com/videos/"+ videoId+"/texttracks/";
        HttpHeaders httpHeaders= new HttpHeaders();
        String token= "25ea87773a8779c13f997ee68b9fad10";
        httpHeaders.set("Authorization","bearer "+ token);
        HttpEntity<Captions> request= new HttpEntity<>(null,httpHeaders);
        ResponseEntity<Captions> response= restTemplate.exchange(uri, HttpMethod.GET,request, Captions.class);
        if(response.hasBody()){
            return response.getBody().getData();
        }else{
            return new LinkedList<>();
        }



    }
}
