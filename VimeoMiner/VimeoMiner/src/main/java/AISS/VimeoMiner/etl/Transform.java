package AISS.VimeoMiner.etl;

import AISS.VimeoMiner.model.videominer.Caption;
import AISS.VimeoMiner.model.videominer.Comment;
import AISS.VimeoMiner.model.videominer.Video;
import AISS.VimeoMiner.model.videominer.User;

import java.util.LinkedList;
import java.util.List;

public class Transform {
    //Necesito un Transform para el Channel!!!!
    public static Video transformVideo(AISS.VimeoMiner.model.vimeo.video.Video videoVimeo){
        String id=videoVimeo.getId();
        String nombre=videoVimeo.getName();
        String descripcion= videoVimeo.getDescription();
        String fechaPubli= videoVimeo.getReleaseTime();
        List<Comment> comentarios= new LinkedList<>();
        List<Caption> captions=new LinkedList<>();
        Video res= new Video(id,nombre,descripcion,fechaPubli);
        res.setComments(comentarios);
        res.setCaptions(captions);
        return res;
    }

    public static Comment tranformComment(AISS.VimeoMiner.model.vimeo.comment.Comment commentVimeo){
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
}
