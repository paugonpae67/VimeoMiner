package AISS.VimeoMiner.service;

import AISS.VimeoMiner.model.vimeo.caption.Caption;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CaptionServiceTest {
    @Autowired
    CaptionService captionService;

    @Test
    @DisplayName("Get an specific caption")
    void getCaption(){
        Caption caption= captionService.getCaption("715547149","21101407");
        System.out.println(caption);
    }

}