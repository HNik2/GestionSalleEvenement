package com.appgestion.web.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

import org.springframework.util.StringUtils;

public class ApplicationUtils {

	private ApplicationUtils(){}
	
	public static void changeLocale(HttpServletRequest request, HttpServletResponse response, String locale) {
		LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
		localeResolver.setLocale(request, response, StringUtils.parseLocaleString(locale));
	}
}
