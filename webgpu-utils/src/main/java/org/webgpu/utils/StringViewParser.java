package org.webgpu.utils;

import jpassport.Passport;
import jpassport.annotations.RefArg;

public interface StringViewParser extends Passport{
    //This is the actual native call
    void passStringToNative(@RefArg StringView str);
}
