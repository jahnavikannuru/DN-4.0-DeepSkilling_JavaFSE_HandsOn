import React from 'react';
import ListofPlayers from './components/ListofPlayers';
import IndianPlayers from './components/IndianPlayers';

function App() {
  var flag = false;

  if (flag) {
    return (
      <div>
        <ListofPlayers />
      </div>
    );
  } else {
    return (
      <div>
        <IndianPlayers />
      </div>
    );
  }
}

export default App;
