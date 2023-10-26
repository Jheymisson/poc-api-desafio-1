package br.com.test.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDTO {

    private String title;
    private String description;
    private String price;
    private String brand;
    private String category;
    private String thumbnail;
    private Float discountPercentage;
    private Float rating;
    private Integer stock;

}
