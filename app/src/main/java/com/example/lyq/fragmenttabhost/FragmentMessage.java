package com.example.lyq.fragmenttabhost;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FragmentMessage extends Fragment implements ViewPager.OnPageChangeListener, View.OnTouchListener{
	private int[] imgs = new int[]{R.drawable.xianjian01,R.drawable.xianjian02,
			R.drawable.xianjian03,R.drawable.xianjian04,};
//	private String[] des = new String[]{"第一张","第二张","第三张","第四张"};
	private View views;
	private ViewPager viewPager;
	private TextView tvDes;
	private LinearLayout llIndicator;
	private int prePosition = 0;
	private List<Movie> movieList = new ArrayList<>();
    private ScrollView scrollView;

    @Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
		views = inflater.inflate(R.layout.fragment_message,container,false);
		initCarousel();
		initMovie();
		RecyclerView recyclerView = (RecyclerView) views.findViewById(R.id.recycler);
        scrollView = (ScrollView) views.findViewById(R.id.scroll_view);
        scrollView.setVisibility(View.VISIBLE);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
		recyclerView.setLayoutManager(layoutManager);
		MovieAdapter adapter = new MovieAdapter(movieList);
		recyclerView.setAdapter(adapter);
		return views;
	}

	private void initMovie() {
		for (int i = 0; i < 2; i++){
			Movie movie1 = new Movie("电影一","电影二",R.drawable.xianjian01,R.drawable.xianjian01);
			movieList.add(movie1);
			Movie movie2 = new Movie("电影一","电影二",R.drawable.xianjian01,R.drawable.xianjian01);
			movieList.add(movie2);
			Movie movie3 = new Movie("电影一","电影二",R.drawable.xianjian01,R.drawable.xianjian01);
			movieList.add(movie3);
		}
	}

	Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			int currentItemPosition = viewPager.getCurrentItem();
			viewPager.setCurrentItem(currentItemPosition + 1);
			handler.sendEmptyMessageDelayed(1,2000);
		}
	};

	private void initCarousel() {
		viewPager = (ViewPager) views.findViewById(R.id.viewPager);
//		tvDes = (TextView) views.findViewById(R.id.tv_des);
		llIndicator = (LinearLayout) views.findViewById(R.id.ll_indicator);
		viewPager.addOnPageChangeListener(this);
		int midPos = Integer.MAX_VALUE / 2;
		viewPager.setCurrentItem(midPos - midPos % imgs.length);
//		tvDes.setText(des[0]);
		//初始化指示器
		for (int i = 0; i < imgs.length; i++){
			ImageView imageView = new ImageView(getContext());
			imageView.setBackgroundResource(R.drawable.shape_indicator);
			LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(10,10);
			if (i !=0 ){
				layoutParams.leftMargin = 15;
				imageView.setEnabled(false);
			}
			imageView.setLayoutParams(layoutParams);
			llIndicator.addView(imageView);
		}
		viewPager.setAdapter(new BannerAdapter());//调用适配器
		handler.sendEmptyMessageDelayed(1,2000);
		viewPager.setOnTouchListener(this);//设置触摸监听
	}

	@Override
	public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

	}

	/**
	 * ViewPage页面改变，处理指示器，描述信息
	 * @param position
	 */
	@Override
	public void onPageSelected(int position) {
		int pos = position % imgs.length;
//		tvDes.setText(des[pos]);
//        Log.e("EE", "onPageSelected: "+pos+"    "+llIndicator.getChildCount() );
		llIndicator.getChildAt(pos).setEnabled(true);
		llIndicator.getChildAt(prePosition).setEnabled(false);
		prePosition = pos;
	}

	@Override
	public void onPageScrollStateChanged(int state) {

	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		switch (event.getAction()){
			case MotionEvent.ACTION_DOWN:     //手指按下
				handler.removeCallbacksAndMessages(null);
				break;
			case MotionEvent.ACTION_MOVE:    //手指移动

				break;
			case MotionEvent.ACTION_UP:    //手指抬起
				handler.sendEmptyMessageDelayed(1,2000);    //发送空的延迟消息去轮播
				break;
		}
		//返回值True自己消费事件,对ViewPage没有返回值，返回False
		return false;
	}

	private class BannerAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return Integer.MAX_VALUE;
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view == object;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			int pos = position % imgs.length;
			ImageView imageView = new ImageView(getContext());
			imageView.setBackgroundResource(imgs[pos]);
			container.addView(imageView);
			return imageView;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}
	}
}