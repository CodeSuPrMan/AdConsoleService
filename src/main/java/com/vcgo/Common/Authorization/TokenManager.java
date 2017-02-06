package com.vcgo.Common.Authorization;

import com.vcgo.Entity.VcSysToken;

/**
 * Created by 33469 on 2016/12/19.
 */
public interface TokenManager {
     VcSysToken createToken(long userid);

      VcSysToken getToken(String authentication);

     boolean checkToken(VcSysToken model);

    void  deleteToken(long userid);
}
