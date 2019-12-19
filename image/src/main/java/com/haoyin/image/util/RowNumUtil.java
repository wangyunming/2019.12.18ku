package com.haoyin.image.util;

import org.apache.poi.hssf.util.CellReference;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class RowNumUtil {
	
	public static int getRowNum(Sheet sht0) {
        CellReference cellReference = new CellReference("A4");
        boolean flag = false;
        for (int i = cellReference.getRow(); i <= sht0.getLastRowNum();) {  
            Row r = sht0.getRow(i);
            if(r == null){
                //如果是空行（即没有任何数据、格式），直接把它以下的数据往上移动  
            	sht0.shiftRows(i+1, sht0.getLastRowNum(),-1);  
                	continue;  
            }  
            flag = false;
            for(Cell c : r){
                if(c.getCellType() != Cell.CELL_TYPE_BLANK){  
                    flag = true;  
                       break;  
                }
            }  
            if(flag){  
                i++;  
                continue;  
            }else{//如果是空白行（即可能没有数据，但是有一定格式）  
                if(i == sht0.getLastRowNum()){
                	//如果到了最后一行，直接将那一行remove掉  
                	sht0.removeRow(r);  
                }else{
                	//如果还没到最后一行，则数据往上移一行  
                	sht0.shiftRows(i+1, sht0.getLastRowNum(),-1);  
                }
            }  
        }
        System.out.println("有效行数为:"+(sht0.getLastRowNum()+1));
        return sht0.getLastRowNum();
	}

}
