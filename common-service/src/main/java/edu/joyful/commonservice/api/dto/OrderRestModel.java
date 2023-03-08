package edu.joyful.commonservice.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRestModel {

    private String productId;
    private String userId;
    private String addressId;
    private Integer quantity;
}
