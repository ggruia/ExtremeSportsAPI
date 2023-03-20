package RESTAPI.ExtremeSports.sport_resort.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class SportResortDTO {

    private Long id;

    @NonNull
    private Long sportId;

    @NonNull
    private Long resortId;

    @NonNull
    private Float cost;

    @NonNull
    private Date startDate;

    @NonNull
    private Date endDate;
}
