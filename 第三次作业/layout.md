This my job is realize of the layout

**(1)LinearLayout**

**here is main code**

```
 android:orientation="horizontal"   
 <Button    
 android:id="@+id/button_2" 
 android:layout_width="wrap_content"
 android:layout_height="wrap_content"        android:layout_gravity="center_vertical"  
 android:text="Button 2" />    
 <Button       
 android:id="@+id/button_21"       
 android:layout_width="wrap_content"        android:layout_height="wrap_content"   
 android:layout_gravity="top"     
 android:text="Button 3"      
 />   
 <Button      
 android:id="@+id/button_22" 
 android:layout_width="wrap_content"   
 android:layout_height="wrap_content" 
 android:layout_gravity="bottom"  
 android:text="Button 4"    /></LinearLayout>
```

**output**

![](https://github.com/HelloFool/2018118132_Android/blob/master/第三次作业/photo/LinearLayout.png)







**(2)RelativeLayout**

**here is main code**

```
android:layout_centerInParent="true"
```

**output**

![](https://github.com/HelloFool/2018118132_Android/blob/master/第三次作业/photo/RelativeLayout.png)

****

**(3)FrameLayout**

**here is main code**

```
<Button    android:id="@+id/button_21"    android:layout_width="wrap_content"    android:layout_height="wrap_content"    android:layout_gravity="left"    android:text="Button 3"    />
```

```
<ImageView    android:layout_width="wrap_content"    android:layout_height="wrap_content"    android:layout_gravity="center"    android:src="@mipmap/ic_launcher"        />
```

**output**

![](https://github.com/HelloFool/2018118132_Android/blob/master/第三次作业/photo/FrameLayout.png)

(4)PersentLayout**

**here is main code**

```
<androidx.percentlayout.widget.PercentFrameLayout    xmlns:android="http://schemas.android.com/apk/res/android"    xmlns:app="http://schemas.android.com/apk/res-auto"    android:layout_width="match_parent"    android:layout_height="match_parent">    <Button        android:id="@+id/button1"        android:text="Button 1"        android:layout_gravity="left|top"        app:layout_widthPercent="50%"        app:layout_heightPercent="50%"        />
```

**output**

![](https://github.com/HelloFool/2018118132_Android/blob/master/第三次作业/photo/PercentLayout.png)