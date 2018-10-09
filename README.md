# Android-SmartWebView Compact
Disclaimer: This is a module version of Android-SmartWebView which can be found in here: https://github.com/mgks/Android-SmartWebView.

I Do not own the whole code. I only make the original code more compact and ready to use as android module.

## Original Library Overview:
This project is developed to help you create Hybrid Android applications with just webview. Hybrid app comes in between webview and native forms, with this project you can embed any existing webpage or setup an Offline HTML/CSS/Javascript based project.

Android Smart WebView gathers all necessary information needed to make any simple app as powerful as a native Android app. This project takes only required data from device to obtain information, including, GPS Location, File Manager, Camera for Processing Images, Custom Dialogues, Notifications and more with clean minimal design.


## Quick Start
If you want to simply implement a webview through this project, you can try to import the module and use it directly in your project Activity (Like MainActivity). Follow this step for a quick start:

### STEP 1 : Import Module in your project
* Clone or download this repository through this link: https://github.com/jialingkun/SmartWebViewCompact/archive/master.zip
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
Assuming that you start fresh project with only activity_main.xml
Your XML Layout should look like this:

activity_main.xml
 ```xml
<?xml version="1.0" encoding="utf-8"?>
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

    <RelativeLayout
        android:id="@+id/logosplash"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="#ffffff"
        android:visibility="gone">
        <ImageView
            android:id="@+id/centerlogo"
            android:layout_width="250dp"
            android:layout_height="250dp"
            android:layout_centerInParent="true"
            android:src="@drawable/logo"/>
    </RelativeLayout>

    <ProgressBar
        android:id="@+id/msw_progress"
        style="@android:style/Widget.ProgressBar.Horizontal"
        android:layout_width="fill_parent"
        android:layout_height="6dip"
        android:progressDrawable="@drawable/progress_style"
        android:layout_alignParentBottom="true"
        android:layout_alignParentStart="true"
        android:layout_alignParentLeft="true"
        android:visibility="visible" />

</RelativeLayout>
```

### STEP 4 : Java Implementation
Assuming that you start fresh project with only MainActivity.java
Put this code in your Activity

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
        smartWebViewCompact.ASWP_JSCRIPT     = true;     //enable JavaScript for webview
        smartWebViewCompact.ASWP_FUPLOAD     = true;     //upload file from webview
        smartWebViewCompact.ASWP_CAMUPLOAD   = true;     //enable upload from camera for photos
        smartWebViewCompact.ASWP_ONLYCAM     = false;   //incase you want only camera files to upload
        smartWebViewCompact.ASWP_MULFILE     = false;    //upload multiple files in webview
        smartWebViewCompact.ASWP_LOCATION    = false;     //track GPS locations
        smartWebViewCompact.ASWP_RATINGS     = false;     //show ratings dialog; auto configured, edit method get_rating() for customizations
        smartWebViewCompact.ASWP_PBAR        = true;     //show progress bar in app
        smartWebViewCompact.ASWP_ZOOM        = false;    //zoom control for webpages view
        smartWebViewCompact.ASWP_SFORM       = true;    //save form cache and auto-fill information
        smartWebViewCompact.ASWP_OFFLINE     = false;    //whether the loading webpages are offline or online
        smartWebViewCompact.ASWP_EXTURL      = true;     //open external url with default browser instead of app webview
        smartWebViewCompact.ASWP_ROOT        = true;    //False if you need to use webview in other intent activity
        smartWebViewCompact.ASWP_SPLASH      = true;    //enable splash screen

        //Configuration variables
        smartWebViewCompact.ASWV_URL          = "https://google.com"; //complete URL of your website or webpage
        smartWebViewCompact.ASWV_F_TYPE       = "*/*";  //to upload any file type using "*/*"; check file type references for more

        //Rating system variables
        DefaultSetting.ASWR_DAYS            = 3;        //after how many days of usage would you like to show the dialoge
        DefaultSetting.ASWR_TIMES           = 10;       //overall request launch times being ignored
        DefaultSetting.ASWR_INTERVAL        = 2;        //reminding users to rate after days interval

        WebView webView = (WebView) findViewById(R.id.msw_view);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.msw_progress);
        RelativeLayout splashScreen = (RelativeLayout) findViewById(R.id.logosplash); //logosplash
        smartWebViewCompact.onCreate(this,webView,progressBar,splashScreen);
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



### Implement inside fragment
If you need to put a webview inside fragment, try this code in your Fragment Java Class

FragmentActivity.java
```java
public class FragmentActivity extends Fragment {
    SmartWebViewCompact smartWebViewCompact = new SmartWebViewCompact();

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        smartWebViewCompact.onActivityResult(requestCode, resultCode, data);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment, container, false);

        //Permission variables
        smartWebViewCompact.ASWP_JSCRIPT     = true;     //enable JavaScript for webview
        smartWebViewCompact.ASWP_FUPLOAD     = true;     //upload file from webview
        smartWebViewCompact.ASWP_CAMUPLOAD   = true;     //enable upload from camera for photos
        smartWebViewCompact.ASWP_ONLYCAM        = false;    //incase you want only camera files to upload
        smartWebViewCompact.ASWP_MULFILE     = false;    //upload multiple files in webview
        smartWebViewCompact.ASWP_LOCATION    = false;     //track GPS locations
        smartWebViewCompact.ASWP_RATINGS     = false;     //show ratings dialog; auto configured, edit method get_rating() for customizations
        smartWebViewCompact.ASWP_PBAR        = true;     //show progress bar in app
        smartWebViewCompact.ASWP_ZOOM        = false;    //zoom control for webpages view
        smartWebViewCompact.ASWP_SFORM       = true;    //save form cache and auto-fill information
        smartWebViewCompact.ASWP_OFFLINE     = false;    //whether the loading webpages are offline or online
        smartWebViewCompact.ASWP_EXTURL      = false;     //open external url with default browser instead of app webview
        smartWebViewCompact.ASWP_ROOT        = true;    //False if you need to use webview in other intent activity
        smartWebViewCompact.ASWP_SPLASH      = false;    //enable splash screen

        //Configuration variables
        smartWebViewCompact.ASWV_URL          = "https://google.com/"; //complete URL of your website or webpage
        smartWebViewCompact.ASWV_F_TYPE       = "*/*";  //to upload any file type using "*/*"; check file type references for more

        //Rating system variables
        DefaultSetting.ASWR_DAYS            = 3;        //after how many days of usage would you like to show the dialoge
        DefaultSetting.ASWR_TIMES           = 10;       //overall request launch times being ignored
        DefaultSetting.ASWR_INTERVAL        = 2;        //reminding users to rate after days interval

        WebView webView = (WebView) view.findViewById(R.id.msw_view);
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.msw_progress);
        RelativeLayout splashScreen = (RelativeLayout) view.findViewById(R.id.logosplash); //logosplash
        smartWebViewCompact.onCreate(getActivity(),webView,progressBar,splashScreen);

        return view;
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        smartWebViewCompact.onSaveInstanceState(outState);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            smartWebViewCompact.onRestoreInstanceState(savedInstanceState);
        }
    }
}
```

Note: OnBackPressed function currently not supported inside Fragment. Try a workaround by calling the method inside activity that has the fragment.
