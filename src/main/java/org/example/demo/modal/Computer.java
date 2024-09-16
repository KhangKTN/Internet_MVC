package org.example.demo.modal;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Computer extends AbstractModel<Computer> {
    Long id;
    String position;
    String status;
}
