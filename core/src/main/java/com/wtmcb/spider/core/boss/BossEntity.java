package com.wtmcb.spider.core.boss;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by WangGang on 2019-03-30.
 * Email: wanggang1@vipkid.com.cn
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BossEntity {

    private String address;

    private String body;

    private String companyName;

    private String positionId;

    private String positionName;

    private String salary;

    private Integer workYear;

    private String educational;
}
