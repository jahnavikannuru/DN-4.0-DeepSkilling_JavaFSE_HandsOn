import React from 'react';

const books = [
  { id: 101, bname: 'Master React', price: 670 },
  { id: 102, bname: 'Deep Dive into Angular 11', price: 800 },
  { id: 103, bname: 'Mongo Essentials', price: 450 }
];

const BookDetails = () => {
  const bookdet = (
    <ul>
      {books.map((book) => (
        <div>
          <h3>{book.bname}</h3>
          <h4>{book.price}</h4>
        </div>
      ))}
    </ul>
  );

  return <>{bookdet}</>;
};

export default BookDetails;
