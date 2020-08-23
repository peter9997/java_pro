package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 客户原样对象 car_sample
 * k
 * k
 *
 * @author ruoyi
 * @date 2020-07-30
 */
public class CarSample extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 样品id */
    private Integer sampleid;

    /** 样品编号 */
    private String samplecode;

    /** 客户编号 */
    @Excel(name = "客户编号")
    private Integer customerid;

    /** 样品名 */
    @Excel(name = "样品名")
    private String samplename;

    /** oem */
    @Excel(name = "oem")
    private String oem;

    /** 国家 */
    @Excel(name = "国家")
    private Integer country;

    /** 极数 */
    @Excel(name = "极数")
    private Integer poleCount;

    /** 图片链接 */
    @Excel(name = "图片链接")
    private String pic;

    /** 备注 */
    @Excel(name = "备注")
    private String besides;

    public void setSampleid(Integer sampleid)
    {
        this.sampleid = sampleid;
    }

    public Integer getSampleid()
    {
        return sampleid;
    }
    public void setSamplecode(String samplecode)
    {
        this.samplecode = samplecode;
    }

    public String getSamplecode()
    {
        return samplecode;
    }
    public void setCustomerid(Integer customerid)
    {
        this.customerid = customerid;
    }

    public Integer getCustomerid()
    {
        return customerid;
    }
    public void setSamplename(String samplename)
    {
        this.samplename = samplename;
    }

    public String getSamplename()
    {
        return samplename;
    }
    public void setOem(String oem)
    {
        this.oem = oem;
    }

    public String getOem()
    {
        return oem;
    }
    public void setCountry(Integer country)
    {
        this.country = country;
    }

    public Integer getCountry()
    {
        return country;
    }
    public void setPoleCount(Integer poleCount)
    {
        this.poleCount = poleCount;
    }

    public Integer getPoleCount()
    {
        return poleCount;
    }
    public void setPic(String pic)
    {
        this.pic = pic;
    }

    public String getPic()
    {
        return pic;
    }
    public void setbesides(String besides)
    {
        this.besides = besides;
    }

    public String getbesides()
    {
        return besides;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("sampleid", getSampleid())
                .append("samplecode", getSamplecode())
                .append("customerid", getCustomerid())
                .append("samplename", getSamplename())
                .append("oem", getOem())
                .append("country", getCountry())
                .append("poleCount", getPoleCount())
                .append("pic", getPic())
                .append("besides", getbesides())
                .toString();
    }
}
