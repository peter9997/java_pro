package com.ruoyi.web.controller.system;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.config.Global;
import com.ruoyi.common.config.ServerConfig;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.framework.web.domain.server.SysFile;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.tomcat.jni.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.CarSample;
import com.ruoyi.system.service.ICarSampleService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.multipart.MultipartFile;

/**
 * 客户原样Controller
 * 
 * @author ruoyi
 * @date 2020-07-30
 */
@Controller
@RequestMapping("/system/sample")
public class CarSampleController extends BaseController
{
    // 上传文件路径
    @Value("${ruoyi.profile}")
    private String filePath;

    private String prefix = "system/sample";

    @Autowired
    private ICarSampleService carSampleService;

    @RequiresPermissions("system:sample:view")
    @GetMapping()
    public String sample()
    {
        return prefix + "/sample";
    }

    /**
     * 查询客户原样列表
     */
    @RequiresPermissions("system:sample:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(CarSample carSample)
    {
        startPage();
        List<CarSample> list = carSampleService.selectCarSampleList(carSample);
        return getDataTable(list);
    }

    /**
     * 导出客户原样列表
     */
    @RequiresPermissions("system:sample:export")
    @Log(title = "客户原样", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(CarSample carSample)
    {
        List<CarSample> list = carSampleService.selectCarSampleList(carSample);
        ExcelUtil<CarSample> util = new ExcelUtil<CarSample>(CarSample.class);
        return util.exportExcel(list, "sample");
    }

    /**
     * 新增客户原样
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存客户原样
     */
    @RequiresPermissions("system:sample:add")
    @Log(title = "客户原样", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(CarSample carSample) throws IOException
    {
//        System.out.println(filePath);
        return toAjax(carSampleService.insertCarSample(carSample));
    }
    /**
     * 新增保存客户原样
     */
    @RequiresPermissions("system:sample:add")
    @Log(title = "客户原样文件上传", businessType = BusinessType.INSERT)
    @PostMapping("/uploadFile")
    @ResponseBody
    public String uploadFile(@RequestParam(value = "file") MultipartFile file,HttpServletResponse response) throws IOException
    {
    	
    	String fileName = FileUploadUtils.upload(filePath, file);
    	//File img = new File(filePath+"/"+fileName);
    	Map<String,Object> respMap = new HashMap<String, Object>();
    	respMap.put("fileName", fileName);
		JSONObject result = JSONObject.parseObject(JSON.toJSONString(respMap));
		response.getWriter().print(result);
		return null;
    }

    /**
     * 修改客户原样
     */
    @GetMapping("/edit/{sampleid}")
    public String edit(@PathVariable("sampleid") Integer sampleid, ModelMap mmap)
    {
        CarSample carSample = carSampleService.selectCarSampleById(sampleid);
        mmap.put("carSample", carSample);
        return prefix + "/edit";
    }

    /**
     * 修改保存客户原样
     */
    @RequiresPermissions("system:sample:edit")
    @Log(title = "客户原样", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(CarSample carSample)
    {
        return toAjax(carSampleService.updateCarSample(carSample));
    }

    /**
     * 删除客户原样
     */
    @RequiresPermissions("system:sample:remove")
    @Log(title = "客户原样", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(carSampleService.deleteCarSampleByIds(ids));
    }


    @Autowired
    private ServerConfig serverConfig;


}
