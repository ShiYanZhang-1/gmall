package top.shiyana.gmall.pms.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


import com.oyyo.core.bean.PageVo;
import com.oyyo.core.bean.QueryCondition;
import com.oyyo.core.bean.Resp;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import top.shiyana.gmall.pms.entity.AttrEntity;
import top.shiyana.gmall.pms.service.AttrService;
import top.shiyana.gmall.pms.vo.AttrVO;
import top.shiyana.gmall.pms.vo.GroupVO;


/**
 * 商品属性
 *
 * @author shiyana
 * @email shiyana@lcd.com
 * @date 2020-05-04 14:46:17
 */
@Api(tags = "商品属性 管理")
@RestController
@RequestMapping("pms/attr")
public class AttrController {
    @Autowired
    private AttrService attrService;

    @GetMapping
    public Resp<PageVo> queryAttrsByCid(QueryCondition condition,
                                        @RequestParam("cid")Long cid,
                                        @RequestParam(value = "type",defaultValue = "1")Integer type){
        PageVo page = attrService.queryAttrsByCid(condition,cid,type);

        return Resp.ok(page);
    }



    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('pms:attr:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = attrService.queryPage(queryCondition);

        return Resp.ok(page);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{attrId}")
    @PreAuthorize("hasAuthority('pms:attr:info')")
    public Resp<AttrEntity> info(@PathVariable("attrId") Long attrId){
		AttrEntity attr = attrService.getById(attrId);

        return Resp.ok(attr);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('pms:attr:save')")
    public Resp<Object> save(@RequestBody AttrVO attr){
		attrService.saveAttr(attr);
        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('pms:attr:update')")
    public Resp<Object> update(@RequestBody AttrEntity attr){
		attrService.updateById(attr);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('pms:attr:delete')")
    public Resp<Object> delete(@RequestBody Long[] attrIds){
		attrService.removeByIds(Arrays.asList(attrIds));

        return Resp.ok(null);
    }

}
