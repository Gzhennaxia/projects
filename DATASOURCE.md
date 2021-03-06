# 数据库
> [阿里巴巴Java开发手册（华山版）.pdf](https://github.com/alibaba/p3c/blob/master/%E9%98%BF%E9%87%8C%E5%B7%B4%E5%B7%B4Java%E5%BC%80%E5%8F%91%E6%89%8B%E5%86%8C%EF%BC%88%E5%8D%8E%E5%B1%B1%E7%89%88%EF%BC%89.pdf)

## 表

### common field

| Field | Type | Length | Note |
| ----- | ---- | ------ | ---- |
| create_by | int unsigned | 4 |  |
| create_time | datetime | 0 |  |
| update_by | int unsigned | 4 |  |
| update_time | datetime | 0 |  |
| is_deleted | tinyint unsigned | 1 | 1:true<br/>0:false |
| status | tinyint unsigned | 2 |  |
| note | varchar | 255 |  |

### user

| Field | Type | Length | Note |
| ----- | ---- | ------ | ---- |
| id    | int unsigned | 4      | primary key |
| username | varchar | 20 |  |
| password | char | 32 | 根据实际情况调整长度 |

```sql
CREATE TABLE `gzhennaxia`.`sys_user` (
`id` INT ( 4 ) UNSIGNED NOT NULL AUTO_INCREMENT,
`username` VARCHAR ( 20 ) NULL,
`password` CHAR ( 32 ) NULL,
`create_by` INT ( 4 ) UNSIGNED NULL,
`create_time` datetime ( 0 ) NULL DEFAULT CURRENT_TIMESTAMP,
`update_by` INT ( 4 ) UNSIGNED NULL,
`update_time` datetime ( 0 ) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
`is_deleted` TINYINT ( 1 ) UNSIGNED NULL DEFAULT 0,
`status` TINYINT ( 2 ) UNSIGNED NULL,
`note` VARCHAR ( 255 ) NULL,
PRIMARY KEY ( `id` ) 
);
```
