package cn.axg.study.exception;


import cn.axg.common.api.CommonResult;
import cn.axg.common.exception.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Slf4j
@ControllerAdvice// Spring5版本以后可以用@RestControllerAdvice
public class GrobalHandlerExecption {


    /**
     * 处理所有不可知异常
     * @param e 异常
     * @return json结果
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public CommonResult handleException(Exception e) {
        log.info("全局异常--不可知的异常信息{}",e.getMessage());
        return CommonResult.failed(e.getMessage());
    }

    /**
     * 参数校验异常
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public CommonResult handleValidException(MethodArgumentNotValidException ex){
        log.error("参数校验异常：[{}]",ex.getMessage());
        log.error("参数绑定结果：[{}]",ex.getBindingResult());
        return validExceptionCommon(ex.getBindingResult());
    }

    /**
     * 处理所有业务异常
     *
     * @param e 业务异常
     * @return json结果
     */
    @ExceptionHandler(ApiException.class)
    @ResponseBody
    public CommonResult handleOpdRuntimeException(ApiException e) {
        if (e.getErrorCode() != null) {
            log.info("业务异常--异常信息{}",e.getMessage());
            return CommonResult.failed(e.getErrorCode());
        }
        log.info("业务异常--异常信息{}",e.getMessage());
        return CommonResult.failed(e.getMessage());
    }

    ///////////////////////////////////私有方法//////////////////////////////////////////

    private CommonResult validExceptionCommon(BindingResult result){
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            return CommonResult.failed(errors.get(0).getDefaultMessage());
        }
        return null;
    }

}
