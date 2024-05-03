package AISS.VimeoMiner.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code= HttpStatus.BAD_REQUEST, reason= "Max videos must be an integer greater or equal to 0")
public class MaxVideosException extends Exception {
}
