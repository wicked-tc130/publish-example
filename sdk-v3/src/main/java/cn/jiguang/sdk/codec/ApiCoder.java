package cn.jiguang.sdk.codec;

public class ApiCoder {

    private static ApiEncoder apiEncoder;
    private static ApiDecoder apiDecoder;
    private static ApiErrorDecoder apiErrorDecoder;

    public static ApiEncoder getEncoder() {
        if (apiEncoder != null) {
            return apiEncoder;
        }
        apiEncoder = new ApiEncoder();
        return apiEncoder;
    }

    public static ApiDecoder getDecoder() {
        if (apiDecoder != null) {
            return apiDecoder;
        }
        apiDecoder = new ApiDecoder();
        return apiDecoder;
    }

    public static ApiErrorDecoder getErrorDecoder() {
        if (apiErrorDecoder != null) {
            return apiErrorDecoder;
        }
        apiErrorDecoder = new ApiErrorDecoder();
        return apiErrorDecoder;
    }

}
