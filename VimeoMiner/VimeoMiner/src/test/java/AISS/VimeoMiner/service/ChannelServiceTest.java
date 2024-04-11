package AISS.VimeoMiner.service;

import AISS.VimeoMiner.model.vimeo.channel.Channel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ChannelServiceTest {

    @Autowired
    ChannelService channelService;

    @Test
    @DisplayName("Get an specific channel")
    void getChannel(){
        Channel channel =channelService.getChannel("comedy");
        System.out.println(channel);
    }

}