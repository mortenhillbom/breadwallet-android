
package com.breadwallet.presenter.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.breadwallet.BreadWalletApp;
import com.breadwallet.R;
import com.breadwallet.presenter.activities.MainActivity;
import com.breadwallet.presenter.customviews.BubbleTextView;
import com.breadwallet.tools.adapter.MiddleViewAdapter;
import com.breadwallet.tools.animation.BRAnimator;
import com.breadwallet.tools.animation.SpringAnimator;
import com.breadwallet.tools.manager.BRTipsManager;
import com.breadwallet.tools.manager.SharedPreferencesManager;
import com.breadwallet.wallet.BRWalletManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * BreadWallet
 * <p>
 * Created by Mihail Gutan <mihail@breadwallet.com> on 6/23/15.
 * Copyright (c) 2016 breadwallet LLC
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

public class MainFragmentCashier extends Fragment {
    private static final String TAG = MainFragmentCashier.class.getName();
    private TextView mainAddressText;
    private TextView mainAmountDueText;
    private FragmentSharing sharingFragment;
    private FragmentManager fm;
    private String receiveAddress;
    private RelativeLayout billLayout;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // The last two arguments ensure LayoutParams are inflated
        // properly.
        final View rootView = inflater.inflate(R.layout.fragment_cashier_main, container, false);

        BRWalletManager.refreshAddress();
        receiveAddress = SharedPreferencesManager.getReceiveAddress(getActivity());
        sharingFragment = new FragmentSharing();
        final RelativeLayout mainFragmentCashier = (RelativeLayout) rootView.findViewById(R.id.main_fragment_cashier);
        mainAddressText = (TextView) rootView.findViewById(R.id.main_business_address_text);
        mainAmountDueText = (TextView) rootView.findViewById(R.id.main_amount_due_text);
        billLayout = (RelativeLayout) rootView.findViewById(R.id.theBillLayout);
        String bitcoinUrl = "bitcoin:" + receiveAddress;
        System.out.println(mainAddressText);
        mainAddressText.setText(receiveAddress);
        mainAmountDueText.setText("4500");
        fm = getActivity().getFragmentManager();
        mainFragmentCashier.setPadding(0, MainActivity.screenParametersPoint.y / 5, 0, 0);
        MainActivity.billAmount = mainAmountDueText.getText().toString();
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onResume() {
        super.onResume();
        MiddleViewAdapter.resetMiddleView(getActivity(), null);
    }

    public String getBillAmount() {
        return mainAmountDueText.getText().toString();
    }


}
