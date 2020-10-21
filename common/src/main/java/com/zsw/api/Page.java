package com.zsw.api;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 分页查询请求参数响应参数对象
 *
 * @author zhangshiwei
 * @since 2020年10月21日 上午11:30:38
 */
@Accessors(chain = true)
@Data
@EqualsAndHashCode
public class Page<T> implements Serializable {
    private static final long   serialVersionUID  = -3939417600928116634L;

    /**
     * 默认的每页条数为：20
     */
    public static final int     DEFAULT_PAGE_SIZE = 20;
    /**
     * 默认的起始页面为：1（在MySQL中是从0开始，使用的时候需要减一）
     */
    public static final int     DEFAULT_PAGE_NUM  = 1;

    /**
     * 每页条数
     */
    private int                 pageSize          = DEFAULT_PAGE_SIZE;
    /**
     * 第几页，在MySQL中是从0开始，使用的时候需要减一
     */
    private int                 pageNum           = DEFAULT_PAGE_NUM;
    /**
     * 记录总数
     */
    private int                 totalCount        = 0;
    /**
     * 分页查询条件参数
     */
    private T                   param;
    /**
     * 分页排序字段
     */
    private Sort                sort;
    /**
     * 结果列表数据
     */
    private List<T>             value;
    private boolean             success           = true;
    private String              errorMsg;
    private String              errorCode;
    private Map<String, Object> extraInfo;
}
