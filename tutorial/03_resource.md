###strings.xml
```
<resources>
    <plurals name="banana">
        <item quantity="zero">zero bananas</item>
        <item quantity="one">one banana</item>
        <item quantity="two">two bananas</item>
        <item quantity="few">few bananas</item>
        <item quantity="many">many bananas</item>
        <item quantity="other">other bananas</item>
    </plurals>

    <plurals name="orange">
        <item quantity="one">Have an orange</item>
        <item quantity="other">Have %d oranges</item>
    </plurals>
</resources>
```
###activity_resource.xml
```
<layout xmlns:android="http://schemas.android.com/apk/res/android">
    <data class="ResourceBinding">
        <variable name="bananaCount" type="int" />
        <variable name="orangeCount" type="int" />
    </data>
    <LinearLayout
        android:orientation="vertical"
        android:layout_width="match_parent"
        android:layout_height="match_parent">
        <TextView
            android:text="@{@plurals/banana(bananaCount)}"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content" />

        <TextView
            android:text="@{@plurals/orange(orangeCount, orangeCount)}"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content" />
    </LinearLayout>
</layout>
```
###ResourceActivity.java
```
binding.setBananaCount(2);
binding.setOrangeCount(10);
```