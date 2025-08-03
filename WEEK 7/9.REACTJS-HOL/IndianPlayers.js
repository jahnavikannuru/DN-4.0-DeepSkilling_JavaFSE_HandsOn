import React from 'react';

export function IndianPlayers() {
  const oddTeam = ["Sachin1", "Dhoni2", "Virat3", "Rohit4", "Yuvaraj5", "Raina6"];
  const [first, second, third, fourth, fifth, sixth] = oddTeam;
  const mergedPlayers = [
    "Mr. First Player",
    "Mr. Second Player",
    "Mr. Third Player",
    "Mr. Fourth Player",
    "Mr. Fifth Player",
    "Mr. Sixth Player"
  ];
  return (
    <div>
      <h2>Odd Players</h2>
      <ul>
        <li>First : {first}</li>
        <li>Third : {third}</li>
        <li>Fifth : {fifth}</li>
      </ul>
      <hr />
      <h2>Even Players</h2>
      <ul>
        <li>Second : {second}</li>
        <li>Fourth : {fourth}</li>
        <li>Sixth : {sixth}</li>
      </ul>
      <hr />
      <h2>List of Indian Players Merged:</h2>
      <ul>
        {mergedPlayers.map(player => (
          <li>{player}</li>
        ))}
      </ul>
    </div>
  );
}
export default IndianPlayers;
