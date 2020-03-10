package com.dagamer.mall.seckill.model.domain;

import com.dagamer.mall.common.domain.BaseDomain;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author DaGamer
 * @since 2020-03-06
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SodSeckill对象", description="")
public class SodSeckill extends BaseDomain {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "商品ID")
    private String productId;

    @ApiModelProperty(value = "产品名称")
    private String productName;

    @ApiModelProperty(value = "商品库存")
    private String number;

    @ApiModelProperty(value = "秒杀开始时间")
    private LocalDateTime startTime;

    @ApiModelProperty(value = "秒杀结束时间")
    private LocalDateTime overTime;


}
