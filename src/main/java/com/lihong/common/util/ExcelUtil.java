package com.lihong.common.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import jxl.Cell;
import jxl.CellType;
import jxl.DateCell;
import jxl.LabelCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelUtil {
    
    public static String[][] readExcel(InputStream inputStream,Integer rows,Integer cols){
      
            String [][] datas;
            InputStream is = inputStream; 
            Workbook rwb = null;
            try {
                rwb = Workbook.getWorkbook(is);
            } catch (BiffException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }  
            //Sheet st = rwb.getSheet("0")这里有两种方法获取sheet表,1为名字，而为下标，从0开始  
            Sheet st = rwb.getSheet("Sheet1"); 
            if (rows == null ) {
                rows=st.getRows();  
            }
            if (cols == null ) {
                cols=st.getColumns();  
            }
             
            datas = new String[rows][cols];
            for(int k=0;k<rows;k++){//行  
                 for(int i=0 ;i<cols;i++){//列  
                           
                   Cell cell = st.getCell(i,k);  
                    //通用的获取cell值的方式,返回字符串  
                    String str = cell.getContents();  
                    //获得cell具体类型值的方式  
                    if(cell.getType() == CellType.LABEL)  
                    {  
                        LabelCell labelcell = (LabelCell)cell;  
                        str = labelcell.getString();  
                    }  
                    //excel 类型为时间类型处理;  
                    if(cell.getType()==CellType.DATE){  
                        DateCell dc=(DateCell)cell;          
                    }  
                    //excel 类型为数值类型处理;  
                    /* 
                    if(cell.getType()==CellType.NUMBER|| cell.getType()==CellType.NUMBER_FORMULA){ 
                        NumberCell nc=(NumberCell)cell;  
                        strcell=""+nc.getValue();  
                    }*/  
                      
                    //输出  
                    datas[k][i]  = str;    
           }  
       }    
                    rwb.close();
                    return datas;  
    }
      
    /** 
     * 读取Excel 
     * @param filePath 
     * @throws FileNotFoundException 
     */  
    public static void readExcel(String filePath,Integer rows,Integer cols) throws FileNotFoundException  
    {  
        FileInputStream fileInputStream = new FileInputStream(filePath);
        readExcel(fileInputStream,rows,cols);
    }  
    
    
}
