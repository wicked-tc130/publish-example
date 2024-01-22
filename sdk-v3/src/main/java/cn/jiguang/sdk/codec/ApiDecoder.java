package cn.jiguang.sdk.codec;

import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;
import feign.jackson.JacksonDecoder;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.lang.reflect.Type;

@Slf4j
public class ApiDecoder implements Decoder {

    private final JacksonDecoder jacksonDecoder;

    public ApiDecoder() {
        jacksonDecoder = new JacksonDecoder();
    }

    @Override
    public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
        String contentType = response.headers().get("Content-Type").stream().findFirst().orElse(null);
        log.debug("decode contentType:{}", contentType);
        if (contentType == null) {
            return null;
        }
        if (contentType.startsWith("application/json")) {
            return jacksonDecoder.decode(response, type);
        }
        return null;
    }

}
