import React from 'react';

const courses = [
  { name: 'Angular', date: '4/5/2021' },
  { name: 'React', date: '6/3/2021' }
];

const CourseDetails = () => {
  if (!courses || courses.length === 0) return null;

  const courseList = (
    <ul>
      {courses.map((course) => (
        <div>
          <h3>{course.name}</h3>
          <h4>{course.date}</h4>
        </div>
      ))}
    </ul>
  );

  return <>{courseList}</>;
};

export default CourseDetails;
