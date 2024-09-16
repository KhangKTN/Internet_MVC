package org.example.demo.modal;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class AbstractModel<T> {
    private List<T> listResult = new ArrayList<>();
    private Integer page;
    private Integer maxPageItem;
    private Integer totalPage;
    private Integer totalItem;
    private String type;
}
