import React from 'react';

const blogs = [
  {
    title: 'React Learning',
    author: 'Stephen Biz',
    content: 'Welcome to learning React!'
  },
  {
    title: 'Installation',
    author: 'Schewzdenier',
    content: 'You can install React from npm.'
  }
];

const BlogDetails = () => {
  let blogList;

  if (blogs.length > 0) {
    blogList = blogs.map((blog) => (
      <div>
        <h3>{blog.title}</h3>
        <p>{blog.author}</p>
        <p>{blog.content}</p>
      </div>
    ));
  } else {
    blogList = <p>No blogs available</p>;
  }

  return <ul>{blogList}</ul>;
};

export default BlogDetails;
