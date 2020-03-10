package com.dagamer.mall.user.model.domain;

import java.math.BigDecimal;
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
 * @since 2020-03-05
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="UacUser对象", description="")
public class UacUser extends BaseDomain {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "用户名称")
    private String name;

    @ApiModelProperty(value = "登录名")
    private String loginName;

    @ApiModelProperty(value = "登录密码")
    private String loginPwd;

    @ApiModelProperty(value = "用户余额")
    private BigDecimal balance;

    @ApiModelProperty(value = "最近登录时间")
    private LocalDateTime loginLastTime;


}
