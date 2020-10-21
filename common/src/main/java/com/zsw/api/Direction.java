package com.zsw.api;

import java.util.Locale;

import lombok.extern.slf4j.Slf4j;

/**
 * 排序枚举类
 */
@Slf4j
public enum Direction {
    /**
     * 升序
     */
    ASC,
    /**
     * 降序
     */
    DESC;

    public static Direction fromString(String value) {
        try {
            return Direction.valueOf(value.toUpperCase(Locale.US));
        } catch (Exception e) {
            throw new IllegalArgumentException(String.format(
                    "Invalid value '%s' for orders given! Has to be either 'desc' or 'asc' (case insensitive).", value),
                    e);
        }
    }

    public static Direction fromStringOrNull(String value) {
        try {
            return (value != null ? fromString(value) : null);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }
}
