                                              **第三次实验**

This my job is realize of the layout

**实验目的：了解4种基本布局**

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
<Button    android:id="@+id/button_21"    
android:layout_width="wrap_content"   
android:layout_height="wrap_content"    
android:layout_gravity="left"    
android:text="Button 3"    />
```

```
<ImageView   
android:layout_width="wrap_content"  
android:layout_height="wrap_content"  
android:layout_gravity="center"  
android:src="@mipmap/ic_launcher"    
/>
```

**output**

![](https://github.com/HelloFool/2018118132_Android/blob/master/第三次作业/photo/FrameLayout.png)

(4)PersentLayout**

**here is main code**

```
<androidx.percentlayout.widget.PercentFrameLayout   
xmlns:android="http://schemas.android.com/apk/res/android"   
xmlns:app="http://schemas.android.com/apk/res-auto"    
android:layout_width="match_parent"   
android:layout_height="match_parent">   
<Button        android:id="@+id/button1"     
android:text="Button 1"       
android:layout_gravity="left|top"     
app:layout_widthPercent="50%"       
app:layout_heightPercent="50%"        />
```

**output**

![](https://github.com/HelloFool/2018118132_Android/blob/master/第三次作业/photo/PercentLayout.png)

**总结：**

**本次实验让我知道所有的控件直接或者间接来自view的，也学习了安卓的基本布局的用法，虽然在这方面的有了很大的进展，但我在这方面也感到很大的困惑让我不知所措，因为在学习四种布局时，书本所采用的仅仅是拿出最简单的控件-按钮作为示范例子，而对于其他控件的摆放，我自己尝试后感到力不从心，虽然在网上能提供大量的数据和方法，但也存在着很大的挑战。**