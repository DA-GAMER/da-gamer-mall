package com.dagamer.mall.common.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class BaseDomain implements Serializable {

    public final static long serialVersionUID = 1L;

    private String id;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    /**
     * 插入新数据
     */
    public void insertNewDomain() {
        this.id = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        LocalDateTime date = LocalDateTime.now();
        this.createTime = date;
        this.updateTime = date;
    }

}
