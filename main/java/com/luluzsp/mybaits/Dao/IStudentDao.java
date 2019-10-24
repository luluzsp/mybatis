package com.luluzsp.mybaits.Dao;

import com.luluzsp.mybaits.entity.Student;
import com.luluzsp.mybaits.entity.StudentVO;

import java.util.List;

/**
 * @author ：luluzsp
 * @date ：Created on 2019/10/21 10:00
 * @description：Student持久层接口
 * @modified By：
 * @version:
 */
public interface IStudentDao {

    /**
     * @Author: luluzsp
     * @Description: 查询所有用户
     * @Date: 10:01 2019/10/21
     * @return: java.util.List<com.luluzsp.mybaits.entity.Student>
     * @Version: 1.0
     */
    List<Student> findAll();

    /**
     * @Author: luluzsp
     * @Description: 保存student
     * @Date: 16:01 2019/10/21
     * @param student
     * @return: void
     * @Version: 1.0
     */
    void saveStudent(Student student);

    /**
     * @Author: luluzsp
     * @Description: 更新学生信息
     * @Date: 16:24 2019/10/21
     * @param student
     * @return: void
     * @Version: 1.0
     */
    void updateStudent(Student student);

    /**
     * @Author: luluzsp
     * @Description: 删除学生信息
     * @Date: 13:49 2019/10/23
     * @param id
     * @return: void
     * @Version: 1.0
     */
    void deleteStudent(Integer id);

    /**
     * @Author: luluzsp
     * @Description: 根据动态拼接的条件查询
     * @Date: 13:50 2019/10/23
     * @param student
     * @return: java.util.List<com.luluzsp.mybaits.entity.Student>
     * @Version: 1.0
     */
    List<Student> findStudentByCriteria(Student student);

    List<Student> findStudentByIds(StudentVO vo);
}
