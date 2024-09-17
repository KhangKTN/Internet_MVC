package org.example.demo.modal;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Service extends AbstractModel<Service> {
    Long id;
    String name;
    String unit;
    Integer price;
}
