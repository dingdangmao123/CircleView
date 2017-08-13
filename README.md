# CircleView
a simple android circle view


![CircleView](/snap/demo.PNG)


some attrs

* `width` - the width of the outer arc
* `mTitle` - main title
* `subtitle` - sub title under main title
* `msize` - the size of main title
* `mcolor` - the color of main title
* `subColor` - the color of sub title
* `subSize` - the size of sub title
* `outRadius` - the radius of the outer circle
* `innerRadius` - thee radius of the inner circle
* `outColor` - the color of the outer circle
* `innerColor` - the color of the inner circle


# example

```xml
<com.dingdangmao.circleview.CircleView
        android:id="@+id/cv"
        app:width="15dp"
        app:mTitle="25%"
        app:mSize="40sp"
        app:mColor="#FFFFFF"
        app:subTitle="hello"
        app:subColor="#FFFFFF"
        app:subSize="20sp"
        app:outRadius="120dp"
        app:innerRadius="80dp"
        app:outColor="@color/out"
        app:innerColor="@color/inner"
        android:background="#FFFFFF"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
```






