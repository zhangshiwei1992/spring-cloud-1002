package com.zsw.api;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * api接口统一响应对象
 *
 * @author zhangshiwei
 * @since 2020年10月21日 上午11:29:24
 */
@AllArgsConstructor
@Accessors(chain = true)
@Data
@EqualsAndHashCode
public class Result<T> implements Serializable {
    private static final long   serialVersionUID = -8699167988071027834L;

    private T                   value;

    private boolean             success          = true;

    private String              errorCode;

    private String              errorMsg;

    private Map<String, Object> extraInfo;

    /**
     * 创建 Result 实例
     */
    public Result() {
        super();
    }

    /**
     * 创建 Result 实例
     *
     * @param value 结果值
     */
    public Result(T value) {
        this();
        this.value = value;
    }

    /**
     * 创建 Result 实例
     * <p>
     * 初始化错误信息，会设置<code>success = false</code>
     *
     * @param errorMsg 错误信息
     * @param errorCode 错误代码
     */
    public Result(String errorCode, String errorMsg) {
        this(false, errorCode, errorMsg);
    }

    /**
     * 创建 Result 实例
     *
     * @param success 是否成功
     * @param errorMsg 错误信息
     * @param errorCode 错误代码
     */
    public Result(boolean success, String errorCode, String errorMsg) {
        this(null, success, errorCode, errorMsg);
    }

    /**
     * 创建 Result 实例
     *
     * @param value 结果值
     * @param success 是否成功
     * @param errorMsg 错误信息
     * @param errorCode 错误代码
     */
    public Result(T value, boolean success, String errorCode, String errorMsg) {
        this.success = success;
        this.value = value;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    /**
     * 增加扩展信息
     *
     * @param key 扩展信息中的key
     * @param value 扩展信息中的value
     * @return 当前Result实例对象
     */
    public Result<T> addExtraInfo(String key, Object value) {
        if (this.extraInfo == null) {
            this.extraInfo = new HashMap<>();
        }
        this.extraInfo.put(key, value);
        return this;
    }

    /**
     * 获取扩展信息
     *
     * @param key 扩展信息中的key
     * @return 扩展信息中的value
     */
    public Object getExtraInfo(String key) {
        return (this.extraInfo != null ? this.extraInfo.get(key) : null);
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
