package com.bekkostudio.compactWebview;

/*
* Android Smart WebView is an Open Source Project available on GitHub.
* Developed by Ghazi Khan (https://github.com/mgks) under MIT Open Source License.
* This program is free to use for private and commercial purposes.
* Please mention project source or developer credits in your Application's License(s) Wiki.
* Giving right credit to developers encourages them to create better projects, just want you to know that :)
*/

public class DefaultSetting {

	//Permission variables
	public static boolean ASWP_JSCRIPT     = true;     //enable JavaScript for webview
	public static boolean ASWP_FUPLOAD     = true;     //upload file from webview
	public static boolean ASWP_CAMUPLOAD   = true;     //enable upload from camera for photos
	public static boolean ASWP_ONLYCAM		= false;	//incase you want only camera files to upload
	public static boolean ASWP_MULFILE     = false;    //upload multiple files in webview
	public static boolean ASWP_LOCATION    = false;     //track GPS locations
	public static boolean ASWP_RATINGS     = false;     //show ratings dialog; auto configured, edit method get_rating() for customizations
	public static boolean ASWP_PBAR        = true;     //show progress bar in app
	public static boolean ASWP_ZOOM        = false;    //zoom control for webpages view
	public static boolean ASWP_SFORM       = true;    //save form cache and auto-fill information
	public static boolean ASWP_OFFLINE     = false;    //whether the loading webpages are offline or online
	public static boolean ASWP_EXTURL      = false;     //open external url with default browser instead of app webview
	public static boolean ASWP_ROOT			= true;     //Webview activity on root only
	public static boolean ASWP_SPLASH		= true;     //enable splash screen

	//Configuration variables
	public static String ASWV_URL          = "http://bekkostudio.com/"; //complete URL of your website or webpage
	public static String ASWV_F_TYPE       = "*/*";  //to upload any file type using "*/*"; check file type references for more

	//Rating system variables
	public static int ASWR_DAYS            = 3;        //after how many days of usage would you like to show the dialoge
	public static int ASWR_TIMES           = 10;       //overall request launch times being ignored
	public static int ASWR_INTERVAL        = 2;        //reminding users to rate after days interval
}
