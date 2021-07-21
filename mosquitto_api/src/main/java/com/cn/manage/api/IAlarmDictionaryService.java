package com.cn.manage.api;

import com.cn.manage.domain.AlarmDictionary;
import com.cn.manage.domain.QueryForm;

import java.util.List;

public interface IAlarmDictionaryService {

    List<AlarmDictionary> queryDictionaryList(QueryForm queryForm);

    boolean addDictionary(AlarmDictionary dictionary);

    boolean updateDictionary(AlarmDictionary dictionary);

    boolean deleteDictionary(String id);
}
