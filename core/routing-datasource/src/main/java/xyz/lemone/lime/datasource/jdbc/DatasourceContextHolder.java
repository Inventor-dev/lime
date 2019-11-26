package xyz.lemone.lime.datasource.jdbc;

/**
 * 数据源线程上下文
 */
public class DatasourceContextHolder {

    private static final ThreadLocal<DatasourceTypeEnum> CONTEXT_HOLDER = new ThreadLocal();

    public static void setDatasourceType(DatasourceTypeEnum dbType) {
        if (dbType == null) {
			throw new NullPointerException();
		}
		CONTEXT_HOLDER.set(dbType);
    }

    public static DatasourceTypeEnum getDatasourceType() {
		DatasourceTypeEnum datasourceType = CONTEXT_HOLDER.get();
		return datasourceType == null ? DatasourceTypeEnum.MASTER : datasourceType;
    }

    public static void clearDatasourceType() {
		CONTEXT_HOLDER.remove();
    }



}
