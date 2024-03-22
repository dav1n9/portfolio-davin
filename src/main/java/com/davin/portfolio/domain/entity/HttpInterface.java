package com.davin.portfolio.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Arrays;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HttpInterface extends BaseEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "http_interface_id")
    private Long id;
    private String cookies;
    private String referer;
    private String localAddr;
    private String remoteAddr;
    private String remoteHost;
    private String requestUri;
    private String userAgent;

    public HttpInterface(HttpServletRequest httpServletRequest) {
        this.cookies = httpServletRequest.getCookies() == null
                ? null
                : Arrays.stream(httpServletRequest.getCookies())
                .map(c -> c.getName() + ":" + c.getValue())
                .toString();
        this.referer = httpServletRequest.getHeader("referer");
        this.localAddr = httpServletRequest.getLocalAddr();
        this.remoteAddr = httpServletRequest.getRemoteAddr();
        this.remoteHost = httpServletRequest.getRemoteHost();
        this.requestUri = httpServletRequest.getRequestURI();
        this.userAgent = httpServletRequest.getHeader("user-agent");
    }
}