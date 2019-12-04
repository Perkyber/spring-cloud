package com.multi.consumer.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author by multi.xp
 * @version V1.0
 * @date 2019/12/2 9:27
 * @description:
 */
@Data
public class User {

    private Long id;

    private String userName; // 用户名

    private String password; // 密码

    private String name;// 姓名

    private Integer age;// 年龄

    private Integer sex;// 性别，1男性，2女性

    private Date birthday;// 出生日期

    private Date created;// 创建时间

    private Date updated;// 更新时间

    private String note;// 备注
}
