package org.example.logistics;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class SuppliersVO {
    private int supplierId;
    private String supplierName;
    private String supplierContact;
    private String supplierLocation;
}
