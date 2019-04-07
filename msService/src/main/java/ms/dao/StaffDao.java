package ms.dao;

import ms.entity.Staff;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Raymond on 2018/11/25.
 */
@Repository("staffDao")
public interface StaffDao {
    void insert(Staff staff);
    void delete(Integer id);
    void update(Staff staff);
    Staff selectById(Integer id);
    List<Staff> selectAll();


    Staff selectByAccount(String  account);
}
