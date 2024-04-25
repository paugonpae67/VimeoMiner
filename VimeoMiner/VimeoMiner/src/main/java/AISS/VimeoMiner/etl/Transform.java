package AISS.VimeoMiner.etl;

import AISS.VimeoMiner.model.videominer.*;
import AISS.VimeoMiner.service.CaptionService;
import AISS.VimeoMiner.service.CommentService;
import AISS.VimeoMiner.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;

public class Transform {
    @Autowired
    CaptionService captionService;
    @Autowired
    VideoService videoService;

    public Channel transformChannel(AISS.VimeoMiner.model.vimeo.channel.Channel channelVimeo){
        String id= channelVimeo.getId();
        String name=channelVimeo.getName();
        String description=channelVimeo.getDescription();
        String createdTime= channelVimeo.getCreatedTime();
        Channel res= new Channel(id,name,description,createdTime);
        List<Video> videos= videoService.getVideos(channelVimeo.getId()).stream().map(Transform::transformVideo).toList();
        res.setVideos(videos);
        return res;
    }



    public Video transformVideo(AISS.VimeoMiner.model.vimeo.video.Video videoVimeo){
        String id=videoVimeo.getId();
        String nombre=videoVimeo.getName();
        String descripcion= videoVimeo.getDescription();
        String fechaPubli= videoVimeo.getReleaseTime();
        List<Comment> comentarios=CommentService.getVideoComments(videoVimeo.getId()).stream().map(Transform::transformComment).toList();
        List<Caption> captions= captionService.getVideoCaptions(videoVimeo.getId()).stream().map(Transform::transformCaption).toList();
        Video res= new Video(id,nombre,descripcion,fechaPubli);
        res.setComments(comentarios);
        res.setCaptions(captions);
        return res;
    }

    public static Comment transformComment(AISS.VimeoMiner.model.vimeo.comment.Comment commentVimeo){
        String id= commentVimeo.getId();
        String text= commentVimeo.getText();
        String date= commentVimeo.getCreatedOn();
        User author= transformUser(commentVimeo.getUser());
        return new Comment(id,text,date,author);

    }

    public static User transformUser(AISS.VimeoMiner.model.vimeo.comment.User usuarioVimeo){
        Long id= usuarioVimeo.getId();
        String name= usuarioVimeo.getName();
        String userLink= usuarioVimeo.getLink();
        String pictureLink= usuarioVimeo.getPictures().getLink();

        return new User(id,name,userLink,pictureLink);
    }

    public static Caption transformCaption(AISS.VimeoMiner.model.vimeo.caption.Caption captionVimeo){
        String id=captionVimeo.getId().toString();
        String name=captionVimeo.getName();
        String language= captionVimeo.getLanguage();
        return new Caption(id,name,language);
    }
}
