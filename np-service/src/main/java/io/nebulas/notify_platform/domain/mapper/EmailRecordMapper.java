package io.nebulas.notify_platform.domain.mapper;

import io.nebulas.notify_platform.domain.model.EmailRecord;
import io.nebulas.notify_platform.domain.model.EmailRecordCondition;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EmailRecordMapper {
    int countByCondition(EmailRecordCondition example);

    int deleteByCondition(EmailRecordCondition example);

    int deleteById(Long id);

    int insert(EmailRecord record);

    int insertSelective(EmailRecord record);

    List<EmailRecord> selectByCondition(EmailRecordCondition example);

    EmailRecord selectById(Long id);

    int updateByConditionSelective(@Param("record") EmailRecord record, @Param("example") EmailRecordCondition example);

    int updateByCondition(@Param("record") EmailRecord record, @Param("example") EmailRecordCondition example);

    int updateByIdSelective(EmailRecord record);

    int updateById(EmailRecord record);
}