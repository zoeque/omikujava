# omikujava
おみくじを行ってくれるServerアプリケーションです。  

# How to use?  
omikujavaを起動します。  
特段の設定がない場合、8080ポートを解放するので、以下のようにGETリクエストを送信してください。  
`http://localhost:8080/omikuji`  

レスポンスボディに結果が格納されて帰ってきます。  
例：  
```json
{
    "result": "凶"
}
```