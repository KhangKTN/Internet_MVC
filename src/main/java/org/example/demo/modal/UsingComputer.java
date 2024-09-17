package org.example.demo.modal;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter @Setter
public class UsingComputer extends AbstractModel<UsingComputer>{
    Long customerId;
    Long computerId;
    String startDate;
    String startTime;
    int timeUsed;
}
