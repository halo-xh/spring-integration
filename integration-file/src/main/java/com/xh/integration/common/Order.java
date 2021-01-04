package com.xh.integration.common;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/4 14:05
 *
 */
public class Order implements Serializable {


    private String uuid;

    private Integer price;

    private String type;

    private String status;

    private Date createDate;


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
