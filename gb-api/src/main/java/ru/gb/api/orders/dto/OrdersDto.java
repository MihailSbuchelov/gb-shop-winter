package ru.gb.api.orders.dto;

import lombok.*;
import ru.gb.api.common.enums.OrdersStatus;
import ru.gb.api.product.dto.ProductDto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrdersDto implements Serializable {
    private Long id;
    private String address;
    @NotBlank
    private String firstname;
    @NotBlank
    private String lastname;
    @NotBlank
    private String phone;
    @Email
    private String mail;
    private OrdersStatus status;
    private String deliveryDate;
    @NotEmpty
    private Set<ProductDto> products;
    private LocalDateTime createDate;
    private LocalDateTime lastModifaerDate;
}
