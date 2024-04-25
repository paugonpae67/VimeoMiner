package AISS.VimeoMiner.controller;


import AISS.VimeoMiner.model.videominer.Channel;
import AISS.VimeoMiner.service.ChannelService;
import org.springframework.web.bind.annotation.*;
import AISS.VimeoMiner.etl.Transform;

@RestController
@RequestMapping("/api/channel") //Cual es la uri que hay que usar?????
public class ChannelController {
    //private final ChannelRepository repository;

    //public ChannelController(ChannelRepository repository){ this.repository= repository; }

    @GetMapping("/{id}")
    public Channel findChannel(@PathVariable String id){
        AISS.VimeoMiner.model.vimeo.channel.Channel channelVimeo=ChannelService.getChannel(id);
        Channel channel=Transform.transformChannel(channelVimeo);
        return channel;
    }

    @PostMapping("/{id}")
    public void postChannel(@PathVariable String id){
        Channel channel= findChannel(id);

    }
}
