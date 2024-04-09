package rocketseat.com.passin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rocketseat.com.passin.domain.checkIn.CheckIn;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface CheckinRepository  extends JpaRepository <CheckIn, Integer> {
    Optional<CheckIn> findByAttendeeId(String AttendeeId);
}
