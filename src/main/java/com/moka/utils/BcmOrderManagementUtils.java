package com.moka.utils;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ooxml.util.SAXHelper;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;

import com.moka.model.ChBcmOrderManagement;

import javax.xml.parsers.ParserConfigurationException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 解析交行销售订单工具类
 * 基于XML读取excel,减少内存占用
 * 平安销售订单数据
 * Event API
 * Created by ray on 2018/11/20.
 *
 * @author ray
 */
@Component
public class BcmOrderManagementUtils {

    private static final Logger LOG = LoggerFactory.getLogger(BcmOrderManagementUtils.class);

	public static final String A8constant = null;

//    @Autowired
//    private OrderValidateUtils afu;
//
//    
//    @Autowired
//    private ChBcmOrderManagement chBcmOrderManagement;

    /**
             * 处理excel中一个sheet页
     * @param filePath 文件路径
     * @param fileName 文件名称
     * @return
     * @throws Exception
     */
    public List<ChBcmOrderManagement> processOneSheet(String filePath, String fileName) throws Exception {
    	OrderValidateUtils afu = new OrderValidateUtils();
        LOG.info("start:读取" + fileName);
        //解析文件是否为xlsx
        if (!afu.verifyExcelTypeIsO7(fileName)) {
            LOG.error("excel文件版本错误!");
            return null;
        }
        // 文件路径
        String file = afu.mergeFilePath(filePath, fileName);
        //打开文件
        OPCPackage pkg = OPCPackage.open(file);
        //读取文件
        XSSFReader reader = new XSSFReader(pkg);
        //共享存放字符串列表
        SharedStringsTable sst = reader.getSharedStringsTable();

        XMLReader parser = fetchSheetParser(sst);

        //normally it`s of the form rId# or rSheet#
        //获取第一个sheet页名称
        InputStream sheet = reader.getSheet("rId1");
        InputSource sheetSource = new InputSource(sheet);
        parser.parse(sheetSource);

        sheetHandler sheetHandler = (sheetHandler) parser.getContentHandler();
        List<ChBcmOrderManagement> paPoList = sheetHandler.getPaList();

        LOG.info("end:读取" + fileName + "共处理[" + sheetHandler.getRowNum() + "]条");
        LOG.info("有效数据[" + paPoList.size() + "]");

        sheet.close();
        return paPoList;
    }


    /**
     * @param sst
     * @return
     * @throws SAXException
     * @throws ParserConfigurationException
     */
    public XMLReader fetchSheetParser(SharedStringsTable sst) throws
            SAXException, ParserConfigurationException, ParseException {

        XMLReader parser = SAXHelper.newXMLReader();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //处理sheet页面内容
        ContentHandler handler = new sheetHandler(sst);
        parser.setContentHandler(handler);
        return parser;
    }


    /**
     * 处理sheet页
     */
    @Getter
    @Setter
    private static class sheetHandler extends DefaultHandler {

        private SharedStringsTable sst;

        private boolean valueIsString = false;// <v></v>标签数据类型

        private String value;// <v></v>标签数据值

        private Integer rowNum = 0;// excel行数;默认值为0;

        private Integer colNum = 0;// excel列数;默认值为0;

        private String reference;// 单元格索引

    //    private ChBcmOrderManagement paPo = new ChBcmOrderManagement(); ;// 交行销售订单实体类
        private ChBcmOrderManagement paPo = null;

        private List<ChBcmOrderManagement> paList = new ArrayList<>();

        private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        private Calendar excelCreTime = Calendar.getInstance();// excel创建时间

        private Date orderTime = new Date();// 订单订购时间

        private StringBuffer errorMsg = new StringBuffer();// 数据行错误信息

        private MultiValueMap<String, String> provinces;// 中国所有省

        private MultiValueMap<String, String> cityKeys;// 市key:北京市key->北京

        private MultiValueMap<String, String> cities;// 中国所有市

        private MultiValueMap<String, String> districts;// 区

        private sheetHandler(SharedStringsTable sst) {

            this.sst = sst;
        }

        /**
                       * 第一个执行
                       * 查找单元格
         *
         * @param uri
         * @param localName
         * @param qName
         * @param attributes  row-c-v 开始标签<>
         * @throws SAXException
         */
        @Override
        public void startElement(String uri, String localName, String qName,
                                 Attributes attributes) throws SAXException {
            // 只解析c -> cell
            if ("row".equals(qName)) {
                // 清空列数,重新计算
                this.colNum = 0;
                // 统计行数
                this.rowNum++;
                paPo=new ChBcmOrderManagement(); 
            }
            if ("c".equals(qName)) {
                // 计算列数
                this.colNum++;
                // r为索引:A1/B1/C1;t为类型:string类型 -> t=s;其它为null
                String valueType = attributes.getValue("t");// 获取单元格类型
                reference = attributes.getValue("r").split("[0-9]+")[0];
                this.valueIsString = (valueType != null) && "s".equals(valueType);
			
            }
            // 清空单元格缓存值
            this.value = "";
        }

