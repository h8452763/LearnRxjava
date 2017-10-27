package com.cloudtp.learnrxjava.ui.fragmentapi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.cloudtp.learnrxjava.R;
import com.cloudtp.learnrxjava.base.BaseLazyFragment;
import com.cloudtp.learnrxjava.constant.Constant;
import com.cloudtp.learnrxjava.ui.BaseView;
import com.cloudtp.learnrxjava.ui.activity.CreatingObservableActivity;
import com.cloudtp.learnrxjava.ui.activity.TransFromActivity;
import com.cloudtp.learnrxjava.ui.adapter.ApiAdapter;
import com.cloudtp.learnrxjava.ui.presenter.ApiListFragmentPresenter;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by JYD on 2016/8/24.
 */
public class ApiListFragment extends BaseLazyFragment implements BaseView {
    public static final String INTENT_INT_INDEX = "intent_int_index";
    public static final String API_CREATEOBSERVABLE_NAME="fromjustrepeatrepeatWhencreatedeferrangeintervaltimeremptyerrornever";
    public static final String API_TRANSFORM_NAME="mapflatmapswitchmapscangroupBybufferwindowcast";
    private Unbinder unbinder;
 //   @BindView(R.id.textview11)
    TextView textView;
    RecyclerView recyclerView;
    Constant.NewsType apiType = Constant.NewsType.ALL;
    private ApiAdapter apiAdapter;
    private ArrayList<String> apiList=new ArrayList<String>();
    private ApiListFragmentPresenter apiPresenter;
    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.fragment_apilist);
        unbinder=ButterKnife.bind(this,getContentView());
        apiType=(Constant.NewsType) getArguments().getSerializable(INTENT_INT_INDEX);
        apiPresenter = new ApiListFragmentPresenter(mActivity, this);
        apiPresenter.initialized(apiType);
        initView();


    }
    private void initView() {
        textView= (TextView) findViewById(R.id.textview11);
        recyclerView= (RecyclerView) findViewById(R.id.recycleview);

        switch(apiType){
            case ALL:
                textView.setText("ALL");
                apiAdapter=new ApiAdapter(getActivity(),apiList);
                break;
            case CREATING:
                textView.setText("creating");
                apiAdapter=new ApiAdapter(getActivity(),apiList);
                break;
            case TRANSFORM:
                textView.setText("transform");
                apiAdapter=new ApiAdapter(getActivity(),apiList);
                break;
            case FILTER:
                textView.setText("filter");
                apiAdapter=new ApiAdapter(getActivity(),apiList);
                break;
            case COMBINING:
                textView.setText("combining");
                apiAdapter=new ApiAdapter(getActivity(),apiList);
                Log.w("ceshi","");
                break;
            default:
                ;
        }
        //item点击事件
        apiAdapter.setOnItemClickLitener(new ApiAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                //可以用工厂模式实现 根据名字的不同 去打开不同的activity
                switchActivity(apiList.get(position).toString());

            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(apiAdapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    private void switchActivity(String apiName) {
        if(API_CREATEOBSERVABLE_NAME.contains(apiName)){
            //为creatingobservable
            Toast.makeText(getContext(),apiName,Toast.LENGTH_SHORT).show();
               Intent intent=new Intent(getActivity(), CreatingObservableActivity.class);
                intent.putExtra("apiName",apiName);
                startActivity(intent);
        }else if(API_TRANSFORM_NAME.contains(apiName)){
            Toast.makeText(getContext(),apiName,Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(getActivity(), TransFromActivity.class);
            intent.putExtra("apiName",apiName);
            startActivity(intent);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void initializeViews(ArrayList<String> names) {
        apiList=names;

    }
}
