package example.fussen.baselibrary.mvp.layout;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import example.fussen.baselibrary.base.presenter.PresenterLife;
import example.fussen.baselibrary.base.view.MvpView;

/**
 * Created by Fussen on 2017/1/10.
 */

public abstract class MvpLinearLayout<V extends MvpView, P extends PresenterLife> extends LinearLayout implements MvpView{


    protected P presenter;
    private Unbinder unbinder;

    public MvpLinearLayout(Context context) {
        super(context);
    }

    public MvpLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MvpLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(21)
    public MvpLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        unbinder = ButterKnife.bind(this, this);
        initView();
    }


    /**
     * 该方法在当前View从一个window上分离时被调用
     */
    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        unbinder.unbind();
        presenter = null;
    }

    protected abstract void initView();

    /**
     * 创建presenter
     * @return
     */
    public abstract P createPresenter();



}
