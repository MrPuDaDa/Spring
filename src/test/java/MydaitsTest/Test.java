package MydaitsTest;

import domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
    ////////////查询操作
    @org.junit.Test
    public void test1() throws IOException {
        ////////获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        List<User> userList = sqlSession.selectList("userMapper.findAll");
        System.out.println(userList);
        //////释放连接
        sqlSession.close();
    }


    ///////////插入操作
    @org.junit.Test
    public void test2() throws IOException {
        User user = new User();
        user.setEmail("32323232@123.com");
        user.setUsername("tom");
        user.setPhoneNum("12323242424");
        user.setPassword("3232324pj");

        ////////获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("dao.userMapper.insert",user);

        /////mybatis执行更新操作需要提交事务
        sqlSession.commit();
        //////释放连接
        sqlSession.close();
    }

    ///////////修改操作
    @org.junit.Test
    public void test3() throws IOException {
        User user = new User();
        user.setId(19L);
        user.setUsername("jack");

        ////////获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("userMapper.update",user);

        /////mybatis执行更新操作需要提交事务
        sqlSession.commit();
        //////释放连接
        sqlSession.close();
    }

    ///////////删除操作
    @org.junit.Test
    public void test4() throws IOException {
        ////////获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.insert("userMapper.delete",19);

        /////mybatis执行更新操作需要提交事务
        sqlSession.commit();
        //////释放连接
        sqlSession.close();
    }



}
