package vip.zhangw.onlineeducation.mapper;

import org.apache.ibatis.annotations.Param;
import vip.zhangw.onlineeducation.domain.PlayRecord;

/**
 * @program: onlineeducation->PlayRecordMapper
 * @description:
 * @author: zhangwen
 * @create: 2020-08-11 23:05
 **/
public interface PlayRecordMapper {

    int insertPlayRecord(PlayRecord playRecord);
}
