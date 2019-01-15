package com.hrms.test;

import com.hrms.bean.Employee;
import com.hrms.mapper.EmployeeMapper;
import com.hrms.util.CreateGUID;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.UUID;

/**
 * @author GenshenWang.nomico
 * @date 2018/3/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:springmvc.xml"})
public class EmployeeMapperTest {

    @Autowired
    EmployeeMapper employeeMapper;

    //用来批量插入操作
    @Autowired
    SqlSession sqlSession;

    /**
     * 单条记录插入
     */
    @Test
    public void insertOneTest(){
        Employee employee = new Employee(CreateGUID.createGuId(), "aa", "aa@qq.com", "男", "");
        int res = employeeMapper.insertOne(employee);
        System.out.println(res);
    }

    /**
     * 批量插入
     */
    @Test
    public void insertEmpsBatchTest(){
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        for (int i = 1; i < 50; i++) {
            String uid = UUID.randomUUID().toString().substring(0, 5);
            employeeMapper.insertOne(new Employee(CreateGUID.createGuId(), "name_"+uid, uid+"@qq.com",  i%2==0? "F":"M", ""));
        }
    }

    @Test
    public void updateOneByIdTest(){
        Employee employee =
                new Employee("60b2b1a73a7042e992babe675680917e", "aa", "aa@qq.com", "女", "");
        int res = employeeMapper.updateOneById("60b2b1a73a7042e992babe675680917e", employee);
        System.out.println(res);
    }

    @Test
    public void selectOneByIdTest(){
        Employee employee = employeeMapper.selectOneById("60b2b1a73a7042e992babe675680917e");
        System.out.println(employee);
    }

    @Test
    public void selectOneByNameTest(){
        Employee employee = employeeMapper.selectOneByName("aa");
        System.out.println(employee);
    }

    @Test
    public void selectWithDeptByIdTest(){
        Employee employee = employeeMapper.selectWithDeptById("60b2b1a73a7042e992babe675680917e");
        System.out.println(employee);
    }

    @Test
    public void countEmpsTest(){
        System.out.println(employeeMapper.countEmps());
    }

    @Test
    public void selectByLimitAndOffsetTest(){
        List<Employee> list = employeeMapper.selectByLimitAndOffset(5, 10);
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    @Test
    public void deleteOneByIdTest(){
        int res = employeeMapper.deleteOneById("");
        System.out.println(res);

    }

}
