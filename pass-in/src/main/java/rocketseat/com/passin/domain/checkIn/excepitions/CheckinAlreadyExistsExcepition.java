package rocketseat.com.passin.domain.checkIn.excepitions;

public class CheckinAlreadyExistsExcepition extends RuntimeException {
    public CheckinAlreadyExistsExcepition(String message){
        super(message);
    }
}
