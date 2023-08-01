package py.com.daas.adamspayintegration.entities;

import java.io.Serializable;
import java.util.Date;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NaturalId;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@DynamicUpdate
public class ProductCategory implements Serializable {
    @Id
    @GeneratedValue
    private Integer categoryId;

    private String categoryName;

    //@NaturalId
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;


    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}
