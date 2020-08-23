package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.CarSampleMapper;
import com.ruoyi.system.domain.CarSample;
import com.ruoyi.system.service.ICarSampleService;
import com.ruoyi.common.core.text.Convert;

/**
 * 客户原样Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-07-30
 */
@Service
public class CarSampleServiceImpl implements ICarSampleService 
{
    @Autowired
    private CarSampleMapper carSampleMapper;

    /**
     * 查询客户原样
     * 
     * @param sampleid 客户原样ID
     * @return 客户原样
     */
    @Override
    public CarSample selectCarSampleById(Integer sampleid)
    {
        return carSampleMapper.selectCarSampleById(sampleid);
    }

    /**
     * 查询客户原样列表
     * 
     * @param carSample 客户原样
     * @return 客户原样
     */
    @Override
    public List<CarSample> selectCarSampleList(CarSample carSample)
    {
        return carSampleMapper.selectCarSampleList(carSample);
    }

    /**
     * 新增客户原样
     * 
     * @param carSample 客户原样
     * @return 结果
     */
    @Override
    public int insertCarSample(CarSample carSample)
    {
        return carSampleMapper.insertCarSample(carSample);
    }

    /**
     * 修改客户原样
     * 
     * @param carSample 客户原样
     * @return 结果
     */
    @Override
    public int updateCarSample(CarSample carSample)
    {
        return carSampleMapper.updateCarSample(carSample);
    }

    /**
     * 删除客户原样对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteCarSampleByIds(String ids)
    {
        return carSampleMapper.deleteCarSampleByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除客户原样信息
     * 
     * @param sampleid 客户原样ID
     * @return 结果
     */
    @Override
    public int deleteCarSampleById(Integer sampleid)
    {
        return carSampleMapper.deleteCarSampleById(sampleid);
    }
}
