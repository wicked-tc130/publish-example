package cn.jiguang.sdk.client;

import cn.jiguang.sdk.bean.admin.*;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface AdminClient {

    @RequestLine("POST v1/app")
    @Headers("Content-Type: application/json; charset=utf-8")
    AppCreateResult createApp(AppCreateParam param);

    @RequestLine("POST v1/app/{app_key}/delete")
    @Headers("Content-Type: application/json; charset=utf-8")
    AppDeleteResult deleteApp(@Param("app_key") String appKey);

    @RequestLine("POST v1/app/{app_key}/certificate")
    @Headers("Content-Type: multipart/form-data")
    CertificateUploadResult uploadCertificate(@Param("app_key") String appKey, CertificateUploadParam param);

}
