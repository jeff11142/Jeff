package bravoideas.ishowlife;
        import android.content.Intent;
        import android.support.v4.view.GravityCompat;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.Toolbar;
        import android.util.Log;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ImageView;
        import android.widget.LinearLayout;

        import com.huangzj.slidingmenu.SlidingMenu;

public class MainActivity extends AppCompatActivity {
    private SlidingMenu menu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menu = new SlidingMenu(this);
        Menu();
        menu.showContent();
        init();

    }


    public void init(){
        LinearLayout mRecomended = (LinearLayout)findViewById(R.id.recomended);
        mRecomended.setOnClickListener(new OnClick());

        LinearLayout mLive = (LinearLayout)findViewById(R.id.live);
        mLive.setOnClickListener(new OnClick());


        LinearLayout mLike = (LinearLayout)findViewById(R.id.like);
        mLike.setOnClickListener(new OnClick());

        LinearLayout mFavorite = (LinearLayout)findViewById(R.id.favorite);
        mFavorite.setOnClickListener(new OnClick());

        LinearLayout mHistory = (LinearLayout)findViewById(R.id.history);
        mHistory.setOnClickListener(new OnClick());

        LinearLayout mFeedback = (LinearLayout)findViewById(R.id.feedback);
        mFeedback.setOnClickListener(new OnClick());

        LinearLayout mSettings = (LinearLayout)findViewById(R.id.settings);
        mSettings.setOnClickListener(new OnClick());
    }

    private class OnClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            switch (v.getId()) {
                case R.id.recomended:
                    intent.setClass(MainActivity.this,MainActivity.class);
                    bundle.putString("theme", "Recomended");
                    bundle.putString("From", "MainActivity");
                    intent.putExtras(bundle);
                    startActivity(intent);
                    overridePendingTransition(0, 0);
                    Log.e("theme","Recomended");
                    if (menu.isSecondaryMenuShowing()) {

                        Log.e("Menu","menu closed");
                    }
                    finish();
                    break;
                case R.id.live:
                    intent.setClass(MainActivity.this,LiveActivity.class);
                    bundle.putString("theme", "Live");
                    bundle.putString("From", "MainActivity");
                    intent.putExtras(bundle);
                    startActivity(intent);
                    overridePendingTransition(0, 0);
                    Log.e("theme","Live");
                    menu.showContent();
                    break;
                default:
                    break;
            }
        }
    }
    public void Menu(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //remove ToolBar Tittle
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        // configure the SlidingMenu
        menu.setMode(SlidingMenu.LEFT);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setShadowWidthRes(R.dimen.shadow_width);
        // setting menu width
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        menu.setFadeDegree(0.35f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        menu.setMenu(R.layout.left_fragment);

        ImageView tool_menu = (ImageView)toolbar.findViewById(R.id.menu);
        tool_menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menu.showMenu();
            }
        });
    }

    public void Bundle(){
        Bundle getbundle =this.getIntent().getExtras();
        ImageView iRecomended = (ImageView)findViewById(R.id.recomended_line);
        switch(getbundle.getString("theme")){
            case "Recomended":
                iRecomended.setVisibility(View.VISIBLE);
                break;
            case "Live":
                ImageView iLive = (ImageView)findViewById(R.id.live_line);
                iLive.setVisibility(View.VISIBLE);

                iRecomended.setVisibility(View.INVISIBLE);
                break;
            case "Like":
                ImageView iLike = (ImageView)findViewById(R.id.like_line);
                iLike.setVisibility(View.VISIBLE);

                iRecomended.setVisibility(View.INVISIBLE);
                break;
            case "Favorite":
                ImageView iFavorite = (ImageView)findViewById(R.id.favorite_line);
                iFavorite.setVisibility(View.VISIBLE);

                iRecomended.setVisibility(View.INVISIBLE);
                break;
            case "History":
                ImageView iHistory = (ImageView)findViewById(R.id.history_line);
                iHistory.setVisibility(View.VISIBLE);

                iRecomended.setVisibility(View.INVISIBLE);
                break;
            case "Feedback":
                ImageView iFeedback = (ImageView)findViewById(R.id.feedback_line);
                iFeedback.setVisibility(View.VISIBLE);

                iRecomended.setVisibility(View.INVISIBLE);
                break;
            case "Settings":
                ImageView iSettings = (ImageView)findViewById(R.id.settings_line);
                iSettings.setVisibility(View.VISIBLE);

                iRecomended.setVisibility(View.INVISIBLE);
                break;
        }

    }

}
