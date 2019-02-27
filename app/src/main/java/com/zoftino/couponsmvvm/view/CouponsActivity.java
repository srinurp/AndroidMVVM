package com.zoftino.couponsmvvm.view;

import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.zoftino.couponsmvvm.R;
import com.zoftino.couponsmvvm.model.Coupon;
import com.zoftino.couponsmvvm.modelview.CouponViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class CouponsActivity extends AppCompatActivity {
    @NonNull
    private CompositeDisposable compositeDisposable;
    @NonNull
    private ListView categoriesLst;
    @NonNull
    private ListView couponsLst;
    @NonNull
    private CouponViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupons);

        categoriesLst = findViewById(R.id.categories);
        couponsLst = findViewById(R.id.coupons);

        viewModel = ViewModelProvider.AndroidViewModelFactory.
                getInstance(getApplication()).create(CouponViewModel.class);

        setItemClickListener();
    }

    private void setItemClickListener(){
        categoriesLst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String cat = (String)adapterView.getItemAtPosition(i);
                //pass selected category to viewmodel
                viewModel.setSelectedCat(cat);
            }
        });
    }
        @Override
    protected void onResume() {
        super.onResume();
        bind();
    }

    @Override
    protected void onPause() {
        unBind();
        super.onPause();
    }

    private void bind() {
        compositeDisposable = new CompositeDisposable();
        //subscribe to categories observable
        //add the observable to disposable
        compositeDisposable.add(viewModel.getCategories()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::setCategories));

        //subscribe to coupons observable
        //add the observable to disposable
        compositeDisposable.add(viewModel.getCouponsByCat()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::setCoupons));
    }

    private void unBind() {
        compositeDisposable.clear();
    }

    private void setCategories(ArrayList<String> cats){
        //display received data from viewmodel
        ArrayAdapter<String> itemsAdapter =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, cats);
        categoriesLst.setAdapter(itemsAdapter);
    }

    private void setCoupons(List<Coupon> coupons){
        //display received data from viewmodel
        ArrayAdapter<Coupon> itemsAdapter =
                new ArrayAdapter<Coupon>(this,
                        android.R.layout.simple_list_item_1, coupons);
        couponsLst.setAdapter(itemsAdapter);
    }
}
