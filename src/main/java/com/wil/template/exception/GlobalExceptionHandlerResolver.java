package com.wil.template.exception;

import com.wil.template.util.R;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/**
 * @Description 全局的的异常处理器
 * @Author wil
 * @Date 2020/08/10 11:51:40
 * @Version 1.0
 */
@Slf4j
@RestControllerAdvice
@AllArgsConstructor
public class GlobalExceptionHandlerResolver {

    /**
     * @Description 处理所有业务异常
     * @Author wwy
     * @Date 2019年06月30日 03:23:19
     * @param e
     * @Return
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    R handleBusinessException(BusinessException e) {
        if (log.isErrorEnabled()) {
            log.error(e.getStackTrace()[0].toString() + ": " + e.getMessage());
        }
        return R.failed(null, e.getMessage());
    }

    /**
     * validation Exception
     *
     * @param exception
     * @return R
     */
    @ExceptionHandler({MethodArgumentNotValidException.class, BindException.class})
    public R handleBodyValidException(MethodArgumentNotValidException exception) {
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        if (log.isErrorEnabled()) {
            log.error("参数绑定异常,ex = {}, {}", fieldErrors.get(0).getDefaultMessage(), exception.getStackTrace()[0].toString());
        }
        return R.failed(null, fieldErrors.get(0).getDefaultMessage());
    }

    /**
     * 全局异常.
     *
     * @param e the e
     * @return R
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public R handleGlobalException(Exception e) {
        if (log.isErrorEnabled()) {
            log.error("全局异常信息 ex={}", e.getMessage(), e);
        }
        return R.failed(null, e.getLocalizedMessage());
    }


}
