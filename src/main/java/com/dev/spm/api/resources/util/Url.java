package com.dev.spm.api.resources.util;

import com.dev.spm.api.resources.exceptions.DecodeParamException;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class Url {

    public static String decoder(String text) {
        try {
            return URLDecoder.decode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new DecodeParamException(e.getMessage());
        }
    }

}
