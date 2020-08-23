package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.CarSample;

/**
 * 客户原样Mapper接口
 *
 * @author ruoyi
 * @date 2020-07-30
 */
public interface CarSampleMapper
{
    /**
     * 查询客户原样
     *
     * @param sampleid 客户原样ID
     * @return 客户原样
     */
    public CarSample selectCarSampleById(Integer sampleid);

    /**
     * 查询客户原样列表
     *
     * @param carSample 客户原样
     * @return 客户原样集合
     */
    public List<CarSample> selectCarSampleList(CarSample carSample);

    /**
     * 新增客户原样
     *
     * @param carSample 客户原样
     * @return 结果
     */
    public int insertCarSample(CarSample carSample);

    /**
     * 修改客户原样
     *
     * @param carSample 客户原样
     * @return 结果
     */
    public int updateCarSample(CarSample carSample);

    /**
     * 删除客户原样
     *
     * @param sampleid 客户原样ID
     * @return 结果
     */
    public int deleteCarSampleById(Integer sampleid);

    /**
     * 批量删除客户原样
     *
     * @param sampleids 需要删除的数据ID
     * @return 结果
     */
    public int deleteCarSampleByIds(String[] sampleids);
}
