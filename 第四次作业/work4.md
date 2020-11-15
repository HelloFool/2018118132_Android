                                                **第四次实验报告**

实验目的：理解和掌握ListView和RecycleView的使用

*具体操作如下*

**1.ListView**

**（1）首先在布局实现ListView控件**

      <com.example.myapplication.TitleLayout
           android:layout_width="match_parent"
           android:layout_height="wrap_content"/>
**（2）整理好要实现的数据，并且构建配置器对象**

 initFruits();

 FruitAdapter adapter=new FruitAdapter(SecondActivity.this,R.layout.fruit_item,fruitLst);

**（3）实现代码优化**

  if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();

​            viewHolder.fruitImage = (ImageView) view.findViewById (R.id.fruit_image);

​            viewHolder.fruitName = (TextView) view.findViewById (R.id.fruit_name);

​            view.setTag(viewHolder); // 将ViewHolder存储在View中

​        } else {
​            view = convertView;

​            viewHolder = (ViewHolder) view.getTag(); // 重新获取ViewHolder

​        }
​        viewHolder.fruitImage.setImageResource(fruit.getImageId());

​        viewHolder.fruitName.setText(fruit.getName());

​        return view;

​    }

**（4）实现点击事件**

      listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
    
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Fruit fruit=fruitLst.get(position);
                Toast.makeText(SecondActivity.this,fruit.getBrith(),Toast.LENGTH_SHORT).show();
            }
        });

**实验结果如下所示**

![](https://github.com/HelloFool/2018118132_Android/blob/master/第四次作业/photo/ListView0.png)

![](https://github.com/HelloFool/2018118132_Android/blob/master/第四次作业/photo/ListView1.jpg)

![](https://github.com/HelloFool/2018118132_Android/blob/master/第四次作业/photo/ListView2.jpg)

**2.RecycleView**

**（1）实现布局操作**

   <androidx.recyclerview.widget.RecyclerView
       android:id="@+id/recycler_view"
       android:layout_width="match_parent"
       android:layout_height="match_parent"/>

**（2）在主类实现适配器的配置**

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder>{}

**（3）在主类将数据传递给适配器**

**（4）实现瀑布布局**

**实验结果**

![](https://github.com/HelloFool/2018118132_Android/blob/master/第四次作业/photo/RecycleView0.jpg)

![]( [https://github.com/HelloFool/2018118132_Android/blob/master/%E7%AC%AC%E5%9B%9B%E6%AC%A1%E4%BD%9C%E4%B8%9A/photo/RecycleView1.jpg](https://github.com/HelloFool/2018118132_Android/blob/master/第四次作业/photo/RecycleView1.jpg) )

**总结**

**经过本次实验，让我更加体会到安卓界面布局功能的多样和强大，也对其具体的代码实现有了个基本的了解，但也存在着很多问题，例如对适配器的使用不能很好的掌握和运用。希望在今后的学习中能够不断进步。**

