/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 OTS
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
package com.unifonic.sdk.resources.http;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.unifonic.sdk.OTSRestResponse;
import com.unifonic.sdk.constant.ParamConstant;
import com.unifonic.sdk.model.ResponseModel;
import com.unifonic.sdk.model.call.CallRequest;
import com.unifonic.sdk.model.call.CallResponse;
import com.unifonic.sdk.model.call.CallStatusResponse;
import com.unifonic.sdk.model.call.CallsDetailsRequest;
import com.unifonic.sdk.model.call.CallsDetailsResponse;
import com.unifonic.sdk.model.call.TTSCallRequest;
import com.unifonic.sdk.model.call.TTSCallResponse;
import com.unifonic.sdk.parser.serialize.DateConverter;
import com.unifonic.sdk.resources.AResource;
import com.unifonic.sdk.resources.IVoiceResource;
import com.unifonic.sdk.resources.url.IVoiceUrl;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.HttpResponseException;

/**
 *
 * @author Eri Setiawan
 */
public class VoiceResourceImpl extends AResource implements IVoiceResource {

    private Gson GSON;
    private IVoiceUrl voiceUrl;
    public VoiceResourceImpl(String appSid, IVoiceUrl voiceUrl) {
        super(appSid);
    	this.voiceUrl = voiceUrl;
    	GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Date.class, new DateConverter());
        GSON = gsonBuilder.create();
    }

    @Override
    public CallResponse call(CallRequest request) throws IOException {
        return call(request.getData());
    }

    @Override
    public CallResponse call(Map<String, String> param) throws IOException {
        OTSRestResponse response = sendRequest(voiceUrl.urlCall(), param);
        if (response.getStatusCode() < 400) {
            Type type = new TypeToken<ResponseModel<CallResponse>>() {
            }.getType();
            ResponseModel<CallResponse> respData = GSON.fromJson(response.getData(), type);
            return respData.create();
        } else if (response.getStatusCode() == 400) {
            CallResponse resp = GSON.fromJson(response.getData(), CallResponse.class);
            return resp;
        } else {
            throw new HttpResponseException(response.getStatusCode(), response.getReasonPhrase());
        }
    }

    @Override
    public CallStatusResponse getCallIDStatus(String callID) throws IOException {
        Map<String, String> map = new HashMap<String, String>(2);
        map.put(ParamConstant.CALLID, callID);
        return getCallIDStatus(map);
    }

    @Override
    public CallStatusResponse getCallIDStatus(Map<String, String> param) throws IOException {
        OTSRestResponse response = sendRequest(voiceUrl.urlGetCallIDStatus(), param);
        if (response.getStatusCode() < 400) {
            Type type = new TypeToken<ResponseModel<CallStatusResponse>>() {
            }.getType();
            ResponseModel<CallStatusResponse> respData = GSON.fromJson(response.getData(), type);
            return respData.create();
        } else if (response.getStatusCode() == 400) {
            CallStatusResponse resp = GSON.fromJson(response.getData(), CallStatusResponse.class);
            return resp;
        } else {
            throw new HttpResponseException(response.getStatusCode(), response.getReasonPhrase());
        }
    }

    @Override
    public CallsDetailsResponse getCallsDetails(CallsDetailsRequest request) throws IOException {
        return getCallsDetails(request.getData());
    }

    @Override
    public CallsDetailsResponse getCallsDetails(Map<String, String> param) throws IOException {
        OTSRestResponse response = sendRequest(voiceUrl.urlGetCallsDetails(), param);
        if (response.getStatusCode() < 400) {
            Type type = new TypeToken<ResponseModel<CallsDetailsResponse>>() {
            }.getType();
            ResponseModel<CallsDetailsResponse> respData = GSON.fromJson(response.getData(), type);
            return respData.create();
        } else if (response.getStatusCode() == 400) {
            CallsDetailsResponse resp = GSON.fromJson(response.getData(), CallsDetailsResponse.class);
            return resp;
        } else {
            throw new HttpResponseException(response.getStatusCode(), response.getReasonPhrase());
        }
    }

    @Override
    public TTSCallResponse ttsCall(TTSCallRequest request) throws IOException {
        return ttsCall(request.getData());
    }

    @Override
    public TTSCallResponse ttsCall(Map<String, String> param) throws IOException {
        OTSRestResponse response = sendRequest(voiceUrl.urlTTSCall(), param);
        if (response.getStatusCode() < 400) {
            Type type = new TypeToken<ResponseModel<TTSCallResponse>>() {
            }.getType();
            ResponseModel<TTSCallResponse> respData = GSON.fromJson(response.getData(), type);
            return respData.create();
        } else if (response.getStatusCode() == 400) {
            TTSCallResponse resp = GSON.fromJson(response.getData(), TTSCallResponse.class);
            return resp;
        } else {
            throw new HttpResponseException(response.getStatusCode(), response.getReasonPhrase());
        }
    }

    @Override
    public CallsDetailsResponse getCallsDetails() throws IOException {
        return getCallsDetails(new HashMap<String, String>());
    }

}
