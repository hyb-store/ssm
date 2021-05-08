package com.hyb.ssm.service;

import com.hyb.ssm.domain.SysLog;

import java.util.List;

public interface ISysLogService {
    void save(SysLog sysLog) throws Exception;

    List<SysLog> findAll(int page, int size) throws Exception;

}
