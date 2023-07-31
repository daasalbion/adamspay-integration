package py.com.daas.adamspayintegration.exception;


import py.com.daas.adamspayintegration.enums.ResultEnum;

/**
 * Created By Zhu Lin on 3/10/2018.
 */
public class MyException extends RuntimeException {

    private Integer code;

    public MyException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public MyException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