        //写入值
        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            // 写入标签中的text文本到value
            value += new String(ch, start, length);
        }
        
        //结束标签</>
        @Override
        public void endElement(String uri, String localName, String qName)
                throws SAXException {
            // 校验标题行
            if (this.rowNum == 1) {
                if ("v".equals(qName)) {
                    if (this.valueIsString) {
                        this.value = sst.getItemAt(Integer.parseInt(this.value)).getString().trim();
                        this.valueIsString = false;
                    }
                    switch (this.colNum) {
                        case 1:
                            LOG.info("第" + this.colNum + "列标题:[" + this.value + "]");
                            if (!"订单编号".equals(this.value)) {
                                LOG.error("交行销售订单第" + this.colNum + "列标题错误!--标题为:[" + this.value + "]");
                                throw new RuntimeException();
                            }
                            break;
                        case 2:
                            LOG.info("第" + this.colNum + "列标题:[" + this.value + "]");
                            if (!"订购时间".equals(this.value)) {
                                LOG.error("交行销售订单第" + this.colNum + "列标题错误!--标题为:[" + this.value + "]");
                                throw new RuntimeException();
                            }
                            break;
                        case 3:
                            LOG.info("第" + this.colNum + "列标题:[" + this.value + "]");
                            if (!"收货人姓名".equals(this.value)) {
                                LOG.error("交行销售订单第" + this.colNum + "列标题错误!--标题为:[" + this.value + "]");
                                throw new RuntimeException();
                            }
                            break;
                        case 4:
                            LOG.info("第" + this.colNum + "列标题:[" + this.value + "]");
                            if (!"收货人联系方式".equals(this.value)) {
                                LOG.error("交行销售订单第" + this.colNum + "列标题错误!--标题为:[" + this.value + "]");
                                throw new RuntimeException();
                            }
                            break;
                        case 5:
                            LOG.info("第" + this.colNum + "列标题:[" + this.value + "]");
                            if (!"收货人地址".equals(this.value)) {
                                LOG.error("交行销售订单第" + this.colNum + "列标题错误!--标题为:[" + this.value + "]");
                                throw new RuntimeException();
                            }
                            break;
                        case 8:
                            LOG.info("第" + this.colNum + "列标题:[" + this.value + "]");
                            if (!"商品编号".equals(this.value)) {
                                LOG.error("交行销售订单第" + this.colNum + "列标题错误!--标题为:[" + this.value + "]");
                                throw new RuntimeException();
                            }
                            break;
                        case 9:
                            LOG.info("第" + this.colNum + "列标题:[" + this.value + "]");
                            if (!"商品名称".equals(this.value)) {
                                LOG.error("交行销售订单第" + this.colNum + "列标题错误!--标题为:[" + this.value + "]");
                                throw new RuntimeException();
                            }
                            break;
                        case 10:
                            LOG.info("第" + this.colNum + "列标题:[" + this.value + "]");
                            if (!"购买方式".equals(this.value)) {
                                LOG.error("交行销售订单第" + this.colNum + "列标题错误!--标题为:[" + this.value + "]");
                                throw new RuntimeException();
                            }
                            break;
                        case 19:
                            LOG.info("第" + this.colNum + "列标题:[" + this.value + "]");
                            if (!"商品状态".equals(this.value)) {
                                LOG.error("交行销售订单第" + this.colNum + "列标题错误!--标题为:[" + this.value + "]");
                                throw new RuntimeException();
                            }
                            break;
                        case 20:
                            LOG.info("第" + this.colNum + "列标题:[" + this.value + "]");
                            if (!"配送商名称".equals(this.value)) {
                                LOG.error("交行销售订单第" + this.colNum + "列标题错误!--标题为:[" + this.value + "]");
                                throw new RuntimeException();
                            }
                            break;
                        case 21:
                            LOG.info("第" + this.colNum + "列标题:[" + this.value + "]");
                            if (!"配送单号".equals(this.value)) {
                                LOG.error("交行销售订单第" + this.colNum + "列标题错误!--标题为:[" + this.value + "]");
                                throw new RuntimeException();
                            }
                            break;
                        case 22:
                            LOG.info("第" + this.colNum + "列标题:[" + this.value + "]");
                            if (!"发货时间".equals(this.value)) {
                                LOG.error("交行销售订单第" + this.colNum + "列标题错误!--标题为:[" + this.value + "]");
                                throw new RuntimeException();
                            }
                            break;
                        case 25:
                            LOG.info("第" + this.colNum + "列标题:[" + this.value + "]");
                            if (!"订单类型".equals(this.value)) {
                                LOG.error("交行销售订单第" + this.colNum + "列标题错误!--标题为:[" + this.value + "]");
                                throw new RuntimeException();
                            }
                            break;
                        case 27:
                            LOG.info("第" + this.colNum + "列标题:[" + this.value + "]");
                            if (!"支付类型".equals(this.value)) {
                                LOG.error("交行销售订单第" + this.colNum + "列标题错误!--标题为:[" + this.value + "]");
                                throw new RuntimeException();
                            }
                            break;
                            default:
                            break;
                    }
                }
            }
            // 处理交行销售数据
            if (this.rowNum > 1) {
                if ("v".equals(qName)) {
                    if (valueIsString) {
                        this.value = sst.getItemAt(Integer.parseInt(this.value)).getString();
                        this.valueIsString = false;
                    }
                    // System.out.println(this.value);
                    switch (this.reference) {
                        // 处理订单编号
                        case "A":
                            // 先赋值
                            paPo.setOrderNumber(Long.parseLong(this.value));
                            break;
                        // 处理订单生成时间
                        case "B":
                            if (StringUtils.isEmpty(this.value)) {
                                paPo.setOrderTime("订购时间为空");
                                break;
                            }
                            paPo.setOrderTime(this.value);
                            break;
                         // 收货人姓名
                        case "C":      
//                            paPo.setConsigneeName(this.value);
//                            break;
                            paPo.setConsigneeName(this.value);
                            this.value = this.value.trim();// 去空格
                            //this.value = this.value.replaceAll("万里通|中国平安", "");
                            //this.value = this.value.replaceFirst("[0-9]{6,100}", "");// 去电话号
                            this.value = this.value.replaceAll("\\p{P}", "");// 去标点符号
                            this.value = this.value.replaceAll("\\p{Blank}", "");// 去空格或tab
//                            this.value = this.value.replaceAll("(手机|电话|联系|号码|号)+(方式)?", "");
//                            this.value = this.value.replaceAll("先生|小姐", "");
//                            this.value = this.value.replaceAll("男士|女士", "");
//                            this.value = this.value.replaceAll("老师|经理", "");
//                            this.value = this.value.replaceAll("收[\\u4e00-\\u9fa5]人", "");
//                            this.value = this.value.replaceAll("(收货|姓名)+", "");
//                            this.value = this.value.replaceAll("名字", "");
//                            if (this.value.endsWith("代收")) {
//                                this.value = this.value.replace("代收", "");
//                            } else if (this.value.endsWith("收")) {
//                                this.value = this.value.replace("收", "");
//                            }
                            if (StringUtils.isEmpty(this.value)) {
//                                paPo.setStatus(A8constant.PA_ERROR_CODE_NAME);
//                                paPo.setErrorMsg("收件人姓名含有非法字符");
                                // System.out.println(this.reference + this.rowNum + this.errorMsg + "[" + oriData + "]");
                                paPo.setConsigneeName("龙的传人");
                            } else {
                                paPo.setConsigneeName(this.value);
                            }
                            break;
                        // 收货人联系方式
                        case "D":
                            paPo.setConsigneeContact(this.value);
                            this.value = this.value.trim();
                            this.value = this.value.replaceAll("\\p{P}", "");
                            this.value = StringUtils.remove(this.value, "|");
                            if (StringUtils.isNotEmpty(this.value)) {
                                paPo.setConsigneeContact(this.value);
                            } 
                            break;
                        // 收货人地址
                        case "E":
                            paPo.setConsigneeAddress(this.value);
;
                        // 商品编号
                        case "H":
                            if (StringUtils.isNotEmpty(this.value)) {
                                paPo.setGoodsNumber(this.value);
                            }
                            break;
                        // 商品名称
                        case "I":
                            if (StringUtils.isNotEmpty(this.value)) {
                                paPo.setGoodsName(this.value);
                            }
                            break;
                        // 购买方式
                        case "J":
                            paPo.setBuyType(this.value);
                            break;
                        // 商品状态
                        case "S":
                            paPo.setGoodsStatus(this.value);
                            break;
                        // 配送商名称
                        case "T":
                            paPo.setDistributorName(this.value);
                            break;
                        // 配送单号
                        case "U":
                        	if(StringUtils.isNotEmpty(this.value)) {
                            paPo.setDistributorNumber(Long.parseLong(this.value));
                        	}
                            break;
                        // 发货时间
                        case "V":
                            paPo.setDeliveryTime(this.value);
                            break;
                        // 订单类型
                        case "Y":
                        	  paPo.setOrderType(this.value);
                            break;
                        //支付类型
                        case "AA":
                        	 paPo.setPaymentType(this.value);
                            break;
                           default:
                            break;
                    }
                } else if ("row".equals(qName)) {
                    // 行处理结束
                	if("已发货".equals(paPo.getGoodsStatus())) {
                		paPo.setOrderPlatform("交行");
                    paList.add(paPo);
                	}
                }
            }
        }
    }
}
