package com.example.recyclerviewdemo;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.example.recyclerviewdemo.Utils.LayoutManager.FullyGridLayoutManager;
import com.example.recyclerviewdemo.Utils.decoration.GridItemDecoration;
import com.example.recyclerviewdemo.Utils.decoration.RecycleViewItemLine;
import com.example.recyclerviewdemo.adapter.QuickAdapter;
import com.example.recyclerviewdemo.mvp.BaseActivity;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;
import me.jessyan.autosize.utils.AutoSizeUtils;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

public class MainActivity extends BaseActivity {


    @BindView(R.id.tv_title_left)
    TextView tvTitleLeft;
    @BindView(R.id.iv_title_left)
    ImageView ivTitleLeft;
    @BindView(R.id.fl_title_left)
    FrameLayout flTitleLeft;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.iv_title_menu)
    ImageView ivTitleMenu;
    @BindView(R.id.fl_title_menu)
    FrameLayout flTitleMenu;
    @BindView(R.id.iv_title_right)
    ImageView ivTitleRight;
    @BindView(R.id.fl_title_right)
    FrameLayout flTitleRight;
    @BindView(R.id.tv_title_right)
    TextView tvTitleRight;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    /**
     *  不初始化scrollView，  recyclerView不会记住位置
     */
    @BindView(R.id.scrollView)
    NestedScrollView scrollView;

    private List<String> imagesUrl;
    private List<String> arrayStr;
    private QuickAdapter quickAdapter;


    @Override
    public int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        toolbarTitle.setText( "我的书架" );
        ivTitleLeft.setImageResource( R.drawable.icon_nav );
        ivTitleMenu.setImageResource( R.drawable.icon_more );
        ivTitleRight.setImageResource( R.drawable.icon_search );
        flTitleLeft.setVisibility( View.VISIBLE );
        flTitleMenu.setVisibility( View.VISIBLE );
        flTitleRight.setVisibility( View.VISIBLE );
    }

    @OnClick({R.id.fl_title_left, R.id.fl_title_menu, R.id.fl_title_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fl_title_left:
                ToastUtils.showShort( "导航" );
                break;
            case R.id.fl_title_menu:
                ToastUtils.showShort( "菜单" );
                break;
            case R.id.fl_title_right:
                ToastUtils.showShort( "搜索" );
                break;
        }
    }


    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        arrayStr = new ArrayList<>();
        imagesUrl = new ArrayList<>();
        quickAdapter = new QuickAdapter( arrayStr );
        recyclerView.setLayoutManager( new FullyGridLayoutManager(this, 3 ));
        recyclerView.addItemDecoration( new RecycleViewItemLine(this, LinearLayoutManager.HORIZONTAL, R.drawable.shape_gradient_gray ) );
        GridItemDecoration.Builder builder = new GridItemDecoration.Builder(this);
        builder.horSize( AutoSizeUtils.dp2px( this, 5 ) );
        builder.verSize( AutoSizeUtils.dp2px(this, 10 ) );
        recyclerView.addItemDecoration( new GridItemDecoration( builder ) );
        recyclerView.setAdapter( quickAdapter );
        refreView();
    }


    public void refreView(){
        imagesUrl = Arrays.asList( "https://qidian.qpic.cn/qidian_common/349573/85fd2ef40c1bba194a86bac8db7f1789/0",
                "https://qidian.qpic.cn/qidian_common/349573/eaabbbd7db1586044ec89526f3ac44e7/0",
                "https://qidian.qpic.cn/qidian_common/349573/117b34a4c843d148f8c8761b4f37031a/0",
                "https://qidian.qpic.cn/qidian_common/349573/b18f1b354ce1fd42367e639f41f2b593/0",
                "https://qidian.qpic.cn/qidian_common/349573/eb79dd78b3d7e0b3eecb80a80317925d/0" );
        arrayStr.add( "1" );
        arrayStr.add( "1" );
        arrayStr.add( "1" );
        arrayStr.add( "1" );
        arrayStr.add( "1" );
        arrayStr.add( "1" );
        arrayStr.add( "1" );
        arrayStr.add( "1" );
        arrayStr.add( "1" );
        arrayStr.add( "1" );
        arrayStr.add( "1" );
        arrayStr.add( "1" );
        arrayStr.add( "1" );
        arrayStr.add( "1" );
        arrayStr.add( "1" );
        arrayStr.add( "1" );
        arrayStr.add( "1" );
        arrayStr.add( "1" );
        arrayStr.add( "1" );
        arrayStr.add( "1" );

        banner.setImageLoader( new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                imageView.setPadding( AutoSizeUtils.dp2px( context, 20 ), 0,
                        AutoSizeUtils.dp2px( context, 20 ), 0 );
                imageView.setScaleType( ImageView.ScaleType.FIT_XY );
                Glide.with( context )
                        .load( ((String) path).replace( " ", "" ) )
                        .apply( bitmapTransform( new RoundedCornersTransformation( AutoSizeUtils.dp2px( context, 45 ), 0 ) ) )
                        .into( imageView );
            }
        } ).setImages( imagesUrl ).start();
        quickAdapter.setNewData( arrayStr );
    }


}
