import React from 'react';
import BookDetails from './components/BookDetails';
import BlogDetails from './components/BlogDetails';
import CourseDetails from './components/CourseDetails';
import './App.css';

const App = () => {
  const showBooks = true;
  const showBlogs = true;
  const showCourses = true;
  let courseContent;
  if (showCourses) {
    courseContent = <CourseDetails />;
  }
  let bookContent;
  if (showBooks) {
    bookContent = <BookDetails />;
  }
  let blogContent;
  if (showBlogs) {
    blogContent = <BlogDetails />;
  } else {
    blogContent = <p>No blogs to show</p>;
  }
  return (
    <div className="container">
      <div className="column">
        <h1>Course Details</h1>
        {courseContent}
      </div>
      <div className="divider" />
      <div className="column">
        <h1>Book Details</h1>
        {bookContent}
      </div>

      <div className="divider" />

      <div className="column">
        <h1>Blog Details</h1>
        {blogContent}
      </div>
    </div>
  );
};

export default App;
