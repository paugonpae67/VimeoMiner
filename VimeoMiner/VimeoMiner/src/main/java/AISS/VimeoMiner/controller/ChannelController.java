package AISS.VimeoMiner.controller;


import AISS.VimeoMiner.exception.MaxCommentsException;
import AISS.VimeoMiner.exception.MaxVideosException;
import AISS.VimeoMiner.model.videominer.Caption;
import AISS.VimeoMiner.model.videominer.Channel;
import AISS.VimeoMiner.model.videominer.Comment;
import AISS.VimeoMiner.model.vimeo.video.Video;
import AISS.VimeoMiner.service.CaptionService;
import AISS.VimeoMiner.service.ChannelService;
import AISS.VimeoMiner.service.CommentService;
import AISS.VimeoMiner.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import AISS.VimeoMiner.etl.Transform;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api/channel") //Cual es la uri que hay que usar?????
public class ChannelController {
    @Autowired
    ChannelService channelService;
    @Autowired
    VideoService videoService;
    @Autowired
    CommentService commentService;
    @Autowired
    CaptionService captionService;
    @Autowired
    RestTemplate restTemplate;



    @GetMapping("/{id}")
    public Channel findChannel(@PathVariable String id, @RequestParam(required = false,defaultValue = "10") int maxVideos,
                               @RequestParam(required = false,defaultValue = "10") int maxComments ) throws MaxCommentsException, MaxVideosException {
        AISS.VimeoMiner.model.vimeo.channel.Channel channelVimeo = channelService.getChannel(id);
        Channel channel = Transform.transformChannel(channelVimeo);
        List<AISS.VimeoMiner.model.videominer.Video> videos = new LinkedList<>();
        List<AISS.VimeoMiner.model.vimeo.video.Video> videosVimeo = videoService.getVideos(channelVimeo.getId(), maxVideos);
        for (Video videoVimeo : videosVimeo) {
            AISS.VimeoMiner.model.videominer.Video video = Transform.transformVideo(videoVimeo);
            List<Comment> comentarios = commentService.getVideoComments(videoVimeo.getId(), maxComments).stream().map(Transform::transformComment).toList();
            video.setComments(comentarios);
            List<Caption> captions = captionService.getVideoCaptions(videoVimeo.getId()).stream().map(Transform::transformCaption).toList();
            video.setCaptions(captions);
            videos.add(video);
        }
        channel.setVideos(videos);
        return channel;
    }


    @PostMapping("/{id}")
    public Channel postChannel(@PathVariable String id, @RequestParam(required = false,defaultValue = "10") int maxVideos,
                               @RequestParam(required = false,defaultValue = "10") int maxComments ) throws MaxCommentsException, MaxVideosException {
        Channel channel= findChannel(id,maxVideos,maxComments);

        String uri= "http://localhost:8080/videominer/channels";
        HttpHeaders httpHeaders= new HttpHeaders();
        HttpEntity<Channel> request= new HttpEntity<>(channel,httpHeaders);
        ResponseEntity<Channel> response= restTemplate.exchange(uri, HttpMethod.POST,request, Channel.class);
        return response.getBody();


    }
}
