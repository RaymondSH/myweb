package ms.service;

import ms.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Raymond on 2018/11/25.
 */
public interface DepartmentService {
    void add(Department department);
    void remove(Integer id);
    void edit(Department department);
    Department getById(Integer id);
    List<Department> getAll();
    Department get(Integer id);
}
