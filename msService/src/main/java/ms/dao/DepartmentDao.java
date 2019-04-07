package ms.dao;

import ms.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Raymond on 2018/11/25.
 */
@Repository("departmentDao")
public interface DepartmentDao {
    void insert(Department department);
    void delete(Integer id);
    void update(Department department);
    Department selectById(Integer id);
    List<Department> selectAll();
}
