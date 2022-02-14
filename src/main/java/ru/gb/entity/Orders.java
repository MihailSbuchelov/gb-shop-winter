package ru.gb.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import ru.gb.api.common.enums.OrdersStatus;
import ru.gb.entity.common.InfoEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "orders")
@EntityListeners(AuditingEntityListener.class)
public class Orders extends InfoEntity {

    @Column(name = "address")
    private String address;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "phone")
    private String phone;

    @Column(name = "mail")
    private String mail;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private OrdersStatus status;

    @Column(name = "delivery_date")
    private LocalDateTime deliveryDate;


    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "product_orders",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "orders_id")
    )
    Set<Product> products;

    @Override
    public String toString() {
        return "Orders{" +
                "address='" + address + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phone='" + phone + '\'' +
                ", mail='" + mail + '\'' +
                ", status=" + status +
                ", deliveryDate=" + deliveryDate +
                '}';
    }

    @Builder
    public Orders(Long id, int version, String createdBy, LocalDateTime createdDate, String lastModifiedBy,
                  LocalDateTime lastModifiedDate, String address, String firstname, String lastname,
                  String phone, String mail, OrdersStatus status, LocalDateTime deliveryDate) {
        super(id, version, createdBy, createdDate, lastModifiedBy, lastModifiedDate);
        this.address = address;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.mail = mail;
        this.status = status;
        this.deliveryDate = deliveryDate;
    }
}