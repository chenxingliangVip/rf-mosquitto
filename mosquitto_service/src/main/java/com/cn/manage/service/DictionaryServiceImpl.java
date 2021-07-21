package com.cn.manage.service;


import com.cn.manage.api.IDictionaryService;
import com.cn.manage.dao.DictionaryMapper;
import com.cn.manage.domain.Dictionary;
import com.cn.manage.domain.DictionaryExample;
import com.cn.manage.domain.QueryForm;
import com.cn.manage.utils.CommonUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DictionaryServiceImpl implements IDictionaryService {

    @Autowired
    DictionaryMapper dictionaryMapper;

    @Override
    public List<Dictionary> queryDictionaryList(QueryForm queryForm) {
        DictionaryExample example = new DictionaryExample();
        DictionaryExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotBlank(queryForm.getKey())){
            criteria.andDicKeyEqualTo(queryForm.getKey());
        }
        if(StringUtils.isNotBlank(queryForm.getValue())){
            criteria.andDicValueEqualTo(queryForm.getValue());
        }
        return dictionaryMapper.selectByExample(example);
    }

    @Override
    public boolean addDictionary(Dictionary dictionary) {
        String id = CommonUtil.generateRandomNum("topic-");
        dictionary.setId(id);
        int count = dictionaryMapper.insertSelective(dictionary);
        return count > 0;
    }

    @Override
    public boolean updateDictionary(Dictionary dictionary) {
        return false;
    }

    @Override
    public boolean deleteDictionary(String id) {
        int count = 0;
        if(StringUtils.isNotBlank(id)){
            DictionaryExample example = new DictionaryExample();
            example.createCriteria().andIdEqualTo(id);
            count = dictionaryMapper.deleteByExample(example);
        }
        return count > 0;
    }
}
