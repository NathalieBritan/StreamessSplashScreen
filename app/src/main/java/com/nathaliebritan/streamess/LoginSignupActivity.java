package com.nathaliebritan.streamess;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginSignupActivity extends AppCompatActivity {
    public static int FLAG_LOGIN_SIGNUP = 0;

    private TextView txtOrSignUp;
    private TextView txtForgotPassword;

    private EditText editTxtName;
    private EditText editTxtEmail;
    private EditText editTxtPassword;

    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_signup);

        txtOrSignUp = (TextView) findViewById(R.id.txt_signup);
        txtForgotPassword = (TextView) findViewById(R.id.txt_forgot_password);
        editTxtName = (EditText) findViewById(R.id.edittxt_full_name);
        editTxtEmail = (EditText) findViewById(R.id.edittxt_email);
        editTxtPassword = (EditText) findViewById(R.id.edittxt_password);
        btnLogin = (Button) findViewById(R.id.btn_login);

        editTxtPassword.addTextChangedListener(filterTextWatcher);

        txtOrSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (FLAG_LOGIN_SIGNUP) {
                    case 0:
                        editTxtName.setVisibility(View.VISIBLE);
                        txtForgotPassword.setVisibility(View.INVISIBLE);
                        txtOrSignUp.setText(R.string.or_login);
                        btnLogin.setText(R.string.sign_up);
                        FLAG_LOGIN_SIGNUP = 1;
                        break;
                    case 1:
                        editTxtName.setVisibility(View.INVISIBLE);
                        txtForgotPassword.setVisibility(View.VISIBLE);
                        txtOrSignUp.setText(R.string.or_signup);
                        btnLogin.setText(R.string.login);
                        FLAG_LOGIN_SIGNUP = 0;
                        break;
                }
            }
        });
    }

    private TextWatcher filterTextWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (!editTxtEmail.getText().toString().equals("") && !editTxtPassword.getText().toString().equals("")) {
                btnLogin.setEnabled(true);
            } else {
                btnLogin.setEnabled(false);
            }
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };
}
