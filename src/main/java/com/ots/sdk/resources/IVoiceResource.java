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
package com.ots.sdk.resources;

import com.ots.sdk.model.call.CallRequest;
import com.ots.sdk.model.call.CallResponse;
import com.ots.sdk.model.call.CallStatusResponse;
import com.ots.sdk.model.call.CallsDetailsRequest;
import com.ots.sdk.model.call.CallsDetailsResponse;
import com.ots.sdk.model.call.TTSCallRequest;
import com.ots.sdk.model.call.TTSCallResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Voice sub-resource is used to make calls, Text-To-Speech calls and to inquire
 * sent message details
 *
 * @author Eri Setiawan
 */
public interface IVoiceResource extends IResource {

    public static final String URL_VOICE = URL_BASE_PROD + "Voice/";
    public static final String URL_CALL = URL_VOICE + "Call";
    public static final String URL_GET_CALL_ID_STATUS = URL_VOICE + "GetCallIDStatus";
    public static final String URL_GET_CALLS_DETAILS = URL_VOICE + "GetCallsDetails";
    public static final String URL_TTS_CALL = URL_VOICE + "TTSCall";

    public CallResponse call(CallRequest request) throws IOException;

    public CallResponse call(Map<String, String> param) throws IOException;

    public CallStatusResponse getCallIDStatus(String callID) throws IOException;

    public CallStatusResponse getCallIDStatus(Map<String, String> param) throws IOException;

    public CallsDetailsResponse getCallsDetails() throws IOException;

    public CallsDetailsResponse getCallsDetails(CallsDetailsRequest request) throws IOException;

    public CallsDetailsResponse getCallsDetails(Map<String, String> param) throws IOException;

    public TTSCallResponse ttsCall(TTSCallRequest request) throws IOException;

    public TTSCallResponse ttsCall(Map<String, String> param) throws IOException;
}
