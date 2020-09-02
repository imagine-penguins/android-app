package com.example.ipcoumpos;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.devs.vectorchildfinder.VectorChildFinder;
import com.devs.vectorchildfinder.VectorDrawableCompat;
import com.example.ipcoumpos.bottomnavigation.MainPage;
import com.example.myloadingbutton.MyLoadingButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;


public class MainActivity extends AppCompatActivity {

    ActionBar actionBar;

    private MyLoadingButton btn;
    EditText user,pass;
    private VectorChildFinder vector;
    private HashMap findViewCache;
    ImageView image;SetString setString=new SetString();
    HashMap<String,String> hashMap=new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      //  vector=new VectorChildFinder()
        changeImageState(YetStates.INSTANCE.getSTATE_INITIAL());
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        actionBar=getSupportActionBar();
        actionBar.hide();
        final int[]anim={-R.attr.initial, -R.attr.looking, -R.attr.hidding_eyes, -R.attr.email_focus, R.attr.laughing};
        final  int []animclo={R.attr.initial, -R.attr.looking, -R.attr.hidding_eyes, -R.attr.email_focus, -R.attr.laughing};
        final  int []looking={ -R.attr.initial, R.attr.looking, -R.attr.hidding_eyes, -R.attr.email_focus, -R.attr.laughing};
        final  int []closeeys={R.attr.initial, -R.attr.looking, -R.attr.hidding_eyes, -R.attr.email_focus, -R.attr.laughing};
        user=findViewById(R.id.userid);
        changeImageState(animclo);
        pass=findViewById(R.id.userpassword);
        btn=findViewById(R.id.loginButton);
       image=findViewById(R.id.imageView);
       pass.setOnFocusChangeListener(new View.OnFocusChangeListener() {
           @Override
           public void onFocusChange(View v, boolean hasFocus) {
//               if (hasFocus) {
                   image.setImageDrawable(MainActivity.this.getDrawable(R.drawable.asl_yet));
//                   changeImageState(looking);
//               } else{
//                   changeImageState(animclo);
//               }



           }
       });



       user.setOnFocusChangeListener(new View.OnFocusChangeListener() {
           @Override
           public void onFocusChange(View v, boolean hasFocus) {
               if (hasFocus) {
                   image.setImageDrawable(MainActivity.this.getDrawable(R.drawable.avd_yet_smile));
//                   changeImageState(anim);
               }else{

               }
//                   changeImageState(closeeys);
           }
       });

      user.addTextChangedListener(new TextWatcher() {
          @Override
          public void beforeTextChanged(CharSequence s, int start, int count, int after) {
             // image.setImageDrawable(MainActivity.this.getDrawable(R.drawable.asl_yet));
          }

          @Override
          public void onTextChanged(CharSequence s, int start, int before, int count) {
            //  image.setImageState(anim,true);

              if (s.length() > 0) {
                 updateFaceView(s.length(), before);
              } else {
               updateFaceView(0, 0);
              }
          }

          @Override
          public void afterTextChanged(Editable s) {

          }
      });



        btn.setMyButtonClickListener(new MyLoadingButton.MyLoadingButtonClick() {
            @Override
            public void onMyLoadingButtonClick() {
                JSONObject js = new JSONObject();
                try {
                    js.put("username",user.getText().toString());
                    js.put("password",pass.getText().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                RequestQueue queue= Volley.newRequestQueue(MainActivity.this);
                queue.add(new JsonObjectRequest(Request.Method.POST,setString.APP_BASIC_LINK+setString.LOGIN , js,
                        new com.android.volley.Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                               if (response.toString().isEmpty()){
                                   btn.showErrorButton();

                               }else {
                                   btn.showDoneButton();
                                  startActivity(new Intent(MainActivity.this,MainPage.class)
                                          .putExtra("js",response.toString()));
                               }

                            }
                        }, new com.android.volley.Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                       // Toast.makeText(MainActivity.this, ""+error.toString(), Toast.LENGTH_SHORT).show();
                      btn.showErrorButton();
                    }

                }) {

                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        HashMap<String, String> headers = new HashMap<String, String>();
                        headers.put("Content-Type", "application/json; charset=utf-8");
                        return headers;
                    }
                    @Override
                    protected Map<String,String> getParams(){
                        Map<String,String> params = new HashMap<String, String>();
                      //  params.put("grant_type", "client_credentials");

                        return params;
                    }
                });


            }
        });


//                Toast.makeText(MainActivity.this, "yeh sucessfully", Toast.LENGTH_SHORT).show();
//            }
//        });
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                Intent in = new Intent(MainActivity.this, Two.class);
//                startActivity(in);
////                JSONObject js = new JSONObject();
////                try {
////                    js.put("username",user.getText().toString());
////                    js.put("password",pass.getText().toString());
////                } catch (JSONException e) {
////                    e.printStackTrace();
////                }
////                RequestQueue queue= Volley.newRequestQueue(MainActivity.this);
////                queue.add(new JsonObjectRequest(Request.Method.POST, url, js,
////                        new com.android.volley.Response.Listener<JSONObject>() {
////                            @Override
////                            public void onResponse(JSONObject response) {
////                                Toast.makeText(MainActivity.this, ""+response.toString(), Toast.LENGTH_SHORT).show();
////                            }
////                        }, new com.android.volley.Response.ErrorListener() {
////                    @Override
////                    public void onErrorResponse(VolleyError error) {
////                        // handle error
////                        Toast.makeText(MainActivity.this, ""+error.toString(), Toast.LENGTH_SHORT).show();
////                    }
////                }) {
////
////                    @Override
////                    public Map<String, String> getHeaders() throws AuthFailureError {
////                        HashMap<String, String> headers = new HashMap<String, String>();
////                        headers.put("Content-Type", "application/json; charset=utf-8");
////                        return headers;
////                    }
////                    @Override
////                    protected Map<String,String> getParams(){
////                        Map<String,String> params = new HashMap<String, String>();
////                        params.put("grant_type", "client_credentials");
////
////                        return params;
////                    }
////                });
//            }
//        });

