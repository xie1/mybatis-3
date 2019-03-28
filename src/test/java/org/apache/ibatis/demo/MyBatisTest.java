package org.apache.ibatis.demo;

import org.apache.ibatis.demo.dao.ArticleDao;
import org.apache.ibatis.demo.model.Article;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {


    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void prepare() throws IOException {
        // 通过读取配置获得输入流
        String resource = "mybatis-config.xml";
        // 从配置的信息中解析到Configuration类里面的对象
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        inputStream.close();
    }

    @Test
    public void testMyBatis() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            ArticleDao articleDao = sqlSession.getMapper(ArticleDao.class);
            List<Article> articles = articleDao.findByAuthorAndCreateTime("2", "2018-06-10");
            for (Article article : articles) {
                System.out.println("文章的标题-->" + article.getTitle());
            }
        } finally {
            sqlSession.commit();
            sqlSession.close();
        }
    }
}
