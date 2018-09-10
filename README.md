# Android-SmartWebView Compact
Disclaimer: This is a module version of Android-SmartWebView which can be found in here: https://github.com/mgks/Android-SmartWebView.

I Do not own the whole code. I only make the original code more compact and ready to use as android module.

## Original Library Overview:
This project is developed to help you create Hybrid Android applications with just webview. Hybrid app comes in between webview and native forms, with this project you can embed any existing webpage or setup an Offline HTML/CSS/Javascript based project.

Android Smart WebView gathers all necessary information needed to make any simple app as powerful as a native Android app. This project takes only required data from device to obtain information, including, GPS Location, File Manager, Camera for Processing Images, Custom Dialogues, Notifications and more with clean minimal design.


## Quick Start
If you want to simply implement a webview through this project, you can try to import the module and use it directly in your project Activity (Like MainActivity). Follow this step for a quick start:

### STEP 1 : Import Module in your project
* Create your New Android Studio Project.
* Click File > New > Import Module.
* Enter the location of the module directory (SmartWebView Folder) then click Finish.
* Make sure the library is listed at the top of your settings.gradle file, as shown here 
```
include ':app',':SmartWebView'
```
* Open the app module's build.gradle file and add a new line to the dependencies block as shown in the following snippet:
```
dependencies {
    implementation project(":SmartWebView")
}
```
* Click Sync Project with Gradle Files.

Learn more about adding android library as depedency here: https://developer.android.com/studio/projects/android-library#AddDependency

### STEP 2 : Manifest Permission

Put this permission in your manifest
```xml
    <!--
        Remove permissions that your app doesn't require, asking for authority over unwanted information can cause damage to your reputation among your users
    -->
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.CAMERA" />
    <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
    <uses-permission android:name="android.permission.VIBRATE" />

    <!-- remove location.gps feature if not using permission ACCESS_FINE_LOCATION -->
    <uses-feature android:name="android.hardware.location.gps" />
    <uses-feature android:name="android.hardware.touchscreen" android:required="false" />
```

### STEP 3 : XML Layout Implementation
Your XML Layout (activity_main.xml) should look like this:

activity_main.xml
 ```xml
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <WebView
        android:id="@+id/msw_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
    <ProgressBar
        android:id="@+id/msw_progress"
        style="@android:style/Widget.ProgressBar.Horizontal"
        android:layout_width="fill_parent"
        android:layout_height="7dip"
        android:progressDrawable="@drawable/progress_style"
        android:layout_alignParentBottom="true"
        android:layout_alignParentStart="true"
        android:layout_alignParentLeft="true"
        android:visibility="visible" />
</RelativeLayout>
```

### STEP 4 : Java Implementation
Put this code in your MainActivity

MainActivity.java
```java
public class MainActivity extends AppCompatActivity {

    SmartWebViewCompact smartWebViewCompact = new SmartWebViewCompact();

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        smartWebViewCompact.onActivityResult(requestCode, resultCode, intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Permission variables
        SmartWebView.ASWP_JSCRIPT     = true;     //enable JavaScript for webview
        SmartWebView.ASWP_FUPLOAD     = true;     //upload file from webview
        SmartWebView.ASWP_CAMUPLOAD   = true;     //enable upload from camera for photos
        SmartWebView.ASWP_ONLYCAM		= false;	//incase you want only camera files to upload
        SmartWebView.ASWP_MULFILE     = false;    //upload multiple files in webview
        SmartWebView.ASWP_LOCATION    = false;     //track GPS locations
        SmartWebView.ASWP_RATINGS     = false;     //show ratings dialog; auto configured, edit method get_rating() for customizations
        SmartWebView.ASWP_PBAR        = true;     //show progress bar in app
        SmartWebView.ASWP_ZOOM        = false;    //zoom control for webpages view
        SmartWebView.ASWP_SFORM       = true;    //save form cache and auto-fill information
        SmartWebView.ASWP_OFFLINE     = false;    //whether the loading webpages are offline or online
        SmartWebView.ASWP_EXTURL      = false;     //open external url with default browser instead of app webview

        //Configuration variables
        SmartWebView.ASWV_URL          = "https://m.facebook.com"; //complete URL of your website or webpage
        SmartWebView.ASWV_F_TYPE       = "*/*";  //to upload any file type using "*/*"; check file type references for more

        //Rating system variables
        SmartWebView.ASWR_DAYS            = 3;        //after how many days of usage would you like to show the dialoge
        SmartWebView.ASWR_TIMES           = 10;       //overall request launch times being ignored
        SmartWebView.ASWR_INTERVAL        = 2;        //reminding users to rate after days interval

        smartWebViewCompact.onCreate(this,(WebView) findViewById(R.id.msw_view),(ProgressBar) findViewById(R.id.msw_progress));
    }

    @Override
    public void onBackPressed() {
        smartWebViewCompact.onBackPressed();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState ){
        super.onSaveInstanceState(outState);
        smartWebViewCompact.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        smartWebViewCompact.onRestoreInstanceState(savedInstanceState);
    }
}

```