//        initViews();

//        new CountDownTimer(5000, 1000) {
//
//
//            @Override
//
//            public void onTick(long millisUntilFinished) {
//
////                bookITextView.setVisibility(GONE);
//              //  loadingProgressBar.setVisibility(GONE);
//                rootView.setBackgroundColor(ContextCompat.getColor(MainActivity.this, R.color.white));
//                bookIconImageView.setImageResource(R.drawable.favicon);
//                startAnimation();
//            }
//
//            @Override
//            public void onFinish() {
//
//            }
//        }.start();
    }

//    private void initViews() {
//        bookIconImageView = findViewById(R.id.bookIconImageView);
//       // loadingProgressBar = findViewById(R.id.loadingProgressBar);
//        rootView = findViewById(R.id.rootView);
//        afterAnimationView = findViewById(R.id.afterAnimationView);
//    }

//    private void startAnimation() {
//        ViewPropertyAnimator viewPropertyAnimator = bookIconImageView.animate();
//        viewPropertyAnimator.x(50f);
//        viewPropertyAnimator.y(100f);
//        viewPropertyAnimator.setDuration(1000);
//        viewPropertyAnimator.setListener(new Animator.AnimatorListener() {
//            @Override
//            public void onAnimationStart(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animator animation) {
//                afterAnimationView.setVisibility(VISIBLE);
//            }
//
//            @Override
//            public void onAnimationCancel(Animator animation) {
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animator animation) {
//
//            }
//        });
//    }
private final void returnToInitialState() {
    this.changeImageState(YetStates.INSTANCE.getSTATE_INITIAL());
    ((EditText)this.findCachedViewById(R.id.userpassword)).clearFocus();
    ((EditText)this.findCachedViewById(R.id.userid)).clearFocus();
    this.hideSoftKeyboard();
}

    private final void updateFaceView(int charSequenceSize, int before) {
        if (charSequenceSize == 1 && before == 0) {
            this.changeImageState(YetStates.INSTANCE.getSTATE_SMILE());
        } else if (charSequenceSize <= 30) {
            this.changeVectorParameters(charSequenceSize);
        }

    }

    private final void changeVectorParameters(int charSequenceSize) {

        if (charSequenceSize > 0) {
           vector= new VectorChildFinder(MainActivity.this, R.drawable.vd_yet_email_smile, image);
        } else {

           vector=new  VectorChildFinder(MainActivity.this, R.drawable.vd_yet_email, image);
        }

        VectorDrawableCompat.VGroup face = vector.findGroupByName("face");
        VectorDrawableCompat.VGroup group7 = vector.findGroupByName("group_7");
        VectorDrawableCompat.VGroup group6 = vector.findGroupByName("group_6");
        VectorDrawableCompat.VGroup group3 = vector.findGroupByName("group_3");
        VectorDrawableCompat.VGroup group4 = vector.findGroupByName("group_4");
        VectorDrawableCompat.VGroup group1 = vector.findGroupByName("group_1");
        group7.setRotation((float) (-charSequenceSize * .2));
        group7.setTranslateY((float) (+charSequenceSize * .5));
        group6.setRotation((float) (-charSequenceSize * .1));
        group3.setRotation((float) (-charSequenceSize * .1));
       group6.setTranslateY((float) (+charSequenceSize * .2));
       group3.setTranslateY((float) (+charSequenceSize * .2));
       group4.setTranslateX((float) (-charSequenceSize * .2));
       group1.setTranslateX((float) (-charSequenceSize * .2));
        face.setTranslateX((float) (+charSequenceSize * .5));
        face.setTranslateY((float) (+charSequenceSize * .2));

    }

    private final void changeImageState(int[] state) {
        ((ImageView)this.findCachedViewById(R.id.imageView)).setImageState(state, true);
    }

    private final void hideSoftKeyboard() {
        @SuppressLint("WrongConstant") Object var10000 = this.getSystemService("input_method");
        if (var10000 == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        } else {
            InputMethodManager inputMethodManager = (InputMethodManager)var10000;
          //  inputMethodManager.hideSoftInputFromWindow(MainActivity.this.getWindowToken(), 0);
        }
    }

    public View findCachedViewById(int var1) {
        if (this.findViewCache == null) {
            this.findViewCache = new HashMap();
        }

        View var2 = (View)this.findViewCache.get(var1);
        if (var2 == null) {
            var2 = this.findViewById(var1);
            this.findViewCache.put(var1, var2);
        }

        return var2;
    }

    public void clearFindViewByIdCache() {
        if (this.findViewCache != null) {
            this.findViewCache.clear();
        }

    }

}


