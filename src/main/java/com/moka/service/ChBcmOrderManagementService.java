package com.moka.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.shiro.util.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.moka.dao.ChBcmOrderManagementData;
import com.moka.model.ChBcmOrderManagement;
import com.moka.utils.BcmOrderManagementUtils;
import com.moka.utils.ListException;
import com.moka.utils.LoadProperties;
import com.moka.utils.ReadExcel;
/*
 * author created by hmm
 * createDate 2018/12/10 16:22:00
 */
@Service
@EnableAsync
public class ChBcmOrderManagementService {
	private Logger log = LoggerFactory.getLogger(ChBcmOrderManagementService.class);
	
	@Autowired
	private ChBcmOrderManagementData chBcmOrderManagementData;
	
	@Autowired
	private BcmOrderManagementUtils bcmOrderManagementUtils;
	

	public void add(String fileName, MultipartFile file, Map<String, Object> reqMap) throws ListException {
		//创建处理excel
		//ReadExcel readExcel = new ReadExcel();
		//String path = LoadProperties.propertiesMap.get("file_dir");
		//if(path==null) {
		//	path=fileName.substring(0,fileName.lastIndexOf("."));
		//}
		String path="C:\\Users\\82216\\java\\files\\erp\\";
		//解析excel，获取信息集合
		//List<Map<String,Object>> records = readExcel.getExcelOrderManagement(path,fileName,file,1);
		List<ChBcmOrderManagement> records = new ArrayList<>();
		try {
			records = bcmOrderManagementUtils.processOneSheet(path,fileName);
			log.info("-->excel records="+records);
			if(CollectionUtils.isEmpty(records)) {
				throw new ListException("list","导入列表为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

//		List<Map<String,Object>> list=parseOrderManagementMap(records,reqMap);
//		chBcmOrderManagementData.insertList(list);		
		chBcmOrderManagementData.insertList(records);	
	}
	
	
	public List<Map<String,Object>> parseOrderManagementMap(List<Map<String,Object>> records,Map<String,Object> reqMap){
		List<Map<String,Object>> insertList = new ArrayList<>();
		for(Map<String,Object> map:records) {
			Map<String,Object> insertMap = new HashMap<>();
			insertMap.put("userId", reqMap.get("userName"));
			Iterator it= map.entrySet().iterator();
			while(it.hasNext()) {
				Entry<String,String> entry =(Entry<String,String>)it.next();
				String key =entry.getKey();
				Object value=entry.getValue();
				if("key0".equals(key)) {
					value=value==null?"":value+"";
					insertMap.put("orderNumber",value); //订单编号
				}
				if("key1".equals(key)) {
					value=value==null?"":value+"";
					insertMap.put("orderTime",value); //订购时间
				}
				if("key2".equals(key)) {
					value=value==null?"":value+"";
					insertMap.put("consigneeName",value); //收货人姓名
				}
				if("key3".equals(key)) {
					value=value==null?"":value+"";
					insertMap.put("consigneeContact",value); //收货人联系方式
				}
				if("key4".equals(key)) {
					value=value==null?"":value+"";
					insertMap.put("consigneeAddress",value); //收货人地址
				}
				if("key7".equals(key)) {
					value=value==null?"":value+"";
					insertMap.put("goodsNumber",value); //商品编号
				}
				if("key8".equals(key)) {
					value=value==null?"":value+"";
					insertMap.put("goodsName",value); //商品名称
				}
				if("key9".equals(key)) {
					value=value==null?"":value+"";
					insertMap.put("buyType",value); //购买方式
				}
				if("key18".equals(key)) {
					value=value==null?"":value+"";
					insertMap.put("goodsStatus",value); //商品状态
				}
				if("key19".equals(key)) {
					value=value==null?"":value+"";
					insertMap.put("distributorName",value); //配送商名称
				}
				if("key20".equals(key)) {
					value=value==null?"":value+"";
					insertMap.put("distributorNumber",value); //配送单号
				}
				if("key21".equals(key)) {
					value=value==null?"":value+"";
					insertMap.put("deliveryTime",value); //发货时间
				}
				if("key24".equals(key)) {
					value=value==null?"":value+"";
					insertMap.put("orderType",value); //订单类型
				}
				if("key26".equals(key)) {
					value=value==null?"":value+"";
					insertMap.put("paymentType",value); //支付类型
				}								
			}
			insertList.add(insertMap);
		}
		return insertList;		
	}
}
