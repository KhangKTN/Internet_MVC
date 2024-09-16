package org.example.demo.modal;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Customer extends AbstractModel<Customer> {
    Long id;
    String name;
    String address;
    String phone;
    String email;
}
