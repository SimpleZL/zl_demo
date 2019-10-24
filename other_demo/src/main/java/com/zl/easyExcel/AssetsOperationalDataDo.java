package com.zl.easyExcel;

import java.util.Date;

/**
 * 经营数据实体类
 *
 * @author liangzhang212928
 */
public class AssetsOperationalDataDo {
    private static final long serialVersionUID = 1L;
    private String id;
    private String totalRoom;
    private String daysTotal;
    private int availableRoom;
    private int occupiedRoom;
    private double occupancy;
    /**
     * 平均房价 +$
     */
    private String averageRate;
    /**
     * 每间可出租房收入
     */
    private double revPAR;
    /**
     * 客房收入
     */
    private String  roomsRevenue;
    /**
     * 餐饮收入
      */
    private String  fbRevenue;
    /**
     * 小型营业部收入
     */
    private String otherOperatedDepartments;
    /**
     * 杂项收入
     */
    private String miscellenousIncome;
    /**
     * 总收入
     */
    private String totalRevenue;

    /**
     * 客房部收益
     */
    private String roomProfits;
    /**
     * 餐饮部收益
     */
    private String foodBeverage;
    /**
     * 小型营业部门收益
     */
    private String otherOperatedDepartmentsProfit;
    /**
     * 杂项收益
     */
    private String miscellaneousIncomeProfit;
    /**
     * 总营业收益
     */
    private String totalDepartmentalProfit;
    /**
     * 信用卡使用费用
     */
    private String creditCardCommssions;
    /**
     * 其他费用
     */
    private String AGOthers;
    /**
     * 行政管理以及公共费用
     */
    private String adminGeneral;
    /**
     * 信息和通信费用
     */
    private String infoTelecom;
    /**
     * 市场推广费用
     */
    private String salesMarketing;
    /**
     * 其他费用
     */
    private String other;
    /**
     * 免费项目
     */
    private String programFee;
    /**
     * 总统套房
     */
    private String royaltyRooms;
    /**
     * 总统套房餐饮费用
     */
    private String royatlyFoodBeverage;
    /**
     * 普通游客费用
     */
    private String frequentGuestExpense;
    /**
     * 相关费用
     */
    private String franchiseRelatedExpenseSubtotal;
    /**
     * 维护费用
     */
    private String propMaintenance;
    /**
     * 能源
     */
    private String utilities;
    /**
     * 未分配经营的总费用
     */
    private String totalUndistributedExpenses;
    /**
     * 管理费用
     */
    private String managementFess;
    /**
     * 基本管理费
     */
    private String baseManagementsFees;
    /**
     * 激励管理费
     */
    private String incentiveManagementFee;
    /**
     * 总管理费
     */
    private String  totalManagermentFee;
    /**
     * 收入
     */
    private String income;
    /**
     * 房地产税
     */
    private String  propertyAndOtherTaxes;
    /**
     * 保险费用
     */
    private String insurance;
    /**
     * 租金
     */
    private String rentLeases;
    /**
     * 其他
     */
    private String others;
    /**
     * 总固定费用
     */
    private String totalNonOperatingIncomeExpenses;
    private int gop;
    private double gopMargin;
    private int noi;
    private double noiMargin;
    private int type;
    private int year;
    private int month;
    private Date createTime;
    private Date modifyTime;
    private String propertyName;
    private String messageName;
}
