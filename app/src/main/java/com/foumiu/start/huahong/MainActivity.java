package com.foumiu.start.huahong;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.foumiu.start.huahong.fragment.MessageFragment;
import com.foumiu.start.huahong.fragment.MineFragment;
import com.foumiu.start.huahong.fragment.XSListFragment;
import com.foumiu.start.huahong.fragment.XSPublishFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int MAIN_STATE_LIST = 0;//显示悬赏列表页
    public static final int MAIN_STATE_PUBLISH = 1;//显示悬赏发布页
    public static final int MAIN_STATE_MESSAGE = 2;//显示消息页
    public static final int MAIN_STATE_MINE = 3;//显示我的页

    private View mListTab, mPublishTab, mMessageTab, mMineTab;
    private ImageView mListImg, mPublishImg, mMessageImg, mMineImg;
    private TextView mListText, mPublishText, mMessageText, mMineText;

    private Fragment mListFragment, mPublishFragment, mMessageFragment, mMineFragment;

    private int defaultColor, selectColor;
    private int mainStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        defaultColor = XSApplicaition.getColor(this, R.color.app_gray);
        selectColor = XSApplicaition.getColor(this, R.color.app_violet);
        mainStatus = MAIN_STATE_LIST;
        initViews();
        initFragments();
        initClickListener();
    }

    private void initClickListener() {
        mListTab.setOnClickListener(this);
        mPublishTab.setOnClickListener(this);
        mMessageTab.setOnClickListener(this);
        mMineTab.setOnClickListener(this);
    }

    private void initFragments() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        if (mListFragment != null)
            ft.remove(mListFragment);
        if (mPublishFragment != null)
            ft.remove(mPublishFragment);
        if (mMessageFragment != null)
            ft.remove(mMessageFragment);
        if (mMineFragment != null)
            ft.remove(mMineFragment);

        mListFragment = new XSListFragment();
        mPublishFragment = new XSPublishFragment();
        mMessageFragment = new MessageFragment();
        mMineFragment = new MineFragment();

        ft.add(R.id.main_square, mListFragment);
        ft.add(R.id.main_square, mPublishFragment);
        ft.add(R.id.main_square, mMessageFragment);
        ft.add(R.id.main_square, mMineFragment);

        showTheFragment();

        ft.commitAllowingStateLoss();


    }

    private void initViews() {
        mListTab = findViewById(R.id.main_bottom_list);
        mPublishTab = findViewById(R.id.main_bottom_publish);
        mMessageTab = findViewById(R.id.main_bottom_message);
        mMineTab = findViewById(R.id.main_bottom_mine);

        mListImg = findViewById(R.id.main_bottom_list_img);
        mPublishImg = findViewById(R.id.main_bottom_publish_img);
        mMessageImg = findViewById(R.id.main_bottom_message_img);
        mMineImg = findViewById(R.id.main_bottom_mine_img);

        mListText = findViewById(R.id.main_bottom_list_text);
        mPublishText = findViewById(R.id.main_bottom_publish_text);
        mMessageText = findViewById(R.id.main_bottom_message_text);
        mMineText = findViewById(R.id.main_bottom_mine_text);

        showTheIndex();
    }

    /**
     * 根据状态mainStatus值显示对应的Fragment
     */
    private void showTheFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.hide(mListFragment);
        ft.hide(mPublishFragment);
        ft.hide(mMessageFragment);
        ft.hide(mMineFragment);

        switch (mainStatus) {
            case MAIN_STATE_LIST:
                ft.show(mListFragment);
                break;
            case MAIN_STATE_PUBLISH:
                ft.show(mPublishFragment);
                break;
            case MAIN_STATE_MESSAGE:
                ft.show(mMessageFragment);
                break;
            case MAIN_STATE_MINE:
                ft.show(mMineFragment);
                break;
        }
        ft.commitAllowingStateLoss();
    }

    /**
     * 根据状态mainStatus值显示对应的导航样式
     */
    private void showTheIndex() {
        mListImg.setImageResource(R.drawable.list_off);
        mPublishImg.setImageResource(R.drawable.publish_off);
        mMessageImg.setImageResource(R.drawable.message_off);
        mMineImg.setImageResource(R.drawable.mine_off);

        mListText.setTextColor(defaultColor);
        mPublishText.setTextColor(defaultColor);
        mMessageText.setTextColor(defaultColor);
        mMineText.setTextColor(defaultColor);

        switch (mainStatus) {
            case MAIN_STATE_LIST:
                mListImg.setImageResource(R.drawable.list_on);
                mListText.setTextColor(selectColor);
                break;
            case MAIN_STATE_PUBLISH:
                mPublishImg.setImageResource(R.drawable.publish_on);
                mPublishText.setTextColor(selectColor);
                break;
            case MAIN_STATE_MESSAGE:
                mMessageImg.setImageResource(R.drawable.message_on);
                mMessageText.setTextColor(selectColor);
                break;
            case MAIN_STATE_MINE:
                mMineImg.setImageResource(R.drawable.mine_on);
                mMineText.setTextColor(selectColor);
                break;
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_bottom_list:
                mainStatus = MAIN_STATE_LIST;
                break;
            case R.id.main_bottom_publish:
                mainStatus = MAIN_STATE_PUBLISH;
                break;
            case R.id.main_bottom_message:
                mainStatus = MAIN_STATE_MESSAGE;
                break;
            case R.id.main_bottom_mine:
                mainStatus = MAIN_STATE_MINE;
                break;
        }
        showTheFragment();
        showTheIndex();
    }
}
