import React, { useState } from 'react';
import './App.css';
import CurrencyConvertor from './CurrencyConvertor';

function App() {
  const [count, setCount] = useState(0);
  const increment = () => {
    setCount(count => count + 1);
    sayHello();
  };
  const decrement = () => {
    setCount(count => count - 1);
  };
  const sayHello = () => {
    console.log('Hello! This is a static message.');
  };
  const sayWelcome = () => {
    alert('Welcome!');
  };
  const handleOnPress = () => {
    alert('I was clicked');
  };
  return (
    <div>
      <h2>{count}</h2>
      <button onClick={increment}>Increment</button>
      <br />
      <button onClick={decrement}>Decrement</button>
      <br />
      <div>
        <button onClick={sayWelcome}>Say Welcome</button>
      </div>
      <div>
        <button onClick={handleOnPress}>Click on me</button>
      </div>
      <br />
      <CurrencyConvertor />
    </div>
  );
}

export default App;
