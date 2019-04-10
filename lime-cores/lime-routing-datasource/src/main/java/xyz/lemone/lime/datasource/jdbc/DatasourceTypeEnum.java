package xyz.lemone.lime.datasource.jdbc;

/**
 * 数据源类型枚举
 */
public enum DatasourceTypeEnum {

    /**
     * 主 写
     */
    PRODUCT_MASTER,
    /**
     * 主 读
     */
    PRODUCT_SLAVE,
    /**
     * 副 写
     */
    STUDY_MASTER,
    /**
     * 副 读
     */
    STUDY_SLAVE;

}
