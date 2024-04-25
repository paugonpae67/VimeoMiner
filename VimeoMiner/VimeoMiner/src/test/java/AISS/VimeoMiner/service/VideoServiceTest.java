package AISS.VimeoMiner.service;

import AISS.VimeoMiner.model.vimeo.video.Video;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VideoServiceTest {
    @Autowired
    VideoService videoService;

    @Test
    @DisplayName("Get an specific video")
    void getVideo(){
        Video video= videoService.getVideo("715547149");
        System.out.println(video);
    }

    @Test
    @DisplayName("Get videos from a channel")
    void getVideos(){
        List<Video> videos= videoService.getVideos("staffpicks");
        System.out.println(videos);
    }

}