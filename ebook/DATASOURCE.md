<head>
    <link href="https://cdn.bootcdn.net/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
</head>

# 数据库
> [阿里巴巴Java开发手册（华山版）.pdf](https://github.com/alibaba/p3c/blob/master/%E9%98%BF%E9%87%8C%E5%B7%B4%E5%B7%B4Java%E5%BC%80%E5%8F%91%E6%89%8B%E5%86%8C%EF%BC%88%E5%8D%8E%E5%B1%B1%E7%89%88%EF%BC%89.pdf)

## 表

### common field

| Field | Type & Length | Note |
| ----- | ---------- | ---- |
| create_by | int(4) unsigned |  |
| create_time | datetime(0) |  |
| update_by | int(4) unsigned |  |
| update_time | datetime(0) |  |
| is_deleted | tinyint(1) unsigned | 1:true<br/>0:false |
| status | tinyint(3) unsigned |  |
| note | varchar(255) |  |

### book

| Field | Type & Length | Note |
| ----- | ---------- | ---- |
| id    | int(4) unsigned | primary key |
| asset_id | char(32) | key in ibook |
| title | varchar(50) |  |
| author | varchar(20) |  |
| file_link | varchar(255) |  |

```sql
CREATE TABLE `ebook_book` (
`id` INT ( 4 ) UNSIGNED NOT NULL AUTO_INCREMENT,
`asset_id` CHAR ( 32 ) NULL,
`title` VARCHAR ( 50 ) NULL,
`author` VARCHAR ( 20 ) NULL,
`cover_link` VARCHAR(255) NULL,
`file_link` VARCHAR ( 255 ) NULL,
`create_by` INT ( 4 ) UNSIGNED NULL,
`create_time` datetime ( 0 ) NULL DEFAULT CURRENT_TIMESTAMP,
`update_by` INT ( 4 ) UNSIGNED NULL,
`update_time` datetime ( 0 ) NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
`is_deleted` TINYINT ( 1 ) UNSIGNED NULL DEFAULT 0,
`status` TINYINT ( 3 ) UNSIGNED NULL,
`note` VARCHAR ( 255 ) NULL,
PRIMARY KEY ( `id` ) 
);
```

### quote

| Field | Type & Length | Note |
| ----- | ---------- | ---- |
| id    | int(16) unsigned | primary key |
| book_id | int(4) unsigned | book key |
| type | int(4) unsigned | 1:金句<br/>2:生僻字<br/>3:成语<br/>4:人名<br/>5:书名<br/>6:事件<br/>7:现象<br/>8:概念<br/> |
| selectedText | varchar(255) | 选中的文本 |
| representativeText | varchar(255) | 整句 |
| location | varchar(255) | 位置 |
| comment_id | int(16) unsigned | 评论 |
| color | int(4) unsigned | 1<span style="padding-left:2px;">:<span> <i class="fa fa-circle" style="color: #33D42D"></i><br/>2: <i class="fa fa-circle" style="color: #3CA3FF"></i><br/>3: <i class="fa fa-circle" style="color: #FECF0B"></i> |

```sql
CREATE TABLE `ebook_quote` (
`id` INT ( 16 ) UNSIGNED NOT NULL AUTO_INCREMENT,
`book_id` INT(4) UNSIGNED NULL,
`type` INT(4) UNSIGNED NULL,
`selected_text` VARCHAR(255) NULL,
`representative_text` VARCHAR(255) NULL,
`location` VARCHAR(255) NULL,
`comment_id` INT(16) UNSIGNED NULL,
`color` INT(4) UNSIGNED NULL,
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

### comment

| Field | Type & Length | Note |
| ----- | ---------- | ---- |
| id    | int(16) unsigned | primary key |
| comment | blog | 评论 |

```sql
CREATE TABLE `ebook_comment` (
`id` INT ( 16 ) UNSIGNED NOT NULL AUTO_INCREMENT,
`comment` TEXT NULL,
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
