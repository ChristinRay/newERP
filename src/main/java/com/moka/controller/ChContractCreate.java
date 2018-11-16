package com.moka.controller;

import java.util.Map;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moka.result.Result;
import com.moka.utils.ContractReq;
import com.moka.utils.ContractUtils;

/**
* @author    created by lbq
* @date	     2018年11月15日 下午3:18:08
**/

@RestController
@RequestMapping("/api/erp/v1/contract")
public class ChContractCreate {
	@Autowired
	private ContractUtils contractUtils;
	
	
	@PostMapping("create")
	public Result<?> contract(@RequestBody ContractReq contract){
		XWPFDocument  document= contractUtils.getContractTemplate();
		Map<String, Object> params= contractUtils.initContractParam(contract);
        document.getParagraphs().stream().filter(p -> contractUtils.matcher(p.getParagraphText()).find()).forEach(
                p -> {
                	contractUtils.replaceInParams(params, p, 0);
                    // System.out.println(p.getParagraphText());
                }
        );
        XWPFTable itemTable = document.getTableArray(0);
        contract.getItems().stream().forEach(
                item -> {
                    itemTable.createRow();
                }
        );
        contractUtils.replaceInTable(params, itemTable);
        contractUtils.writeContract(document);
		
		return Result.create("OK","成功");
	}
}
