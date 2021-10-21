package org.itstack.demo.design;

public interface HandlerInterceptor {

    /**
     * 拦截处理，模拟Spring的拦截处理
     * @param request 请求
     * @param response 响应
     * @param handler 处理
     * @return 能否通过
     */
    boolean preHandle(String request, String response, Object handler);

}
