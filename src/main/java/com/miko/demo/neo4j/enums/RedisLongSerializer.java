package com.miko.demo.neo4j.enums;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/*
 * The MIT License
 *
 * Copyright 2014 Miroslav Kopecky.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

/**
 * Created with IntelliJ IDEA.
 * User: miroslavkopecky
 * Date: 1/2/14
 */
public enum RedisLongSerializer  implements RedisSerializer<Long> {
    INSTANCE;

    @Override
    public byte[] serialize(Long aLong) throws SerializationException {
        if ( null != aLong ) {
            return aLong.toString().getBytes();
        } else {
            return new byte[0];
        }
    }

    @Override
    public Long deserialize(byte[] bytes) throws SerializationException {
        if ( bytes.length > 0 ) {
            return Long.parseLong( new String( bytes ) );
        } else {
            return null;
        }
    }
}