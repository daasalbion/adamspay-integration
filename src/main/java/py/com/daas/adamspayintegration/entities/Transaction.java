package py.com.daas.adamspayintegration.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
@DynamicUpdate
public class Transaction implements Serializable {
    private static final long serialVersionUID = -3819883511505234030L;

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private OrderMain order;

    @NotEmpty
    private String payStatus;

    @NotEmpty
    private String notifyStatus;

    @NotEmpty
    private String payUrl;

    @NotEmpty
    private String objStatus;

    // Total Amount
    @NotNull
    private BigDecimal orderAmount;

    @CreationTimestamp
    private LocalDateTime createTime;

    @UpdateTimestamp
    private LocalDateTime updateTime;

    public Transaction() {}
}
