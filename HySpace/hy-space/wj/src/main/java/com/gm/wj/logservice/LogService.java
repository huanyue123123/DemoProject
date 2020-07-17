package com.gm.wj.logservice;

import com.gm.wj.annotations.Log;
import com.gm.wj.enums.MethodLogType;
import com.gm.wj.result.Result;
import com.gm.wj.utils.IpUtil;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import eu.bitwalker.useragentutils.Version;
import io.lettuce.core.ScriptOutputType;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Aspect
public class LogService {


    @Pointcut("@annotation(com.gm.wj.annotations.Log)")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void around(JoinPoint point) throws Throwable{
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        Browser browser = userAgent.getBrowser();
        System.out.println("浏览器:" + browser.getName());
        Version browserVersion = userAgent.getBrowserVersion();
        System.out.println("浏览器版本:" + browserVersion);
        OperatingSystem system = userAgent.getOperatingSystem();
        System.out.println("操作系统:" + system);
        String ip = IpUtil.getIpAddr(request);
        System.out.println("IP:" + ip);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String operTime = sdf.format(new Date());
        System.out.println("操作时间:" + operTime);
        String methodName = point.getSignature().getName();
        System.out.println("方法名" + methodName);
        String className = point.getTarget().getClass().getName();
        System.out.println(className);
        String packages = point.getThis().getClass().getName();
        if (packages.indexOf("$$EnhancerByCGLIB$$") > -1) { // 如果是CGLIB动态生成的类
            try {
                packages = packages.substring(0, packages.indexOf("$$"));
                System.out.println(packages);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * 方法异常时调用
     *
     * @param ex
     */
    public void afterThrowing(Exception ex) {
        System.out.println("afterThrowing");
        System.out.println(ex);
    }

    /**
     * 获取方法中的中文备注
     *
     * @param joinPoint
     * @return
     * @throws Exception
     */
    public static String getMthodRemark(ProceedingJoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] method = targetClass.getMethods();
        String methode = "";
        for (Method m : method) {
            if (m.getName().equals(methodName)) {
                Class[] tmpCs = m.getParameterTypes();
                if (tmpCs.length == arguments.length) {
                    Log methodCache = m.getAnnotation(Log.class);
                    if (methodCache != null) {
                        methode = methodCache.content();
                    }
                    break;
                }
            }
        }
        return methode;
    }

    /**
     * 获取方法中的中文备注
     *
     * @param joinPoint
     * @return
     * @throws Exception
     */
    public static String getMthodOperType(ProceedingJoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] method = targetClass.getMethods();
        MethodLogType methode = null;
        String type="";
        for (Method m : method) {
            if (m.getName().equals(methodName)) {
                Class[] tmpCs = m.getParameterTypes();
                if (tmpCs.length == arguments.length) {
                    Log methodCache = m.getAnnotation(Log.class);
                    if (methodCache != null) {
                        methode = methodCache.operType();
                    }
                    break;
                }
            }
        }
        return methode.toString();
    }
}
