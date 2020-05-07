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

### book

| Field | Type | Length | Note |
| ----- | ---- | ------ | ---- |
| id    | unsigned int  | 4      | primary key |
| asset_id | char | 32 | key in ibook |
| title | varchar | 50 |  |
| author | varchar | 20 |  |
| file_link | varchar | 255 |  |

```sql
CREATE TABLE `ebook_book` (
`id` INT ( 4 ) UNSIGNED NOT NULL AUTO_INCREMENT,
`asset_id` CHAR ( 32 ) NULL,
`title` VARCHAR ( 50 ) NULL,
`author` VARCHAR ( 20 ) NULL,
`cover_link` varchar(255) NULL,
`file_link` VARCHAR ( 255 ) NULL,
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
