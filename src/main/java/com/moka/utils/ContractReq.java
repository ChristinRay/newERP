package com.moka.utils;

import java.util.List;

import lombok.Data;

/**
 * Created by ray on 2018/11/7.
 */
@Data
public class ContractReq {

    private String purBillsId;//采购订单编号

    private String companyName;//甲方公司

    private String supplyName;//供应商名称+账户名

    private String supplyAddress;//供应商地址

    private String contractItem;//？？？

    private String contractStr1;//质量验收标准？？？

    private String depotAddress;//仓库地址

    private String depotPerson;//仓库联系人

    private String depotPhone;//仓库联系人电话

    private String supplyAccountName;//开户行名称

    private String supplyAccount;//开户行账户

    private String agent;

    private List<ContractItemReq> items;

}
