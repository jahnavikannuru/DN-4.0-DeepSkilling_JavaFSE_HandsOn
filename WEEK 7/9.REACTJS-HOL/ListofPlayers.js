import React from 'react';

function ListofPlayers() {
  const players = [
    { name: "Jack", score: 50 },
    { name: "Michael", score: 70 },
    { name: "John", score: 40 },
    { name: "Ann", score: 61 },
    { name: "Elisabeth", score: 61 },
    { name: "Sachin", score: 95 },
    { name: "Dhoni", score: 100 },
    { name: "Virat", score: 84 },
    { name: "Jadeja", score: 64 },
    { name: "Raina", score: 75 },
    { name: "Rohit", score: 80 }
  ];

  const lowScorers = players.filter(player => player.score < 70);

  return (
    <div>
      <h2>List of Players</h2>
        {players.map(item => (
          <li>Mr.{item.name} <span>{item.score}</span></li>
        ))}
        <hr/>
      <h2>List of Players Having Scores Less Than 70</h2>
        {lowScorers.map(player => (
          <li>Mr.{player.name} <span>{player.score}</span></li>
        ))}
    </div>
  );
}

export default ListofPlayers;
