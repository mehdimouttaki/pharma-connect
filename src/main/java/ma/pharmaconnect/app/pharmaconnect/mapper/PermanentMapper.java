package ma.pharmaconnect.app.pharmaconnect.mapper;

import lombok.extern.slf4j.Slf4j;
import ma.pharmaconnect.app.pharmaconnect.dto.permanent.PermanentCreationDTO;
import ma.pharmaconnect.app.pharmaconnect.model.Permanent;
import ma.pharmaconnect.app.pharmaconnect.model.PermanentType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class PermanentMapper {
    private PermanentMapper() {
        throw new IllegalStateException("Utility class");
    }


    public static Permanent map(PermanentCreationDTO permanentDTO) {
        Permanent permanent = new Permanent();
        // map String to PermanentType(enum)
        PermanentType permanentType = PermanentType.valueOf(permanentDTO.getType());
        permanent.setType(permanentType);
        // map rangeDate{startDate,endDate} String ---> 2 Dates (startDate, endDate)
        String rangeDate = permanentDTO.getRangeDate();
        String[] parts = rangeDate.split("-");
        if (parts.length == 2) {
            String part1 = parts[0];
            String part2 = parts[1];
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/ddd/yyyy H:mm");
            try {
                Date startDate = simpleDateFormat.parse(part1);
                Date endDate = simpleDateFormat.parse(part2);
                permanent.setStartDate(startDate);
                permanent.setEndDate(endDate);
            } catch (ParseException e) {
                log.error("Cannot parse Date {}", e.getMessage());
            }
        } else {
            log.error("the value {} is not a range", rangeDate);
        }


        return permanent;
    }
}
