####Listener监听器
```
public interface OkListener {
    void onClickOk(View view);
}
```
**必须是公开的且形参为View的方法**
**以便在xml中给android:onClick使用**
####Activity
```
binding.setListener(OkListener);
```
####activity_include.xml
```
<include
    layout="@layout/layout_btn_ok"
    bind:listener2="@{listener}"/>
```
在与```activity_include.xml```对应的Java类中，有一个```setListener```方法吧。
#####layout_btn_ok.xml
```
<Button
    android:onClick="@{listener2.onClickOk}"/>
```
在与```layout_btn_ok.xml```对应的Java类中，有一个```setListener2```方法吧。