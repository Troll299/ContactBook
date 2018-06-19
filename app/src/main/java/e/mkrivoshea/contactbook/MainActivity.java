package e.mkrivoshea.contactbook;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    private static Contact[] contactsArray;

    private static int numContactsAdded;

    private EditText mNameInput;

    private EditText mPhoneInput;

    private EditText mEmailInput;

    private TextView mErrorMessage;

    private TextView mSortedList;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameInput = (EditText) findViewById(R.id.et_name);
        mEmailInput = (EditText) findViewById(R.id.et_email);
        mPhoneInput = (EditText) findViewById(R.id.et_phone);
        mErrorMessage = (TextView) findViewById(R.id.tv_error);
        mSortedList = (TextView) findViewById(R.id.tv_list);

        contactsArray = new Contact[50];
        numContactsAdded = 0;
    }

    public void addContactToArray(View view)
    {
        InputMethodManager inputManager = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
        Contact toAdd;

        if( mNameInput.getText().toString() == "") {

        }
        else if( numContactsAdded >= contactsArray.length )
        {
            mErrorMessage.setText ("You have added the maximum amount of contacts.");
        }
        else
        {
            toAdd = new Contact (mNameInput.getText().toString(), mEmailInput.getText().toString(), mPhoneInput.getText().toString());
            contactsArray[numContactsAdded] = toAdd;
            numContactsAdded++;

            mNameInput.setText("");
            mPhoneInput.setText("");
            mEmailInput.setText("");

            mNameInput.requestFocus();

            if( inputManager != null)
            {
                inputManager.showSoftInput( mNameInput, InputMethodManager.SHOW_IMPLICIT );
            }


            mErrorMessage.setText("Contact added successfully");
        }
    }

    public void sortContact(View view)
    {
        String sortedList = "";

        //insertionSort();
        selectionSort();
        //quickSort(contactsArray, 0, numContactsAdded - 1);

        for(int i = 0; i < numContactsAdded; i++)
        {
            if(contactsArray[i] != null)
            {
                sortedList += String.format("Name: %30s\nPhone: %30s\nE-mail: %30s\n\n", contactsArray [i].getName(), contactsArray [i].getPhone(), contactsArray [i].getEmail());
            }
        }

        mErrorMessage.setText("");
        mSortedList.setText(sortedList);
    }


}

