package com.victor.sys.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.victor.sys.mapper.AccessTokenMapper;
import com.victor.sys.service.IAccessTokenService;
import com.victor.weixin.entity.results.AccessToken;
import org.springframework.stereotype.Service;

/**
 * <p>
 * </p>
 *
 * @author Victor
 * @since 2017-12-28
 */
@Service
public class AccessTokenServiceImpl extends ServiceImpl<AccessTokenMapper, AccessToken> implements IAccessTokenService {
	
}
