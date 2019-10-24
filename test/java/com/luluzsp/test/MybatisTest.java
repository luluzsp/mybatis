package com.luluzsp.test;


import com.luluzsp.mybaits.Dao.IStudentDao;
import com.luluzsp.mybaits.entity.Student;
import com.luluzsp.mybaits.entity.StudentVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：luluzsp
 * @date ：Created on 2019/10/21 11:13
 * @description：Mybaits入门案例
 * @modified By：
 * @version:
 */
public class MybatisTest {

    public static void main(String[] args) throws IOException {
        //读取配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSession工厂
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = sqlSessionFactoryBuilder.build(inputStream);
        //创建sqlSession
        SqlSession sqlSession = factory.openSession();
        //创建IStudentDao代理对象

    }
    private  InputStream inputStream;
    private  SqlSession sqlSession;

    @Before
    /**
     * @Author: luluzsp
     * @Description: 打开链接方法,before注解会在单元测试方法执行之前调用该方法
     * @Date: 16:12 2019/10/21
     * @return: void
     * @Version: 1.0
     */
    public  void init() throws IOException {
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSession工厂
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = sqlSessionFactoryBuilder.build(inputStream);
        //创建sqlSession
        sqlSession = factory.openSession();
    }

    @After
    /**
     * @Author: luluzsp
     * @Description: 链接关边方法,after注解会在单元测试方法结束后调用该方法
     * @Date: 16:11 2019/10/21
     * @return: void
     * @Version: 1.0
     */
    public  void destroy() throws IOException{
        inputStream.close();
        sqlSession.close();
    }

    @Test
    /**
     * @Author: luluzsp
     * @Description:查询所有的student
     * @Date: 16:13 2019/10/21
     * @return: void
     * @Version: 1.0
     */
    public void findAll(){
        IStudentDao mapper = sqlSession.getMapper(IStudentDao.class);
        //调用IStudent接口中的方法
        List<Student> students = mapper.findAll();
        students.stream().forEach(System.out::println);
    }


    @Test
    public void saveStudent(){
        Student student = new Student();
        student.setName("翟迎兵");
        student.setGender("男");
        student.setAge(30);
        student.setClassName("5班");
        IStudentDao mapper = sqlSession.getMapper(IStudentDao.class);
        mapper.saveStudent(student);
        sqlSession.commit();
    }

    @Test
    public void updateStudent(){
        Student student = new Student();
        student.setId(29);
        student.setName("翟迎兵");
        student.setGender("男");
        student.setAge(29);
        student.setClassName("3班");
        IStudentDao mapper = sqlSession.getMapper(IStudentDao.class);
        mapper.updateStudent(student);
        sqlSession.commit();
    }

    @Test
    public  void deleteStudent(){
        IStudentDao mapper = sqlSession.getMapper(IStudentDao.class);
        mapper.deleteStudent(29);
        sqlSession.commit();
    }

    @Test
    public void findStudentByCriteria(){
        Student stu = new Student();
        //stu.setName("");
        stu.setGender("girl");
        stu.setAge(24);
        IStudentDao mapper = sqlSession.getMapper(IStudentDao.class);
        List<Student> studentList=mapper.findStudentByCriteria(stu);
        studentList.stream().forEach(System.out::println);
    }

    @Test
    public  void findStudentByIds(){
        Integer [] ids  = new Integer []{22,27,30};
        List<Integer> IdList = Arrays.asList(ids);
        StudentVO sv = new StudentVO();
        sv.setIds(IdList);
        IStudentDao mapper = sqlSession.getMapper(IStudentDao.class);
        List<Student> studentList = mapper.findStudentByIds(sv);
        studentList.stream().forEach(System.out::println);
    }
}
