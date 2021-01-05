package common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xiaohong
 * @version 1.0
 * @date 2021/1/4 14:43
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order {

    private String uuid;

    private String goodsId;

    private String goodsName;

    private BigDecimal goodsPrice;

    private Date createDate;

    private Date payDate;

    private OrderType type;

    private Integer status;

}
