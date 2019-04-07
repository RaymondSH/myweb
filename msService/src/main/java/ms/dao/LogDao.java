package ms.dao;

import ms.entity.Log;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Raymond on 2018/11/25.
 */
@Repository("logDao")
public interface LogDao {
    void insert(Log log);
    List<Log> selectByType(String type);
}
