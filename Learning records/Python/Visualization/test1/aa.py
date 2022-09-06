# 匯入 test2(資料夾) 的 bb.py 檔案
# 注意右上角的路徑(根目錄)
# import 採用的規則(自定義模組時)是: 
# 以你當下的根目錄(右上角)做為程式執行點，然後去找到執行點到模組的相對位置
import test2.bb as bb
bb.show()
bb.show2(5)
print(bb.name)
bb.show3(5)
# 呼叫後 test2(資料夾) 會自動產生 __pycache__(資料夾)