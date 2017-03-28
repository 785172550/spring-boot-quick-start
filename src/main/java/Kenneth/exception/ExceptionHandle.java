package Kenneth.exception;

import Kenneth.model.Post;
import Kenneth.model.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/3/28.
 *  global exception handle
 */

@ControllerAdvice
@ResponseBody
public class ExceptionHandle {

    private static Logger log = LoggerFactory.getLogger(ExceptionHandle.class);

    /**
     *  400 bad request parameter missed
     */
    @ExceptionHandler(Exception.class)
    public static Result handleMissingParamException(Exception e){
        return new Result.Builder<Exception>().setStatus(400).setMsg("bad request")
                .setContent(e).build();
    }

}
