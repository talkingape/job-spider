package com.wtmcb.spider.core.job51;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by WangGang on 2019-03-30.
 * Email: wanggang1@vipkid.com.cn
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Job51Entity {

    private String address;

    private String body;

    private String companyName;

    private String positionId;

    private String positionName;

    private String salary;

    private String workYear;

    private String educational;

    private String postDate;

    private Date createTime;
}
