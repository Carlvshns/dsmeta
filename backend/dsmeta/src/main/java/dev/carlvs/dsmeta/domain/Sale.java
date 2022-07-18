package dev.carlvs.dsmeta.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "tb_sales")
public class Sale {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Sale ID", example = "1", required = true)
    private Long id;
    @Column(name = "seller_name")
    @NotNull(message = "The field 'sellerName' is mandatory")
    @ApiModelProperty(notes = "Selle Name", example = "Barry Allen", required = true)
    private String sellerName;
    @NotNull(message = "The field 'visited' is mandatory")
    @ApiModelProperty(notes = "Number of visits", example = "121", required = true)
    private Integer visited;
    @NotNull(message = "The field 'deals' is mandatory")
    @ApiModelProperty(notes = "Number of solds", example = "67", required = true)
    private Integer deals;
    @NotNull(message = "The field 'amount' is mandatory")
    @ApiModelProperty(notes = "Total raised", example = "18196.0", required = true)
    private Double amount;
    @NotNull(message = "The field 'date' is mandatory")
    @ApiModelProperty(notes = "Date sold", example = "2022-06-16", required = true)
    private LocalDate date;

    public Sale(Long id, String sellerName, Integer visited, Integer deals, Double amount, LocalDate date) {
        this.id = id;
        this.sellerName = sellerName;
        this.visited = visited;
        this.deals = deals;
        this.amount = amount;
        this.date = date;
    }
  
    public Sale() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getSellerName() {
        return sellerName;
    }
    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Integer getVisited() {
        return visited;
    }
    public void setVisited(Integer visited) {
        this.visited = visited;
    }

    public Integer getDeals() {
        return deals;
    }
    public void setDeals(Integer deals) {
        this.deals = deals;
    }

    public Double getAmount() {
        return amount;
    }
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

}
