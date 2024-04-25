package AISS.VimeoMiner.service;

import AISS.VimeoMiner.model.videominer.Caption;
import AISS.VimeoMiner.model.vimeo.video.Video;
import AISS.VimeoMiner.model.vimeo.video.Videos;
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
public class VideoService {
    @Autowired
    static RestTemplate restTemplate; //Esto es static????
    public Video getVideo(String id){
        String uri= "https://api.vimeo.com/videos/"+ id;
        HttpHeaders httpHeaders= new HttpHeaders();
        String token= "25ea87773a8779c13f997ee68b9fad10";
        httpHeaders.set("Authorization","bearer "+ token);
        HttpEntity<Video> request= new HttpEntity<>(null,httpHeaders);
        ResponseEntity<Video> response= restTemplate.exchange(uri, HttpMethod.GET,request,Video.class);
        return response.getBody();
    }

    public static List<Video> getVideos(String channelId){
        String uri="https://api.vimeo.com/channels/"+channelId+"/videos";
        HttpHeaders httpHeaders= new HttpHeaders();
        String token= "25ea87773a8779c13f997ee68b9fad10";
        httpHeaders.set("Authorization","bearer "+ token);
        HttpEntity<Videos> request= new HttpEntity<>(null,httpHeaders);
        ResponseEntity<Videos> response= restTemplate.exchange(uri, HttpMethod.GET,request,Videos.class);
        if(response.hasBody()){
            return response.getBody().getData();
        }else{
            return new LinkedList<>();
        }


    }

}
