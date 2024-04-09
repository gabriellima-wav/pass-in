package rocketseat.com.passin.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import rocketseat.com.passin.domain.attendee.exceptions.AtteendeeAlreadyExistExcepition;
import rocketseat.com.passin.domain.checkIn.excepitions.CheckinAlreadyExistsExcepition;
import rocketseat.com.passin.domain.event.exceptions.EventFullException;
import rocketseat.com.passin.domain.event.exceptions.EventNotFoundException;
import rocketseat.com.passin.dto.general.ErrorReponseDTO;

@ControllerAdvice
public class ExceptionEntityHandler {

    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity handleEventNotFound(EventNotFoundException exception){
        return ResponseEntity.notFound().build();
    }


    @ExceptionHandler(EventFullException.class)
    public ResponseEntity<ErrorReponseDTO> handlEventFull(EventFullException exception){
        return ResponseEntity.badRequest().body(new ErrorReponseDTO(exception.getMessage()));
    }

    @ExceptionHandler(AtteendeeAlreadyExistExcepition.class)
    public ResponseEntity handleAttendeeAlreadyExist(AtteendeeAlreadyExistExcepition exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @ExceptionHandler(CheckinAlreadyExistsExcepition.class)
    public ResponseEntity handleCheckinAlreadyExists(CheckinAlreadyExistsExcepition exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
}
