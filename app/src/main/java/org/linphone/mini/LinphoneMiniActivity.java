package org.linphone.mini;
/*
LinphoneMiniActivity.java
Copyright (C) 2014  Belledonne Communications, Grenoble, France

This program is free software; you can redistribute it and/or
modify it under the terms of the GNU General Public License
as published by the Free Software Foundation; either version 2
of the License, or (at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program; if not, write to the Free Software
Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
*/

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * @author Sylvain Berfini
 */
public class LinphoneMiniActivity extends Activity {
    private LinphoneMiniManager mManager;
    private Button buttonCall;
    private TextView sipInputTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello_world);

        sipInputTV = (TextView) findViewById(R.id.AddressId);
        mManager = new LinphoneMiniManager(LinphoneMiniActivity.this);
        buttonCall = (Button) findViewById(R.id.CallButton);
        buttonCall.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                buttonCall.setEnabled(false);
                String sipAddr = sipInputTV.getText().toString();
                mManager.makeCall(sipAddr);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        mManager.destroy();

        super.onDestroy();
    }
}
