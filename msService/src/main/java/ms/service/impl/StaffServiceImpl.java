package ms.service.impl;

import ms.dao.StaffDao;
import ms.entity.Staff;
import ms.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Raymond on 2018/11/25.
 */
@Service("staffService")
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffDao staffDao;
    public void add(Staff staff) {
        staff.setPassword("123456");
        staff.setWorkTime(new Date());
        staff.setStatus("正常");
        staffDao.insert(staff);
    }

    public void remove(Integer id) {
        staffDao.delete(id);
    }

    public void edit(Staff staff) {
        staffDao.update(staff);
    }

    public Staff getById(Integer id) {
        return staffDao.selectById(id);
    }

    public List<Staff> getAll() {
        return staffDao.selectAll();
    }

    public Staff login(String account, String password) {
        Staff staff = staffDao.selectByAccount(account);
        if (staff == null){
            return null;
        }
        if (staff.getPassword().equals(password)){
            return staff;
        }
        return null;
    }

    public void changePassword(Integer id, String newPassword) {
        Staff staff = staffDao.selectById(id);
        staff.setPassword(newPassword);
        staffDao.update(staff);
    }
}
