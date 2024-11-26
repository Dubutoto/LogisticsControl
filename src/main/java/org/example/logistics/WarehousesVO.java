package org.example.logistics;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString

public class WarehousesVO {
    private int warehouseId;
    private String name;
    private String location;
    private int capacity;
}
