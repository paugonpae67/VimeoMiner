package AISS.VimeoMiner.etl;

import AISS.VimeoMiner.model.videominer.Caption;
import AISS.VimeoMiner.model.videominer.Comment;
import AISS.VimeoMiner.model.videominer.Video;

import java.util.LinkedList;
import java.util.List;

public class Transform {

    public static Video tranformVideo(AISS.VimeoMiner.model.vimeo.video.Video videoVimeo){
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

    }
}
