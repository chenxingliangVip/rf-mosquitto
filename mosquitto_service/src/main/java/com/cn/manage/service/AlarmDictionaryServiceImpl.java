package com.cn.manage.service;


import com.cn.manage.api.IAlarmDictionaryService;
import com.cn.manage.dao.AlarmDictionaryMapper;
import com.cn.manage.domain.AlarmDictionary;
import com.cn.manage.domain.AlarmDictionaryExample;
import com.cn.manage.domain.QueryForm;
import com.cn.manage.utils.CommonUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlarmDictionaryServiceImpl implements IAlarmDictionaryService {

    @Autowired
    AlarmDictionaryMapper alarmDictionaryMapper;

    @Override
    public List<AlarmDictionary> queryDictionaryList(QueryForm queryForm) {
        AlarmDictionaryExample example = new AlarmDictionaryExample();
        AlarmDictionaryExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(queryForm.getAlarmCode())){
            criteria.andAlarmCodeEqualTo(queryForm.getAlarmCode());
        }
        if(StringUtils.isNotBlank(queryForm.getAlarmValue())){
            criteria.andAlarmValueEqualTo(queryForm.getAlarmValue());
        }
        return alarmDictionaryMapper.selectByExample(example);
    }

    @Override
    public boolean addDictionary(AlarmDictionary dictionary) {
        String id = CommonUtil.generateRandomNum("topic-");
        dictionary.setId(id);
        int count = alarmDictionaryMapper.insertSelective(dictionary);
        return count > 0;
    }

    @Override
    public boolean updateDictionary(AlarmDictionary dictionary) {
        return false;
    }

    @Override
    public boolean deleteDictionary(String id) {
        int count = 0;
        if(StringUtils.isNotBlank(id)){
            AlarmDictionaryExample example = new AlarmDictionaryExample();
            example.createCriteria().andIdEqualTo(id);
            count = alarmDictionaryMapper.deleteByExample(example);
        }
        return count > 0;
    }
}
