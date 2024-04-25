package AISS.VimeoMiner.service;

import AISS.VimeoMiner.model.vimeo.channel.Channel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChannelService {
    @Autowired
    RestTemplate restTemplate;

    public static Channel getChannel(String id){ //Esto es estático????
        String uri= "https://api.vimeo.com/channels/"+ id;
        HttpHeaders httpHeaders= new HttpHeaders();
        String token= "25ea87773a8779c13f997ee68b9fad10";
        httpHeaders.set("Authorization","bearer "+ token);
        HttpEntity<Channel> request= new HttpEntity<>(null,httpHeaders);
        ResponseEntity<Channel> response= restTemplate.exchange(uri, HttpMethod.GET,request, Channel.class);
        return response.getBody();
    }
}
