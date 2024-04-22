package AISS.VimeoMiner.etl;

import AISS.VimeoMiner.model.videominer.Video;

public class Transform {

    public static Video tranformVideo(AISS.VimeoMiner.model.vimeo.video.Video videoVimeo){
        String id=videoVimeo.getUri().repla;

        return new Video(id,nombre,descripcion,fechaPubli,comentarios,subtitulos);
    }
}
