package org.itstack.demo.design;


/**
 * 1. 继承了处理接口
 * 2. 提供了构造函数
 * 3. 覆盖了方法
 *
 */
public abstract class SsoDecorator implements HandlerInterceptor {

    private HandlerInterceptor handlerInterceptor;

    private SsoDecorator(){}

    public SsoDecorator(HandlerInterceptor handlerInterceptor) {
        this.handlerInterceptor = handlerInterceptor;
    }

    @Override
    public boolean preHandle(String request, String response, Object handler) {
        System.out.println("SsoDecorator的prehandler方法");
        return handlerInterceptor.preHandle(request, response, handler);
    }

}
