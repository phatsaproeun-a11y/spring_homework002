package org.example._0_proeun_phatsa_spring_homework002.repository;

import org.apache.ibatis.annotations.*;
import org.example._0_proeun_phatsa_spring_homework002.model.entity.Posts;

import java.util.List;

@Mapper
public interface PostRepo {

    @Select("SELECT * FROM posts")
    @Results(id = "PostMapper", value = {
            @Result(property = "id",       column = "id"),
            @Result(property = "title",    column = "title"),
            @Result(property = "content",  column = "content"),
            @Result(property = "author",   column = "author"),
            @Result(property = "createdAt", column = "created_at"),
            @Result(property = "tags",     column = "tags")
    })
    List<Posts> findAll();

    @Select("SELECT * FROM posts WHERE id = #{id}")
    @ResultMap("PostMapper")
    Posts findById(Long id);

    @Select("SELECT * FROM posts WHERE title = #{title}")
    @ResultMap("PostMapper")
    List<Posts> findByTitle(String title);

    @Select("SELECT * FROM posts WHERE author = #{author}")
    @ResultMap("PostMapper")
    List<Posts> findByAuthor(String author);

    @Insert("""
        INSERT INTO posts(title, content, author, created_at, tags)
        VALUES (#{title}, #{content}, #{author}, #{createdAt}, #{tags})
    """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int save(Posts post);

    @Update("""
        UPDATE posts 
        SET title = #{title},
            content = #{content},
            author = #{author},
            created_at = #{createdAt},
            tags = #{tags}
        WHERE id = #{id}
    """)
    int updateById(Posts post);

    @Delete("DELETE FROM posts WHERE id = #{id}")
    int deleteById(Long id);
}