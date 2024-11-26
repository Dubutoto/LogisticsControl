package org.example.logistics;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString

public class Warehouse_InventoryVO {
    private int inventoryId;
    private int warehouseId;
    private int productId;
    private int quantity;
    private String lastUpdated;
}
