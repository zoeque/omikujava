import { useState } from 'react'
import './App.css'
import RequestButton from './RequestButton'

function App() {
  const [result, setResult] = useState(null);

  const handleResult = (res) => {
    setResult(res);
  }

  return (
    <>
      <h1>今年の運勢は</h1>
      <div className="card">
        {/* ここでRequestButtonのGETに対し得られたresultを表示する */}
        <RequestButton onResult={handleResult} />
        {result && <div>{result}</div>}
        <p>
          Edit <code>src/App.tsx</code> and save to test HMR
        </p>
      </div>
      <p className="read-the-docs">
        Click on the Vite and React logos to learn more
      </p>
    </>
  )
}

export default App