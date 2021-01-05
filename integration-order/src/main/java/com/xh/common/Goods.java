package com.xh.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/4 14:51
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Goods implements Serializable {

    private String uuid;

    private String goodsName;

    private BigDecimal price;

    private Date createDate;

    private Date effDate;
}
