CREATE DATABASE  post_db;

CREATE TABLE posts (
    id serial PRIMARY KEY,
    title VARCHAR(100),
    content TEXT,
    author VARCHAR(100),
    created_at TIMESTAMP,
    tags VARCHAR(100)
);



insert into posts (title, content, author, created_at, tags) values ('title1', 'content1', 'author1', '2021-01-01', 'tag1,tag2');