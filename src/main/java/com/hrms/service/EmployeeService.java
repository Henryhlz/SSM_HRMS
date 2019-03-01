package com.hrms.service;

import com.hrms.bean.Employee;
import com.hrms.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author GenshenWang.nomico
 * @date 2018/3/7.
 */
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    public int getEmpCount(){
        return employeeMapper.countEmps();
    }
    public List<Employee> getEmpList(Integer offser, Integer limit){
        return employeeMapper.selectByLimitAndOffset(offser, limit);
    }

    public Employee getEmpById(String empId) {
        return employeeMapper.selectOneById(empId);
    }

    public Employee getEmpByName(String empName) {
        return employeeMapper.selectOneByName(empName);
    }

    public Employee getEmpByInfo(Employee employee) {
        return employeeMapper.selectOneByInfo(employee);
    }

    ;
    public int updateEmpById(String empId, Employee employee){return employeeMapper.updateOneById(empId, employee);}
    public int deleteEmpById(String empId){
        return employeeMapper.deleteOneById(empId);
    }
    public int addEmp(Employee employee){
        return employeeMapper.insertOne(employee);
    }


}
