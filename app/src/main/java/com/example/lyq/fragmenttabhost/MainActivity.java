package com.example.lyq.fragmenttabhost;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 功能描述：自定义TabHost对象
 **/

public class MainActivity extends FragmentActivity {
    private LayoutInflater layoutInflater; //定义一个布局
    private FragmentTabHost mTabHost;//定义FargmentTabHost对象
    //定义数组存放Fragment界面
    private Class fragmentArray[] = {FragmentHome.class,FragmentMessage.class,FragmentPage3.class,
            FragmentPage4.class,FragmentPage5.class};
    //定义数组来存放按钮图片
    private int mImageViewArray[] = {R.drawable.tab_home_btn,R.drawable.tab_message_btn,
            R.drawable.tab_selfinfo_btn,R.drawable.tab_square_btn,R.drawable.tab_more_btn};
    //Tab选项卡的文字
    private String mTextviewArray[] = {"首页","消息","好友","广场","更多"};
    private TextView title;
    private ImageView add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = (TextView) findViewById(R.id.title);
        add = (ImageView) findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupMenu();
            }
        });
        initView();
    }

    private void showPopupMenu() {
        PopupMenu popupMenu = new PopupMenu(this,add);
        popupMenu.getMenuInflater().inflate(R.menu.add,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {
            @Override
            public void onDismiss(PopupMenu menu) {
                Toast.makeText(getApplicationContext(), "关闭PopupMenu", Toast.LENGTH_SHORT).show();
            }
        });
        popupMenu.show();
    }

    private void initView() {
        layoutInflater = LayoutInflater.from(this);//实例布局对象
        //实例化TabHost对象，得到TabHost
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this,getSupportFragmentManager(),R.id.realtabcontent);//FrameLayout
        int count = fragmentArray.length;//得到fragment的个数
        for (int i=0;i<count;i++){
            //为每一个Tab按钮设置图标、文字和内容
            TabHost.TabSpec tabSpec = mTabHost.newTabSpec(mTextviewArray[i]).setIndicator(getTabItemView(i));
            //将Tab按钮添加进Tab选项卡中
            mTabHost.addTab(tabSpec,fragmentArray[i],null);
            //设置Tab按钮的背景
            mTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.selector_tab_background);
        }
    }
/**
 * 给Tab按钮设置图标和文字
 * */
    private View getTabItemView(int index) {
        View view = layoutInflater.inflate(R.layout.item_tab_view,null);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
        imageView.setImageResource(mImageViewArray[index]);
//        title.setText(mTextviewArray[index]);
        TextView textView = (TextView) view.findViewById(R.id.textview);
        textView.setText(mTextviewArray[index]);
        return view;
    }
}
