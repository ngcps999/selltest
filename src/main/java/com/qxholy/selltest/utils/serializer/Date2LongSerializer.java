/*
 * 日期：2020/1/28 上午10:00
 * 文件名：Date2LongSerializer.java
 * 文件路径：/Users/xuda/Library/Mobile Documents/com~apple~CloudDocs/ideaProject/selltest/src/main/java/com/qxholy/selltest/utils/serializer/Date2LongSerializer.java
 * 项目名称：selltest
 * 模块名称：selltest
 * 作者：xuda
 */

package com.qxholy.selltest.utils.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Date;

/**
 * @Project selltest
 * @Package: com.qxholy.selltest.utils.serializer
 * @Author XuDa
 * @Date 2020/1/28 10:00 上午
 */
public class Date2LongSerializer extends JsonSerializer<Date> {
    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeNumber(date.getTime() / 1000);
    }
}
