package com.twy.mybatisplusdemo.user.config;

import cn.hutool.core.util.StrUtil;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.springframework.stereotype.Component;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author gongpeng
 * @date 2021/2/8 19:01
 */
@Component
@MappedTypes(LocalDate.class)
@MappedJdbcTypes(value = JdbcType.DATE, includeNullJdbcType = true)
public class LocalDateTypeHandler extends BaseTypeHandler<LocalDate> {

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, LocalDate parameter, JdbcType jdbcType)
            throws SQLException {
        if (parameter != null) {
            ps.setString(i, dateTimeFormatter.format(parameter));
        }
    }

    @Override
    public LocalDate getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String target = rs.getString(columnName);
        if (StrUtil.isEmpty(target)) {
            return null;
        }
        return LocalDate.parse(target, dateTimeFormatter);
    }

    @Override
    public LocalDate getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String target = rs.getString(columnIndex);
        if (StrUtil.isEmpty(target)) {
            return null;
        }
        return LocalDate.parse(target, dateTimeFormatter);
    }

    @Override
    public LocalDate getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String target = cs.getString(columnIndex);
        if (StrUtil.isEmpty(target)) {
            return null;
        }
        return LocalDate.parse(target, dateTimeFormatter);
    }
}
