package com.appgestion.web.dao.imp;

import java.io.InputStream;

import javax.swing.JOptionPane;

import org.scribe.model.Token;
import org.scribe.model.Verifier;

import com.appgestion.web.dao.IFlickrDao;
import com.flickr4java.flickr.Flickr;
import com.flickr4java.flickr.FlickrException;
import com.flickr4java.flickr.REST;
import com.flickr4java.flickr.RequestContext;
import com.flickr4java.flickr.auth.Auth;
import com.flickr4java.flickr.auth.AuthInterface;
import com.flickr4java.flickr.auth.Permission;
import com.flickr4java.flickr.uploader.UploadMetaData;

public class FlickrDaoImp implements IFlickrDao{
	
	private Flickr flickr;

    private UploadMetaData uploadMetaData = new UploadMetaData();

    private String apiKey = "423b51d674c097427f9128faf1a9415e";

    private String sharedSecret = "43326b71d5aa3ec8";


    private void connect(){
        flickr = new Flickr(apiKey, sharedSecret, new REST());
        Auth auth = new Auth();
        auth.setPermission(Permission.READ);
        auth.setToken("72157689391129833-183bdee704f1b43b");
        auth.setTokenSecret("b19b337ecb91d0fa");
        RequestContext requestContext = RequestContext.getRequestContext();
        requestContext.setAuth(auth);
        flickr.setAuth(auth);
    }

    @Override
    public String savePhoto(InputStream photo, String title) throws Exception{
        connect();
        uploadMetaData.setTitle(title);
        String photoId = flickr.getUploader().upload(photo, uploadMetaData);
        return flickr.getPhotosInterface().getPhoto(photoId).getMedium640Url();
    }
    

    public void auth(){
        flickr = new Flickr(apiKey, sharedSecret, new REST());

        AuthInterface authInterface = flickr.getAuthInterface();

        Token token = authInterface.getRequestToken();
        System.out.println("token: " + token);

        String url = authInterface.getAuthorizationUrl(token, Permission.DELETE);
        System.out.println("Follow this URL to authorise yourself on Flickr");
        System.out.println(url);
        System.out.println("Paste in the token it gives you:");
        System.out.print(">>");

        String tokenKey = JOptionPane.showInputDialog(null);

        Token requestToken = authInterface.getAccessToken(token, new Verifier(tokenKey));
        System.out.println("Authentication success");

        Auth auth = null;
        try {
            auth = authInterface.checkToken(requestToken);
        } catch (FlickrException e) {
            e.printStackTrace();
        }

        // This token can be used until the user revokes it.
        System.out.println("Token: " + requestToken.getToken());
        System.out.println("Secret: " + requestToken.getSecret());
        System.out.println("nsid: " + auth.getUser().getId());
        System.out.println("Realname: " + auth.getUser().getRealName());
        System.out.println("Username: " + auth.getUser().getUsername());
        System.out.println("Permission: " + auth.getPermission().getType());

    }

}
