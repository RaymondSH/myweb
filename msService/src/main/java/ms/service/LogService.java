package ms.service;

import ms.entity.Log;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Raymond on 2018/11/25.
 */
public interface LogService {
    void addSystemLog(Log log);
    void addLoginLog(Log log);
    void addOperationLog(Log log);

    List<Log> getSystemLog();
    List<Log> getLoginLog();
    List<Log> getOperationLog();
}
