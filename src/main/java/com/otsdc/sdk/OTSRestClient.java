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
package com.otsdc.sdk;

import com.otsdc.sdk.resources.IAccountResource;
import com.otsdc.sdk.resources.IEmailResource;
import com.otsdc.sdk.resources.IMessageResource;
import com.otsdc.sdk.resources.IVerifyResource;
import com.otsdc.sdk.resources.IVoiceResource;
import com.otsdc.sdk.resources.url.IOTSUrl;
import com.otsdc.sdk.resources.url.impl.AOTSUrl;
import com.otsdc.sdk.resources.url.impl.HttpOTSUrl;
import com.otsdc.sdk.resources.url.impl.HttpsOTSUrl;

/**
 *
 * @author Eri Setiawan
 */
public class OTSRestClient {

	public static final AOTSUrl HTTP_URL = new HttpOTSUrl();
	public static final AOTSUrl HTTPS_URL = new HttpsOTSUrl();

    private String appSid;
    private IOTSUrl otsUrl;
    private IAccountResource accountResource;
    private IMessageResource messageResource;
    private IVoiceResource voiceResource;
    private IEmailResource emailResource;
    private IVerifyResource verifyResource;
    /**
     * 
     * @param appSid The AppSid
     * @param otsUrl The Url.
     */
    public OTSRestClient(String appSid, IOTSUrl otsUrl) {
        this.appSid = appSid;
        this.otsUrl = otsUrl;
        ResourceFactory resourceFactory = new ResourceFactory(otsUrl);
        accountResource = resourceFactory.makeAccountResource(appSid);
        messageResource = resourceFactory.makeMessageResource(appSid);
        voiceResource = resourceFactory.makeVoiceResource(appSid);
        emailResource = resourceFactory.makeEmailResource(appSid);
        verifyResource = resourceFactory.makeVerifyResource(appSid);
    }
    /**
     * Default connection using HTTPS. this method same as new OTSRestClient(appSid,OTSRestClient.HTTPS_URL)
     * @param appSid the AppSid
     */
    public OTSRestClient(String appSid){
    	this(appSid, HTTP_URL);
    }
    
    public IOTSUrl getOtsUrl() {
		return otsUrl;
	}
	public String getAppSid() {
        return appSid;
    }

    public IAccountResource getAccountResource() {
        return accountResource;
    }

    public IMessageResource getMessageResource() {
        return messageResource;
    }

    public IVoiceResource getVoiceResource() {
        return voiceResource;
    }

    public IEmailResource getEmailResource() {
        return emailResource;
    }

    public IVerifyResource getVerifyResource() {
        return verifyResource;
    }

}
