package thirdparty.renren.renrenAPIv2;

/**
 * Created with IntelliJ IDEA.
 * User: srp
 * Date: 13-9-3
 * Time: 下午6:43
 * To change this template use File | Settings | File Templates.
 */
public class InvalidRequestException extends RennServerException {

    private static final long serialVersionUID = 3341653614035548951L;

    public InvalidRequestException(String subErrorCode) {
        super(ErrorType.invalid_request.toString(), subErrorCode);
    }

    @Override
    public String getErrorType() {
        return ErrorType.invalid_request.toString();
    }

    @Override
    public int getHttpErrorCode() {
        return ErrorType.invalid_request.getHttpErrorCode();
    }

}
