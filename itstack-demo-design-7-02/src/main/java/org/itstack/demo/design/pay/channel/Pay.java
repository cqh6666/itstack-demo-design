package org.itstack.demo.design.pay.channel;

import org.itstack.demo.design.pay.mode.IPayMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * 支付方式：支付宝、微信
 */
public abstract class Pay {

    protected Logger logger = LoggerFactory.getLogger(Pay.class);

    /**
     * 通过构造方法注入支付模式
     */
    protected IPayMode payMode;
    public Pay(IPayMode payMode) {
        this.payMode = payMode;
    }

    public abstract String transfer(String uId, String tradeId, BigDecimal amount);

}
