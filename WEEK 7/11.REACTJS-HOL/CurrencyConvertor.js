import React, { useState } from 'react';
import './App.css';

const CurrencyConvertor = () => {
  const [amount, setAmount] = useState('');
  const [currency, setCurrency] = useState('Euro');
  const handleSubmit = (e) => {
    e.preventDefault();
    const value = parseFloat(amount);
    if (isNaN(value)) {
      alert('Please enter a valid amount.');
      return;
    }
    let rate = 0;
    if (currency === 'Euro') {
      rate = 90;
    }
    const result = (value * rate).toFixed(2);
    alert(`Converted amount in INR: ₹ ${result}`);
  };
  return (
    <div>
      <h2 className='rh2'>Currency Convertor!</h2>
      <form onSubmit={handleSubmit}>
        <label>
          Amount:
          <input
            type="text"
            value={amount}
            onChange={(e) => setAmount(e.target.value)}
          />
        </label>
        <br />
        <label>
          Currency:
          <input
            type="text"
            value={currency}
            onChange={(e) => setCurrency(e.target.value)}
          />
        </label>
        <br />
        <button type="submit">Submit</button>
      </form>
    </div>
  );
};

export default CurrencyConvertor;
