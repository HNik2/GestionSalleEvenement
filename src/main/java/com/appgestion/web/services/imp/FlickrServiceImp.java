package com.appgestion.web.services.imp;

import java.io.InputStream;

import org.springframework.transaction.annotation.Transactional;

import com.appgestion.web.dao.IFlickrDao;
import com.appgestion.web.services.IFlickrService;

@Transactional
public class FlickrServiceImp implements IFlickrService{
	
	private IFlickrDao dao;
	
	public void setDao(IFlickrDao dao) {
		this.dao = dao;
	}

	@Override
	public String savePhoto(InputStream photo, String title) throws Exception {
		return dao.savePhoto(photo, title);
	}

}
