package com.ceyentra.sm.dto.web.response;

import com.ceyentra.sm.enums.CommonStatus;
import com.ceyentra.sm.enums.TableBookingStatus;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class TableResDTO {

    Long id;
    String tableCode;
    Integer seatLimit;
    String category;
    Long restaurant;
    TableBookingStatus availability;
    CommonStatus status;
}
