package org.itstack.demo.design.pay.mode;

/**
 * 支付模式：人脸、指纹、密码
 */
public interface IPayMode {

    boolean security(String uId);

}
