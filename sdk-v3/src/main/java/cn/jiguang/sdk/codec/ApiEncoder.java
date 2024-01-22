package cn.jiguang.sdk.codec;

import feign.RequestTemplate;
import feign.codec.EncodeException;
import feign.codec.Encoder;
import feign.form.FormEncoder;
import feign.jackson.JacksonEncoder;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Type;

@Slf4j
public class ApiEncoder implements Encoder {

    private final FormEncoder formEncoder;
    private final JacksonEncoder jacksonEncoder;

    public ApiEncoder() {
        formEncoder = new FormEncoder();
        jacksonEncoder = new JacksonEncoder();
    }

    @Override
    public void encode(Object object, Type bodyType, RequestTemplate template) throws EncodeException {
        String contentType = template.headers().get("Content-Type").stream().findFirst().orElse(null);
        log.debug("encode contentType:{}", contentType);
        if (contentType == null) {
            return;
        }
        if (contentType.startsWith("multipart/form-data")) {
            formEncoder.encode(object, bodyType, template);
            return;
        }
        if (contentType.startsWith("application/json")) {
            jacksonEncoder.encode(object, bodyType, template);
        }
    }

}
