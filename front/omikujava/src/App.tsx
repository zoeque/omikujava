import { useState } from 'react'
import './App.css'
import RequestButton from './RequestButton'

function App() {
  const [result, setResult] = useState(null);

  const handleResult = (res) => {
    setResult(res.result);
  }

  return (
    <>
      <h1>今年の運勢は</h1>
      <div className="card">
        {/* ここでRequestButtonのGETに対し得られたresultを表示する */}
        {result && <div><h1>{result}</h1></div>}
        <RequestButton onResult={handleResult} />
      </div>
      <p className="read-the-docs">
        Created by <a href="https://github.com/zoeque">zoeque</a>
      </p>
    </>
  )
}

export default App
