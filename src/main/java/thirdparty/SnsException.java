package thirdparty;

/**
 * Created with IntelliJ IDEA.
 * User: srp
 * Date: 13-9-24
 * Time: 下午6:08
 * To change this template use File | Settings | File Templates.
 */
public class SnsException extends Exception{
    private static final long serialVersionUID = 6313546634322117672L;
    private String message;
    private Throwable cause;

    public SnsException(String message){
        this.message = message;
    }

    public SnsException(String message, Throwable cause){
        this(message);
        this.cause = cause;
    }

    public Throwable getCause() {
        return cause;
    }

    public void setCause(Throwable cause) {
        this.cause = cause;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
