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
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name= "Youtube", description =  "Yputube management API")
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


    @Operation(
            summary = "Retrieve a Vimeo channel by Id",
            description= "Get a Vimeo channel by specifying its Id",
            tags = {"channel", "get"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Vimeo channel", content = {@Content(schema = @Schema(implementation = Channel.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())})
            })

    @GetMapping("/{id}")
    public Channel findChannel(@Parameter(description = "Id's name of the channel")@PathVariable String id,
                               @Parameter(description = "Optional parameter to limit the number of videos")@RequestParam(required = false,defaultValue = "10") int maxVideos,
                               @Parameter(description = "Optional parameter to limit the number of comments")@RequestParam(required = false,defaultValue = "10") int maxComments ) throws MaxCommentsException, MaxVideosException {
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

    @Operation(
            summary = "Insert a Channel in VideoMiner",
            description= "Add a new Vimeo channel (looked by its Id in Vimeo) whose data is passed in the body of the request in Json format",
            tags = {"channels", "post"})
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Vimeo channel", content = {@Content(schema = @Schema(implementation = Channel.class), mediaType = "application/json")}),
            @ApiResponse(responseCode = "404", content = {@Content(schema = @Schema())})
            })
    @PostMapping("/{id}")
    public Channel postChannel(@Parameter(description = "Id's name of the channel")@PathVariable String id,
                               @Parameter(description = "Optional parameter to limit the number of videos")@RequestParam(required = false,defaultValue = "10") int maxVideos,
                               @Parameter(description = "Optional parameter to limit the number of comments")@RequestParam(required = false,defaultValue = "10") int maxComments ) throws MaxCommentsException, MaxVideosException {
        Channel channel= findChannel(id,maxVideos,maxComments);

        String uri= "http://localhost:8080/videominer/channels";
        HttpHeaders httpHeaders= new HttpHeaders();
        HttpEntity<Channel> request= new HttpEntity<>(channel,httpHeaders);
        ResponseEntity<Channel> response= restTemplate.exchange(uri, HttpMethod.POST,request, Channel.class);
        return response.getBody();


    }
}
