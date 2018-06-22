package io.nebulas.notify_platform.dao;

import io.nebulas.notify_platform.domain.mapper.EmailRecordMapper;
import io.nebulas.notify_platform.domain.model.EmailRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * created by Keqi Huang on 2018/6/20.
 */
@Repository
public class EmailRecordDao {
    @Autowired
    private EmailRecordMapper mapper;

    public int add(String receiver, String sender, String subject, String content, int isSuccess){
        EmailRecord er = new EmailRecord();
        er.setReceiver(receiver);
        er.setSender(sender);
        er.setSubject(subject);
        er.setContent(content);
        er.setIsSuccess(isSuccess);
        return mapper.insertSelective(er);
    }

}
