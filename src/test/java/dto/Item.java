package dto;

import lombok.Builder;

@Builder
public class Item {
    private final String title;
    private final Double price;
    private final Double salePrice;

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }

    public Double getSalePrice() {
        return salePrice;
    }
}