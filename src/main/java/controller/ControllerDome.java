package controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dao.IfUserMapper;
import dao.UserMapper;
import domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ControllerDome {
    public static void main(String[] args) throws IOException {
        User user = new User();
        user.setEmail("32323232@123.com");
        user.setUsername("tom");
        user.setPhoneNum("12323242424");
        user.setPassword("3232324pj");
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
 /*       UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.delete(22);
        List<User> userList = mapper.findAll();

        //mapper.insert(user);
        System.out.println(userList);*/
        //////设置分页参数
        PageHelper.startPage(1,3);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.findAll();
        PageInfo<User> pageInfo = new PageInfo<User>(userList);
        System.out.println("当前页："+pageInfo.getPageNum());
        System.out.println("每页显示条数："+pageInfo.getPageSize());
        System.out.println("总条数："+pageInfo.getTotal());
        System.out.println("总页数："+pageInfo.getPages());
        System.out.println("上一页："+pageInfo.getPrePage());
        System.out.println("下一页："+pageInfo.getNextPage());
        System.out.println("是否是第一个："+pageInfo.isIsFirstPage());
        System.out.println("是否是最后一个："+pageInfo.isIsLastPage());

        System.out.println(userList);
        sqlSession.close();


    }
}
