# User Scenarios

## Normal Scenarios

### 1. 結束使用
```
螢幕promptID 或結束使用
使用者要結束使用
螢幕showFinishMsg
```

### 2. 開始使用
```
螢幕 promptID 或結束使用
使用者輸入 ID
螢幕 showWelcomeMsg並且顯示指令選單
```

### 3. 離開主選單
```
顯示四種指令：	
	G 顯示成績 R 顯示排名 A 顯示平均 W 更新配分 E 離開選單		
使用者輸入 E，選擇離開選單	
螢幕 promptID 或結束使用
```

### 4. 顯示排名
```
螢幕 promptID 或結束使用	
使用者輸入 ID，螢幕 showWelcomeMsg並且顯示指令選單	
使用者輸入指令 R		
螢幕 prompCommand 顯示出該 ID 的排名
螢幕 showRank(ID)
螢幕 prompCommand
使用者輸入指令 E 要離開選單	
螢幕 promptID 或結束使用	
使用者要結束使用	
```

### 5. 顯示成績	
```
螢幕 promptID 或結束使用	
使用者輸入 ID，螢幕 showWelcomeMsg並且顯示指令選單	
使用者輸入指令 G		
螢幕 promptCommand 顯示出該 ID 的成績	
使用者輸入指令 E 要離開選單	
螢幕 promptID 或結束使用	
使用者要結束使用
螢幕 showFinishMsg
```

### 6. 更新配分
```
螢幕 promptID或 結束使用
使用者輸入ID
螢幕 showWelcomeMsg
螢幕 promptCommand
使用者要 updateWeights (更新配分)
螢幕顯示舊配分
使用者輸入新配分
螢幕 promptCommand
使用者要離開選單
螢幕 promptID或 結束使用
使用者要結束使用
螢幕 showFinishMsg
```

## Exceptional scenarios 異常使用情節
### 1. 輸入錯誤ID
```
螢幕promptID或 結束使用
使用者輸入錯誤的ID
螢幕顯示錯誤訊息
```

### 2. 輸入錯誤指令
```
螢幕promptID或 結束使用
使用者輸入ID 螢幕showWelcomeMsg
螢 幕 promptCommand
使用者輸入不正確指令
螢幕顯示錯誤訊息
```


## Acceptance Test Cases (<font color = "red">紅色</font>表示螢幕顯示，<font color = "blue">藍色</font>表示使用者輸入)
### 1. 結束使用
```
螢幕顯示：輸入 ID 或	Q	(結束使用)?		
使用者輸入：Q	
螢幕顯示：結束了
```

### 2.登入 ID
```
螢幕顯示：輸入 ID 或	Q	(結束使用)?		
使用者輸入：955002056	
螢幕顯示：Welcome	許文馨	
         輸入指令：	
         1)	G	顯示成績	
         2)	R	顯示排名	
         3)	A	顯示平均	
         4)	W	更新配分	
         5)	E	離開選單
```
### 3.離開主選單
```
開始至輸入指令如 Test	Case2 所示	
使用者輸入：E	
螢幕顯示：輸入 ID 或 Q?	
使用者輸入：Q	
螢幕顯示：結束了！	
```

### 4.顯示排名
開始至輸入指令如2.所示	
```
使用者輸入：R	
螢幕顯示：許文馨	第 14 名	
使用者輸入：E	
螢幕顯示：輸入 ID 或 Q?	
使用者輸入：Q	
螢幕顯示：結束了！
```

### 4.顯示排名
開始至輸入指令如2.所示	
```
使用者輸入：G	
螢幕顯示：許文馨	
lab01	lab02	lab03	midTerm	 FinalExam	
 88		 92		 88		  98		 91	
使用者輸入：E	
螢幕顯示：輸入 ID 或 Q?	
使用者輸入：Q	
螢幕顯示：結束了！	
```

### 4.顯示排名
開始至輸入指令如2.所示	
```
使用者輸入：A	
螢幕顯示：許文馨的平均成績為	 92.6 分(為加權平均)	
使用者輸入：E	
螢幕顯示：輸入 ID 或 Q?	
使用者輸入：Q	
螢幕顯示：結束了！	
```

### 4.顯示排名
開始至輸入指令如2.所示	
```
使用者輸入：W	
螢幕顯示：舊配分：lab1 10% lab2 10% lab3 10% mid-term 30%	final exam 40%
	     輸入新配分	
使用者輸入：lab1 20	
		   lab2	20	
		   lab3	20	
		   mid-term	20	
		   final-exam 20	
螢幕顯示：請確認新配分：lab1 20% lab2 20% lab3 10% mid-term 20% final exam 30%
         以上正確嗎?	Y (Yes)	或 N (No) Y
使用者輸入：Y	
螢幕顯示：完成變更	
使用者輸入：N	
螢幕顯示：已取消變更	
使用者輸入：E	
螢幕顯示：輸入 ID 或 Q?	
使用者輸入：Q	
螢幕顯示：結束了！	
```

### 8. 輸入錯誤ID
```
螢幕顯示：輸入 ID 或	Q	(結束使用)?		
使用者輸入：123456789	
螢幕顯示：	ID 錯了！
```

### 9. 輸入錯誤指令
```
螢幕顯示：輸入 ID 或	Q	(結束使用)?		
使用者輸入：955002056	
螢幕顯示：Welcome	許文馨	
         輸入指令：	
         1)	G	顯示成績	
         2)	R	顯示排名	
         3)	A	顯示平均	
         4)	W	更新配分	
         5)	E	離開選單
使用者輸入：K	
螢幕顯示：指令錯了！
```