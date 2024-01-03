# omikujava
おみくじを行ってくれるServerアプリケーションです。  

# How to use?  
omikujavaを起動します。  
特段の設定がない場合、8080ポートを解放するので、以下URLに対し、GETリクエストを送信してください。  
`http://localhost:8080/omikuji`  

`http://localhost:8080/omikuji/full`にGETを投げると、総合的に運勢を占ってくれます。  

結果はHTTPレスポンスボディに格納されて帰ってきます。  
例：  
```json
{
    "result": "凶"
}
```
