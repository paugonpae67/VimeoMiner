package AISS.VimeoMiner.controller;


import AISS.VimeoMiner.model.videominer.Caption;
import AISS.VimeoMiner.model.videominer.Channel;
import AISS.VimeoMiner.model.videominer.Comment;
import AISS.VimeoMiner.model.vimeo.video.Video;
import AISS.VimeoMiner.service.CaptionService;
import AISS.VimeoMiner.service.ChannelService;
import AISS.VimeoMiner.service.CommentService;
import AISS.VimeoMiner.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import AISS.VimeoMiner.etl.Transform;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api/channel") //Cual es la uri que hay que usar?????
public class ChannelController {
    //private final ChannelRepository repository;

    //public ChannelController(ChannelRepository repository){ this.repository= repository; }
    @Autowired
    ChannelService channelService;
    @Autowired
    VideoService videoService;
    @Autowired
    CommentService commentService;
    @Autowired
    CaptionService captionService;



    @GetMapping("/{id}")
    public Channel findChannel(@PathVariable String id){
        AISS.VimeoMiner.model.vimeo.channel.Channel channelVimeo=channelService.getChannel(id);
        Channel channel=Transform.transformChannel(channelVimeo);
        List<AISS.VimeoMiner.model.vimeo.video.Video> videosVimeo= videoService.getVideos(channelVimeo.getId());
        List<AISS.VimeoMiner.model.videominer.Video> videos=new LinkedList<>();
        for(Video videoVimeo:videosVimeo){
            AISS.VimeoMiner.model.videominer.Video video= Transform.transformVideo(videoVimeo);
            //List<Comment> comentarios= commentService.getVideoComments(videoVimeo.getId()).stream().map(Transform::transformComment).toList();
            //video.setComments(comentarios);
            //List<Caption> captions= captionService.getVideoCaptions(videoVimeo.getId()).stream().map(Transform::transformCaption).toList();
            //video.setCaptions(captions);
            videos.add(video);
        }
        channel.setVideos(videos);
        return channel;
    }

    @PostMapping("/{id}")
    public void postChannel(@PathVariable String id){
        Channel channel= findChannel(id);

    }
}
