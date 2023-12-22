package reservation.api.reservation.exceptions;

public class NotFoundIdException extends Exception{
    public NotFoundIdException(Long id, Class<?> type){
        super("cannot find id "+ id + "for " + type);
    }
}
