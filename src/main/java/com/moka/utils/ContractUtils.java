package com.moka.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.springframework.stereotype.Service;

/**
 * Created by ray on 2018/11/7.
 */
@Service
public class ContractUtils {

    private static final String FILE_PATH = "D:/demo/";

    private static final String FILE_TEMPLATE = "demo合同模板.docx";

    /**
     * 根据模板初始化文件内容
     *
     * @return 文件document
     */
    public XWPFDocument getContractTemplate() {
        XWPFDocument document = null;
        FileInputStream fis = null;

        try {

            fis = new FileInputStream(FILE_PATH + FILE_TEMPLATE);
            document = new XWPFDocument(fis);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {

        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return document;
    }

    /**
     * 初始化参数map
     *
     * @param contract 合同实体类
     * @return map:合同模板中可替换的参数map
     */
    public Map<String, Object> initContractParam(ContractReq contract) {
        Map<String, Object> params = new HashMap<>();
        params.put("${purBillsId}", contract.getPurBillsId());//合同编号
        params.put("${companyName}", contract.getCompanyName());//甲方名称
        params.put("${supplyName}", contract.getSupplyName());//乙方名称
        params.put("${supplyAddress}", contract.getSupplyAddress());//乙方地址
        params.put("${contractItem}", contract.getContractItem());//??
        params.put("${contractStr1}", contract.getContractStr1());//??验收质量标准 
        params.put("${depotAddress}", contract.getDepotAddress());//仓库地址
        params.put("${depotPerson}", contract.getDepotPerson());//仓库人
        params.put("${depotPhone}", contract.getDepotPhone());//仓库电话
        params.put("${accountName}", contract.getSupplyName());//账户名
        params.put("${supplyAccountName}", contract.getSupplyAccountName());
        params.put("${supplyAccount}", contract.getSupplyAccount());
        params.put("${agent}", contract.getAgent());

        params.put("items", contract.getItems());

        return params;
    }

    /**
     * 匹配含有${}的字符串
     *
     * @param str 字符串
     * @return 字符串中含有${}
     */
    public Matcher matcher(String str) {

        Pattern pattern = Pattern.compile("\\$\\{(.+?)\\}", Pattern.CASE_INSENSITIVE);//匹配的对象
        Matcher matcher = pattern.matcher(str);

        return matcher;
    }

    /**
     * 写文件
     *
     * @param document 合同document
     */
    public void writeContract(XWPFDocument document) {

        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream(FILE_PATH + "demo合同.docx");
            document.write(fos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取指定字符串str中的${key}包含的key,根据此key获取map中的value,替换str中的${key}
     *
     * @param params    合同模板的替换参数map
     * @param str       需要替换的字符串
     * @param fromIndex 查找的索引位置
     * @return
     */
    public String replaceStr(Map<String, Object> params, String str, int fromIndex) {

        int indexFlag = fromIndex;
        int start = str.indexOf("${", indexFlag);//$的index
        if (start == -1) {
            // 没有可替换
            return str;
        } else {
            indexFlag = start + 2;
            int end = str.indexOf("}", indexFlag);
            if (end == -1) {
                // 找不到结束符号"}"
                return str;
            } else {
                String key = str.substring(indexFlag, end);
                String newStr = str.replace("${" + key + "}", String.valueOf(params.get("${" + key + "}")));
                newStr = this.replaceStr(params, newStr, 0);
                return newStr;
            }
        }
    }

    /**
     * 替换合同模板中的字符串
     *
     * @param params
     * @param paragraph
     * @param fromIndex
     */
    public void replaceInParams(Map<String, Object> params, XWPFParagraph paragraph, int fromIndex) {
    	
        List<XWPFRun> runList = paragraph.getRuns();//拿到每一个runs
        for (int i = 0; i < runList.size(); i++) {
            XWPFRun run = runList.get(i);
            String str = run.toString();
            str = replaceStr(params, str, fromIndex);
            run.setText(str, 0);
        }
    }
    /**
     * 创建excel表格
     * @param params
     * @param table
     */
    public void replaceInTable(Map<String, Object> params, XWPFTable table) {
        @SuppressWarnings("unchecked")
		List<ContractItemReq> items = (List<ContractItemReq>) params.get("items");
        List<XWPFTableRow> rows = table.getRows();
        XWPFTableCell cellTemplate = rows.get(1).getCell(0);
        int fontSize = cellTemplate.getParagraphArray(0).getRuns().get(0).getFontSize();
        int length = rows.size();
        // 重置表格样式
        for (int i = 1; i < length; i++) {
            rows.get(i).getTableCells().stream().forEach(
                    cell -> {
                        if (cell.getParagraphArray(0) != null) {
                            cell.removeParagraph(0);
                            cell.addParagraph();
                            XWPFParagraph paragraph = cell.getParagraphArray(0);
                            XWPFRun run = paragraph.createRun();
                            run.setFontFamily("宋体");
                            run.setFontSize(fontSize);
                        }
                    }
            );
        }
        int sumNum = 0;
        BigDecimal sumPrice = BigDecimal.valueOf(0);
        // 表格体
        for (int i = 1; i < length - 1; i++) {
            rows.get(i).getCell(0).getParagraphArray(0).getRuns().get(0).setText(items.get(i - 1).getProductName());
            rows.get(i).getCell(1).getParagraphArray(0).getRuns().get(0).setText(String.valueOf(items.get(i - 1).getPurNumber()));
            rows.get(i).getCell(2).getParagraphArray(0).getRuns().get(0).setText(items.get(i - 1).getProductUnit());
            rows.get(i).getCell(3).getParagraphArray(0).getRuns().get(0).setText(items.get(i - 1).getPack());
            rows.get(i).getCell(4).getParagraphArray(0).getRuns().get(0).setText(String.valueOf(items.get(i - 1).getProductPrice()));
            rows.get(i).getCell(5).getParagraphArray(0).getRuns().get(0).setText(String.valueOf(items.get(i - 1).getMoney()));
            rows.get(i).getCell(6).getParagraphArray(0).getRuns().get(0).setText(items.get(i - 1).getMemo());
            sumNum = sumNum +  Integer.parseInt(items.get(i - 1).getPurNumber());//合计总数
            sumPrice = sumPrice.add(new BigDecimal(items.get(i - 1).getMoney()));//合计总金额
        }
        // 表格尾
        rows.get(length - 1).getCell(0).getParagraphArray(0).getRuns().get(0).setText("合计");
        rows.get(length - 1).getCell(1).getParagraphArray(0).getRuns().get(0).setText(String.valueOf(sumNum));
        rows.get(length - 1).getCell(2).getParagraphArray(0).getRuns().get(0).setText("");
        rows.get(length - 1).getCell(3).getParagraphArray(0).getRuns().get(0).setText("");
        rows.get(length - 1).getCell(4).getParagraphArray(0).getRuns().get(0).setText("");
        rows.get(length - 1).getCell(5).getParagraphArray(0).getRuns().get(0).setText(String.valueOf(sumPrice));
        rows.get(length - 1).getCell(6).getParagraphArray(0).getRuns().get(0).setText("备注信息");
    }
}
