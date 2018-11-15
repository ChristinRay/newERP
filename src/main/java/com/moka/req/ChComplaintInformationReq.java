package com.moka.req;

import java.util.ArrayList;
import java.util.List;

import com.moka.model.BaseModel;
import com.moka.model.ChComplaintInformation;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ChComplaintInformationReq{
	//ChComplaintInformation数据列表，用于excel导入
	List<ChComplaintInformation> chinformaList = new ArrayList<>();
	private String mesgExcel;//excel错误信息存放
	
}
