package com.foumiu.start.bangwo;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Window;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by dabo on 2018/6/24.
 */

public class StubActivity extends AppCompatActivity {

    public static final String FRAGMENT_CLASS = "fragment";
    public static final String BUNDLE = "bundle";

    private Class<?> clazz;
    private Bundle bundle;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_stub);
        bundle = getIntent().getBundleExtra(BUNDLE);
        clazz = (Class<?>) getIntent().getSerializableExtra(FRAGMENT_CLASS);

        try {
            fragment = (Fragment) clazz.getConstructor(Bundle.class).newInstance(bundle);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.container, fragment);
            //transaction.replace();
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            transaction.commitAllowingStateLoss();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (clazz != null) {
            clazz = null;
        }
        if (bundle != null) {
            bundle = null;
        }
        System.gc();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            if (fragment instanceof VoteCardListFragment) {
//                if (((VoteCardListFragment) fragment).mPushView.getVisibility() == View.VISIBLE) {
//                    ((VoteCardListFragment) fragment).mPushView.setVisibility(View.GONE);
//                    return true;
//                }
//            }
//
//            if (fragment instanceof PhotoPostFragment) {
//                new AlertDialog.Builder(StubActivity.this).setMessage("退出此次编辑?").setPositiveButton("确定", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        finish();
//                    }
//                }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.dismiss();
//                    }
//                }).show();
//            }
        }
        return super.onKeyDown(keyCode, event);
    }

//    private BackHandledFragment mBackHandedFragment;
//
//    @Override
//    public void setSelectedFragment(BackHandledFragment selectedFragment) {
//        this.mBackHandedFragment = selectedFragment;
//    }

    @Override
    public void onBackPressed() {
//        if (mBackHandedFragment != null && mBackHandedFragment.isAdded()) {
//            mBackHandedFragment.onBackPressed(new BackHandledFragment.BackListener() {
//                @Override
//                public void onBackCall() {
//                    mBackHandedFragment = null;
//                }
//            });
//
//        } else {
        if (getSupportFragmentManager().getBackStackEntryCount() == 0) {
            super.onBackPressed();
        } else {
            getSupportFragmentManager().popBackStack();
        }
//        }
    }
}
