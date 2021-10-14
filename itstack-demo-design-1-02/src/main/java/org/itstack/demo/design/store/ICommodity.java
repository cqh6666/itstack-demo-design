package org.itstack.demo.design.store;

import java.util.Map;

/**
 * 所有的奖品无论是实物还是优惠卷，都需要通过实现此接口进行处理，达到统一性
 */
public interface ICommodity {

    /**
     * 发送奖品的接口
     * @param uId 用户ID
     * @param commodityId 奖品ID
     * @param bizId 业务ID
     * @param extMap 拓展信息（比如用于处理发放实物商品时的收获地址）
     * @throws Exception
     */
    void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) throws Exception;

}
