package cn.axg.common.api;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.PageUtil;
import com.github.pagehelper.PageInfo;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页数据封装类
 */
@Data
public class CommonPage<T> {
    private Integer pageNum;
    private Integer pageSize;
    private Integer totalPage;
    private Long total;
    private List<T> list;

    /**
     * 将PageHelper分页后的list转为分页信息
     */
    public static <T> CommonPage<T> restPage(List<T> list) {
        CommonPage<T> result = new CommonPage<T>();
        PageInfo<T> pageInfo = new PageInfo<T>(list);
        result.setTotalPage(pageInfo.getPages());
        result.setPageNum(pageInfo.getPageNum());
        result.setPageSize(pageInfo.getPageSize());
        result.setTotal(pageInfo.getTotal());
        result.setList(pageInfo.getList());
        return result;
    }

    /**
     * 将SpringData分页后的list转为分页信息
     */
    public static <T> CommonPage<T> restPage(Page<T> pageInfo) {
        CommonPage<T> result = new CommonPage<T>();
        result.setTotalPage(pageInfo.getTotalPages());
        result.setPageNum(pageInfo.getNumber());
        result.setPageSize(pageInfo.getSize());
        result.setTotal(pageInfo.getTotalElements());
        result.setList(pageInfo.getContent());
        return result;
    }

    /**
     * Hutools方式实现分页 将查询后的list结果集仍进来即可
     *
     * @param currentPage
     * @param pageSize
     * @param list
     * @param <T>
     * @return
     */
    public static <T> CommonPage<T> restPage(Integer currentPage, Integer pageSize, List<T> list) {
        CommonPage<T> result = new CommonPage<T>();
        List<T> pageList = new ArrayList<>();
        //计算总页数
        int totalSize = list.size();
        int totalPage = PageUtil.totalPage(totalSize, pageSize);
        result.setTotalPage(totalPage);
        result.setPageNum(currentPage);
        result.setPageSize(pageSize);
        result.setTotal(Convert.toLong(totalSize));
        if (currentPage <= totalPage) {
            // 分页
            pageList = CollUtil.page(currentPage, pageSize, list);
        }
        result.setList(pageList);
        return result;
    }

}
