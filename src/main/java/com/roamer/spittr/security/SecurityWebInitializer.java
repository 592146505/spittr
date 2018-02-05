package com.roamer.spittr.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * 用于注册DelegatingFilterProxy
 * <p>
 * AbstractSecurityWebApplicationInitializer实现了
 * WebApplicationInitializer，因此Spring会发现它，并用它
 * 在Web容器中注册DelegatingFilterProxy
 * </p>
 *
 * @author roamer
 * @version V1.0
 * @date 2018/1/17
 */
public class SecurityWebInitializer extends AbstractSecurityWebApplicationInitializer {
}
