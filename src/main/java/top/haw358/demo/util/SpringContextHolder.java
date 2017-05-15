package top.haw358.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContextHolder
        implements ApplicationContextAware, DisposableBean {
    private static ApplicationContext applicationContext = null;
    private static Logger logger = LoggerFactory.getLogger(SpringContextHolder.class);

    public void setApplicationContext(ApplicationContext paramApplicationContext) {
        logger.debug("注入ApplicationContext到SpringContextHolder:" + paramApplicationContext);
        if (applicationContext != null)
            logger.warn("SpringContextHolder中的ApplicationContext被覆盖, 原有ApplicationContext为:" + applicationContext);
        applicationContext = paramApplicationContext;
    }

    public void destroy()
            throws Exception {
        clear();
    }

    public static ApplicationContext getApplicationContext() {
        assertContextInjected();
        return applicationContext;
    }

    public static <T> T getBean(String paramString) {
        assertContextInjected();
        return (T) applicationContext.getBean(paramString);
    }

    public static <T> T getBean(Class<T> paramClass) {
        assertContextInjected();
        return applicationContext.getBean(paramClass);
    }

    public static void clear() {
        logger.debug("清除SpringContextHolder中的ApplicationContext:" + applicationContext);
        applicationContext = null;
    }

    private static void assertContextInjected() {
        if (applicationContext != null)
            return;
        throw new IllegalStateException("applicaitonContext未注入,请在applicationContext.xml中定义SpringContextHolder");
    }
}