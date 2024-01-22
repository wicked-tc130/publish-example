package cn.jiguang.sdk.client;

import cn.jiguang.sdk.bean.file.FileGetResult;
import cn.jiguang.sdk.bean.file.FileUploadParam;
import cn.jiguang.sdk.bean.file.FileUploadResult;
import cn.jiguang.sdk.bean.file.FilesGetResult;
import cn.jiguang.sdk.bean.image.*;
import cn.jiguang.sdk.bean.push.PushSendParam;
import cn.jiguang.sdk.bean.push.PushSendResult;
import cn.jiguang.sdk.bean.push.SchedulePushSendParam;
import cn.jiguang.sdk.bean.push.SchedulePushSendResult;
import cn.jiguang.sdk.bean.push.other.CidGetResult;
import cn.jiguang.sdk.bean.push.other.QuotaGetResult;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface PushClient {

    @RequestLine("POST /v3/push")
    @Headers("Content-Type: application/json; charset=utf-8")
    PushSendResult send(PushSendParam param);

    @RequestLine("POST /v3/schedules")
    @Headers("Content-Type: application/json; charset=utf-8")
    SchedulePushSendResult scheduleSend(SchedulePushSendParam param);

    @RequestLine("GET /v3/push/cid?type=push&count={count}")
    @Headers("Content-Type: application/json; charset=utf-8")
    CidGetResult getCidForPush(@Param("count") int count);

    @RequestLine("GET /v3/push/cid?type=schedule&count={count}")
    @Headers("Content-Type: application/json; charset=utf-8")
    CidGetResult getCidForSchedulePush(@Param("count") int count);

    @RequestLine("POST /v3/push/validate")
    @Headers("Content-Type: application/json; charset=utf-8")
    PushSendResult validateSend(PushSendParam param);

    @RequestLine("DELETE /v3/push/{msg_id}")
    @Headers("Content-Type: application/json; charset=utf-8")
    void withdrawMessage(@Param("msg_id") String messageId);

    @RequestLine("GET /v3/push/quota")
    @Headers("Content-Type: application/json; charset=utf-8")
    QuotaGetResult getQuota();

    @RequestLine("POST /v3/push/file")
    @Headers("Content-Type: application/json; charset=utf-8")
    PushSendResult sendByFile(PushSendParam param);

    @RequestLine("POST /v3/files/alias")
    @Headers("Content-Type: multipart/form-data")
    FileUploadResult uploadFileForAlias(FileUploadParam param);

    @RequestLine("POST /v3/files/registration_id")
    @Headers("Content-Type: multipart/form-data")
    FileUploadResult uploadFileForRegistrationId(FileUploadParam param);

    @RequestLine("GET /v3/files")
    @Headers("Content-Type: application/json; charset=utf-8")
    FilesGetResult getFiles();

    @RequestLine("GET /v3/files/{file_id}")
    @Headers("Content-Type: application/json; charset=utf-8")
    FileGetResult getFile(@Param("file_id") String fileId);

    @RequestLine("DELETE /v3/files/{file_id}")
    @Headers("Content-Type: application/json; charset=utf-8")
    void deleteFile(@Param("file_id") String fileId);

    @RequestLine("POST /v3/images/byurls")
    @Headers("Content-Type: application/json; charset=utf-8")
    ImageUrlAddResult addImageUrl(ImageUrlAddParam param);

    @RequestLine("PUT /v3/images/byurls/{media_id}")
    @Headers("Content-Type: application/json; charset=utf-8")
    ImageUrlUpdateResult updateImageUrl(@Param("media_id") String mediaId, ImageUrlUpdateParam param);

    @RequestLine("POST /v3/images/byfiles")
    @Headers("Content-Type: multipart/form-data")
    ImageFileAddResult addImageFile(ImageFileAddParam param);

    @RequestLine("PUT /v3/images/byfiles/{media_id}")
    @Headers("Content-Type: multipart/form-data")
    ImageFileUpdateResult updateImageFile(@Param("media_id") String mediaId, ImageFileUpdateParam param);

}
