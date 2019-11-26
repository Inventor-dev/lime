package xyz.lemone.lime.datasource.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import xyz.lemone.lime.datasource.annotation.Master;
import xyz.lemone.lime.datasource.annotation.Slave;
import xyz.lemone.lime.datasource.jdbc.DatasourceContextHolder;
import xyz.lemone.lime.datasource.jdbc.DatasourceTypeEnum;

@Aspect
public class MasterSlaveAspect implements Ordered {

    public static final Logger logger = LoggerFactory.getLogger(MasterSlaveAspect.class);

    /**
     * 切换到master库
     *
     * @param proceedingJoinPoint
     * @param master
     * @return
     * @throws Throwable
     */
    @Around("@annotation(master)")
    public Object proceed(ProceedingJoinPoint proceedingJoinPoint, Master master) throws Throwable {
        try {
            logger.info("set database connection to master only");
            DatasourceContextHolder.setDatasourceType(DatasourceTypeEnum.MASTER);
            Object result = proceedingJoinPoint.proceed();
            return result;
        } finally {
            DatasourceContextHolder.clearDatasourceType();
            logger.info("restore database connection");
        }
    }


    /**
     * 切换到product从库
     *
     * @param proceedingJoinPoint
     * @param slave
     * @return
     * @throws Throwable
     */
    @Around("@annotation(slave)")
    public Object proceed(ProceedingJoinPoint proceedingJoinPoint, Slave slave) throws Throwable {
        try {
            logger.info("set database connection to slave only");
            DatasourceContextHolder.setDatasourceType(DatasourceTypeEnum.SLAVE);
            Object result = proceedingJoinPoint.proceed();
            return result;
        } finally {
            DatasourceContextHolder.clearDatasourceType();
            logger.info("restore database connection");
        }
    }


    public int getOrder() {
        return 0;
    }
}