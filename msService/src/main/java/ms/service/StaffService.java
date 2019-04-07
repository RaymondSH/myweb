package ms.service;

import ms.entity.Staff;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Raymond on 2018/11/25.
 */
public interface StaffService {
    void add(Staff staff);
    void remove(Integer id);
    void edit(Staff staff);
    Staff getById(Integer id);
    List<Staff> getAll();

    Staff login(String account,String password);
    void changePassword(Integer id,String newPassword);
}
