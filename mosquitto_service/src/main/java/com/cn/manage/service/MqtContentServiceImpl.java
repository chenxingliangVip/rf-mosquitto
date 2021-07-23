package com.cn.manage.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cn.manage.api.IDictionaryService;
import com.cn.manage.api.IMqtContentService;
import com.cn.manage.api.ITopicService;
import com.cn.manage.dao.MqtContentMapper;
import com.cn.manage.domain.*;
import com.cn.manage.util.Constants;
import com.cn.manage.utils.CollectionsUtil;
import com.cn.manage.utils.CommonUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MqtContentServiceImpl implements IMqtContentService {

    @Autowired
    private MqtContentMapper mqtContentMapper;

    @Autowired
    private IDictionaryService dictionaryService;

    @Autowired
    private ITopicService topicService;

    @Override
    public Map<String,List<JSONObject>> queryMqtContents(QueryForm queryForm) {
        Map<String,List<JSONObject>> mqtContentMap = Maps.newHashMap();
        List<Dictionary> dictionaries = dictionaryService.queryDictionaryList(new QueryForm());
        List<Topic> topics = topicService.queryTopics(new QueryForm());
        Map<String,String> dicMap = Maps.newHashMap();
        for(Topic top :topics){
            String topicName = top.getTopicName();
            mqtContentMap.put(topicName,Lists.newArrayList());
        }
        if(CollectionsUtil.isNotEmpty(dictionaries)&& CollectionsUtil.isNotEmpty(topics)){
            for(Dictionary dictionary:dictionaries){
                dicMap.put(dictionary.getDicKey(),dictionary.getDicValue());
            }
            List<MqtContent> mqtContents =  mqtContentMapper.selectMqtDetailByTopic(queryForm);
            if(CollectionsUtil.isNotEmpty(mqtContents)){
               for(MqtContent mqtContent:mqtContents){
                    String topicName = mqtContent.getTopic();
                    String contents = mqtContent.getContent();
                    if(mqtContentMap.containsKey(topicName)){
                        List<JSONObject> result = mqtContentMap.get(topicName);
                        try {
                            JSONObject json = JSON.parseObject(contents);
                            JSONArray  AxisNames = json.getJSONArray("AxisNames");
                            JSONArray  AbsPosition = json.getJSONArray("AbsPosition");
                            JSONArray  RelPosition = json.getJSONArray("RelPosition");
                            JSONArray  Position = json.getJSONArray("Position");
                            JSONArray  Distance = json.getJSONArray("Distance");
                            JSONArray  Feedrateload = json.getJSONArray("Feedrateload");
                            JSONArray  Spindlerateload = json.getJSONArray("Spindlerateload");
                            JSONArray  ServoTemperature = json.getJSONArray("ServoTemperature");
                            JSONArray  EncoderTemperature = json.getJSONArray("EncoderTemperature");
                            String axisStr = "";
                            if(CollectionsUtil.isNotEmpty(AxisNames)){
                                for (int i = 0; i<AxisNames.size();i++){
                                    axisStr += (i==AxisNames.size()-1)?  AxisNames.get(i): AxisNames.getString(i)+",";
                                }
                            }
                            json.put("AxisNames",axisStr);
                            double AbsPositionArray[] = new double[]{0.0,0.0,0.0};
                            double RelPositionArray[] = new double[]{0.0,0.0,0.0};
                            double PositionArray[] = new double[]{0.0,0.0,0.0};
                            double DistanceArray[] = new double[]{0.0,0.0,0.0};
                            double FeedrateloadArray[] = new double[]{0.0,0.0,0.0};
                            double SpindlerateloadArray[] = new double[]{0.0};
                            double ServoTemperatureArray[] = new double[]{0.0,0.0,0.0};
                            double EncoderTemperatureArray[] = new double[]{0.0,0.0,0.0};
                            if(CollectionsUtil.isNotEmpty(AbsPosition)){
                                for (int i = 0; i<AbsPosition.size();i++){
                                    AbsPositionArray[i] = AbsPosition.getDoubleValue(i);
                                }
                            }
                            if(CollectionsUtil.isNotEmpty(RelPosition)){
                                for (int i = 0; i<RelPosition.size();i++){
                                    RelPositionArray[i] = RelPosition.getDoubleValue(i);
                                }
                            }
                            if(CollectionsUtil.isNotEmpty(Position)){
                                for (int i = 0; i<Position.size();i++){
                                    PositionArray[i] = Position.getDoubleValue(i);
                                }
                            }
                            json.put("AbsPosition",AbsPositionArray);
                            json.put("RelPosition",RelPositionArray);
                            json.put("Position",PositionArray);

                            if(CollectionsUtil.isNotEmpty(Distance)){
                                for (int i = 0; i<Distance.size();i++){
                                    DistanceArray[i] = Position.getDoubleValue(i);
                                }
                            }
                            json.put("Distance",PositionArray);

                            if(CollectionsUtil.isNotEmpty(Feedrateload)){
                                for (int i = 0; i<Feedrateload.size();i++){
                                    FeedrateloadArray[i] = Position.getDoubleValue(i);
                                }
                            }
                            json.put("Feedrateload",FeedrateloadArray);

                            if(CollectionsUtil.isNotEmpty(Spindlerateload)){
                                for (int i = 0; i<Spindlerateload.size();i++){
                                    SpindlerateloadArray[i] = Position.getDoubleValue(i);
                                }
                            }
                            json.put("Spindlerateload",SpindlerateloadArray);

                            if(CollectionsUtil.isNotEmpty(ServoTemperature)){
                                for (int i = 0; i<ServoTemperature.size();i++){
                                    ServoTemperatureArray[i] = Position.getDoubleValue(i);
                                }
                            }
                            json.put("ServoTemperature",ServoTemperatureArray);

                            if(CollectionsUtil.isNotEmpty(EncoderTemperature)){
                                for (int i = 0; i<EncoderTemperature.size();i++){
                                    EncoderTemperatureArray[i] = Position.getDoubleValue(i);
                                }
                            }
                            json.put("EncoderTemperature",EncoderTemperatureArray);

                            result.add(json);
                        }catch (Exception e){
                            e.printStackTrace();
                        }

                    }
               }
            }
        }
        return mqtContentMap;
    }

    @Override
    public boolean addMqtContents(MqtContent mqtContent) {
        String id = CommonUtil.generateRandomNum("topic-");
        mqtContent.setId(id);
        int count = mqtContentMapper.insertSelective(mqtContent);
        return count > 0;
    }

    @Override
    public int queryMqtContentsCounts(MqtContent mqtContent) {
        MqtContentExample example = new MqtContentExample();
        example.createCriteria().andStatusEqualTo(Constants.NORMAL_STATUS);
        int count = mqtContentMapper.countByExample(example);
        return count;
    }

}
