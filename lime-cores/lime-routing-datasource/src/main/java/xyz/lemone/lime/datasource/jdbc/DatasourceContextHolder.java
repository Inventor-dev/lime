package xyz.lemone.lime.datasource.jdbc;

/**
 * 数据源线程上下文
 */
public class DatasourceContextHolder {

    private static final ThreadLocal<DatasourceTypeEnum> contextHolder = new ThreadLocal();

    public static void setDatasourceType(DatasourceTypeEnum dbType) {
        if (dbType == null) throw new NullPointerException();
        contextHolder.set(dbType);
    }

    public static DatasourceTypeEnum getDatasourceType() {
        return contextHolder.get() == null ? DatasourceTypeEnum.PRODUCT_MASTER : contextHolder.get();
    }

    public static void clearDatasourceType() {
        contextHolder.remove();
    }



}
