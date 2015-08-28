package com.breadwallet.presenter.activities.tests;

import android.support.test.InstrumentationRegistry;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.breadwallet.R;
import com.breadwallet.presenter.activities.MainActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * BreadWallet
 * <p/>
 * Created by Mihail on 7/7/15.
 * Copyright (c) 2015 Mihail Gutan <mihail@breadwallet.com>
 * <p/>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p/>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p/>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

    MainActivity activity;
    RelativeLayout burgerButtonLayout;
    Button scanQRCode;
    Button copyAddressFromClipboard;

    public MainActivityTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        setActivityInitialTouchMode(true);
        injectInstrumentation(InstrumentationRegistry.getInstrumentation()); // injects the Instrumentation for the Espresso
        activity = getActivity();
        burgerButtonLayout = (RelativeLayout) activity.findViewById(R.id.main_burger_button_layout);
        scanQRCode = (Button) activity.findViewById(R.id.main_button_scan_qr_code);
        copyAddressFromClipboard = (Button) activity.findViewById(R.id.main_button_pay_address_from_clipboard);
    }

    public void testPreconditions() {
        assertNotNull("activity is null", activity);
        assertNotNull("burgerButton is null", burgerButtonLayout);
        assertNotNull("scanQRCode is null", scanQRCode);
        assertNotNull("copyAddressFromClipboard is null", copyAddressFromClipboard);
    }

    @MediumTest
    public void testBurgerButton() {
        onView(withId(R.id.main_burger_button_layout)).perform(click());
//        onView(withId(R.id.settings)).perform(click());
    }

    @MediumTest
    public void testChangeText_sameActivity() {

        onView(withId(R.id.address_edit_text))
                .perform(clearText(), typeText("some testing text"), closeSoftKeyboard());
    }

    @MediumTest
    public void testSettingsClick() {

    }

}