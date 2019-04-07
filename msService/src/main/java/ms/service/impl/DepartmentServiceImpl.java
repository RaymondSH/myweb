package ms.service.impl;

import ms.dao.DepartmentDao;
import ms.entity.Department;
import ms.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Raymond on 2018/11/25.
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    public void add(Department department) {
        departmentDao.insert(department);
    }

    public void remove(Integer id) {
        departmentDao.delete(id);
    }

    public void edit(Department department) {
        departmentDao.update(department);
    }

    public Department getById(Integer id) {
        return departmentDao.selectById(id);
    }

    public List<Department> getAll() {
        return departmentDao.selectAll();
    }

    public Department get(Integer id) {
        return departmentDao.selectById(id);
    }
}
