  function ReadExcel() {  
           var tempStr = "";  
           //得到文件路径的值  
           var filePath = document.getElementById("upfile").value;  
           //创建操作EXCEL应用程序的实例  
           var oXL = new ActiveXObject("Excel.application");  
            //打开指定路径的excel文件  
           var oWB = oXL.Workbooks.open(filePath);  
           //操作第一个sheet(从一开始，而非零)  
           oWB.worksheets(1).select();  
           var oSheet = oWB.ActiveSheet;  
           //使用的行数  
         var rows =  oSheet .usedrange.rows.count;   
           try {  
              for (var i = 2; i <= rows; i++) {  
                 if (oSheet.Cells(i, 2).value == "null" || oSheet.Cells(i, 3).value == "null") break;  
                 var a = oSheet.Cells(i, 2).value.toString() == "undefined" ? "": oSheet.Cells(i, 2).value;  
                 tempStr += (" " + oSheet.Cells(i, 2).value + " " + oSheet.Cells(i, 3).value + " " + oSheet.Cells(i, 4).value + " " + oSheet.Cells(i, 5).value + " " + oSheet.Cells(i, 6).value + "\n");  
              }  
           } catch(e) {  
              document.getElementById("txtArea").value = tempStr;  
           }  
           document.getElementById("txtArea").value = tempStr;  
           //退出操作excel的实例对象  
           oXL.Application.Quit();  
            //手动调用垃圾收集器  
           CollectGarbage();  
        }  