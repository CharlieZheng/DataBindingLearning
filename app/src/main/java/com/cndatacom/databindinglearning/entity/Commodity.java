package com.cndatacom.databindinglearning.entity;

/**
 * Created by Charlie on 2016/8/5.
 */
public class Commodity {
    private String mediaPath;
    private String prodName;
    private double maxSalePrice;
    private String description;

    public String getMediaPath() {
        return mediaPath;
    }

    public void setMediaPath(String mediaPath) {
        this.mediaPath = mediaPath;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public double getMaxSalePrice() {
        return maxSalePrice;
    }

    public void setMaxSalePrice(double maxSalePrice) {
        this.maxSalePrice = maxSalePrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
