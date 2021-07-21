package com.cn.manage.api;

import com.cn.manage.domain.Dictionary;
import com.cn.manage.domain.QueryForm;

import java.util.List;

public interface IDictionaryService {

    List<Dictionary> queryDictionaryList(QueryForm queryForm);

    boolean addDictionary(Dictionary dictionary);

    boolean updateDictionary(Dictionary dictionary);

    boolean deleteDictionary(String id);
}
