package com.example.voyagesun.myapplication;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends BaseActivity {


    private View activityRootView;

    private int screenHeight = 0;

    private int keyHeight = 0;

//    private Button button;

    private EditText editText1;

    private boolean init;

    private LinearLayout detailMainRL;



    @Override
    public void initView(Bundle savedInstanceState) {


        setContentView(R.layout.activity_main);
//        activityRootView = findViewById(R.id.root_layout);
//        button = (Button) findViewById(R.id.button);
        editText1 = (EditText) findViewById(R.id.editText1);
        screenHeight = this.getWindowManager().getDefaultDisplay().getHeight();
        keyHeight = screenHeight / 3;
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
            //透明状态栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
////            透明导航栏
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
        listenKeyboard();
    }



    private void listenKeyboard() {
        // TODO Auto-generated method stub
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
        detailMainRL = (LinearLayout) findViewById(R.id.root_layout);
        detailMainRL.getViewTreeObserver().addOnGlobalLayoutListener(
                new ViewTreeObserver.OnGlobalLayoutListener(){
                    @Override
                    public void onGlobalLayout()
                    {
                        int heightDiff = detailMainRL.getRootView().getHeight() - detailMainRL.getHeight();
                        if (heightDiff > detailMainRL.getRootView().getHeight()/3)
                        { // 说明键盘是弹出状态
                            Toast.makeText(MainActivity.this, "open", Toast.LENGTH_SHORT).show();
                        } else{
                            Toast.makeText(MainActivity.this, "close", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }







    @Override
    protected void onResume() {
        super.onResume();
//        activityRootView.addOnLayoutChangeListener(MainActivity.this);
    }

    private boolean isKeyboardShown(View rootView) {
        final int SOFT_KEYBOARD_HEIGHT_DP_THRESHOLD = 128;

        Rect r = new Rect();
        rootView.getWindowVisibleDisplayFrame(r);
        int heightDiff = rootView.getBottom() - r.bottom;

        return heightDiff > 200;
    }

    public void Click(View view) {
        final Rect rect = new Rect();
        // 获取root在窗体的可视区域
        activityRootView.getWindowVisibleDisplayFrame(rect);
        // 当前视图最外层的高度减去现在所看到的视图的最底部的y坐标
        int rootInvisibleHeight = activityRootView.getRootView()
                .getHeight() - rect.bottom;
        // 若rootInvisibleHeight高度大于100，则说明当前视图上移了，说明软键盘弹出了
        if (rootInvisibleHeight > 100) {
//                    int[] location = new int[2];
//                    // 获取scrollToView在窗体的坐标
//                    button.getLocationInWindow(location);
//                    // 计算root滚动高度，使scrollToView在可见区域的底部
//                    final int srollHeight = (location[1] + button
//                            .getHeight()) - rect.bottom;
//                    //软键盘弹出来的时候
////                    if (isOpen){
//                    activityRootView.scrollTo(0, srollHeight);
////                    }
            Toast.makeText(MainActivity.this, "open", Toast.LENGTH_SHORT).show();
        } else {
            // 软键盘没有弹出来的时候
//                    activityRootView.scrollTo(0, 0);
            Toast.makeText(MainActivity.this, "close", Toast.LENGTH_SHORT).show();
        }

    }




//
//    @Override
//    public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
////        if(oldBottom != 0 && bottom != 0 &&(oldBottom - bottom > keyHeight)){
////
////            Toast.makeText(MainActivity.this, "open", Toast.LENGTH_SHORT).show();
////
////        }else if(oldBottom != 0 && bottom != 0 &&(bottom - oldBottom > keyHeight)){
////
////            Toast.makeText(MainActivity.this, "close", Toast.LENGTH_SHORT).show();
////
////        }
//        if (bottom > oldBottom){
//            Toast.makeText(MainActivity.this, "close", Toast.LENGTH_SHORT).show();
//        }else {
//            Toast.makeText(MainActivity.this, "open", Toast.LENGTH_SHORT).show();
//        }
//    }
}
