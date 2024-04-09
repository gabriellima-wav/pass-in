package rocketseat.com.passin.services;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rocketseat.com.passin.domain.attendee.Attendee;
import rocketseat.com.passin.domain.checkIn.CheckIn;
import rocketseat.com.passin.domain.checkIn.excepitions.CheckinAlreadyExistsExcepition;
import rocketseat.com.passin.repositories.CheckinRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CheckInService {
    private final CheckinRepository checkinRepository;

    public void registerCheckIn(Attendee attendee){
        this.verifyCheckInExists(attendee.getId());
        CheckIn newChechIn = new CheckIn();
        newChechIn.setAttendee(attendee);
        newChechIn.setCreatedAt(LocalDateTime.now());
        this.checkinRepository.save(newChechIn);

    }
    private void verifyCheckInExists(String attendeeId){
        Optional<CheckIn> isCheckIn = this.getCheckIn(attendeeId);
        if(isCheckIn.isPresent()) throw new CheckinAlreadyExistsExcepition("Attendee already checked in");
    }

    public Optional<CheckIn> getCheckIn(String attendeeId){

        return this.checkinRepository.findByAttendeeId(attendeeId);
    }
}
