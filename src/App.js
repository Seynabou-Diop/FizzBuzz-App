import React, { useState } from 'react';
import './App.css';

function App() {
  const [results, setResults] = useState([]);

  const getFizzBuzz = () => {
    const fizzBuzzResults = [];
    for (let i = 1; i <= 100; i++) {
      let result = '';
      if (i % 3 === 0 || i.toString().includes('3')) {
        result += 'Fizz';
      }
      if (i % 5 === 0 || i.toString().includes('5')) {
        result += 'Buzz';
      }
      if (result === '') {
        result = i.toString();
      }
      fizzBuzzResults.push(result);
    }
    return fizzBuzzResults;
  };

  const startFizzBuzz = () => {
    const results = getFizzBuzz();
    setResults(results);
  };

  return (
    <div className="App">
      <header className="header">
        <h1 className="title">FizzBuzz Application</h1>
      </header>
      <div className="content">
        <button className="start-button" onClick={startFizzBuzz}>
          Start FizzBuzz
        </button>
        <div className="results">
          {results.map((result, index) => (
            <div className="result" key={index}>
              {result}
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}

export default App;
