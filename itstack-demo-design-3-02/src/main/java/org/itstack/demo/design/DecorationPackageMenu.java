package org.itstack.demo.design;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 装修包菜单，实现IMenu
 */
public class DecorationPackageMenu implements IMenu {

    private List<Matter> list = new ArrayList<>();  // 装修清单
    private BigDecimal price = BigDecimal.ZERO;      // 装修价格

    private BigDecimal area;  // 面积
    private String grade;     // 装修等级；豪华欧式、轻奢田园、现代简约

    /**
     * 不让别人随意构建空菜单
     */
    private DecorationPackageMenu() {
    }

    /**
     * 构造器
     * @param area 装修面积
     * @param grade 装修等级
     */
    public DecorationPackageMenu(Double area, String grade) {
        this.area = BigDecimal.valueOf(area);
        this.grade = grade;
    }

    @Override
    public IMenu appendCeiling(Matter matter) {
        list.add(matter);
        price = price.add(area.multiply(new BigDecimal("0.2")).multiply(matter.price()));
        return this;
    }

    @Override
    public IMenu appendCoat(Matter matter) {
        list.add(matter);
        price = price.add(area.multiply(new BigDecimal("0.5")).multiply(matter.price()));
        return this;
    }

    @Override
    public IMenu appendFloor(Matter matter) {
        list.add(matter);
        price = price.add(area.multiply(matter.price()));
        return this;
    }

    @Override
    public IMenu appendTile(Matter matter) {
        // 添加地砖,地砖贵一点
        list.add(matter);
        price = price.add(area.multiply(matter.price()).multiply(new BigDecimal("1.2")));
        return this;
    }

    @Override
    public String getDetail() {

        StringBuilder detail = new StringBuilder("\r\n-------------------------------------------------------\r\n" +
                "装修清单" + "\r\n" +
                "套餐等级：" + grade + "\r\n" +
                "套餐价格：" + price.setScale(2, BigDecimal.ROUND_HALF_UP) + " 元\r\n" +
                "房屋面积：" + area.doubleValue() + " 平米\r\n" +
                "材料清单：\r\n");

        for (Matter matter: list) {
            detail.append(matter.scene()).append("：").append(matter.brand()).append("、").append(matter.model()).append("、平米价格：").append(matter.price()).append(" 元。\n");
        }

        return detail.toString();
    }

}
