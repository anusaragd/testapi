package com.example.testapi;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.testapi.model.Student;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UpdateActivity extends AppCompatActivity {
    private String TAG = MainActivity.class.getSimpleName();
    private ListView lv;

    ArrayList<HashMap<String, String>> contactList;

    private  List<Student> list;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        contactList = new ArrayList<>();
        list = new ArrayList<>();
        lv = (ListView) findViewById(R.id.listView);


        new UpdateActivity.GetContacts().execute();

//        People2 p = new People2();
    }

    private class GetContacts extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(UpdateActivity.this, "Json Data is downloading", Toast.LENGTH_LONG).show();

        }


        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            // Making a request to url and getting response
//            String url = "http://api.androidhive.info/contacts/";
            String url = "https://my-student-api.herokuapp.com/getStudent";
            String jsonStr = sh.makeServiceCall(url);


            Log.e(TAG, "Response from url: " + jsonStr);
            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr).getJSONObject("response");


                    JSONArray contacts = jsonObj.getJSONArray("students");





//
//                    Gson gson = new Gson();
//                    Type listType = new TypeToken<ArrayList<Student>>() {}.getType();
//                    List<HashMap<String, String>> students = gson.fromJson(gson.toString(), listType);




                    Student student = new Student();
                    Gson gson = new Gson();
                    // student =  gson.fromJson(contacts.toString(), Student.class);
                    Type listType = new TypeToken<ArrayList<Student>>() {}.getType();
                    List<Student> students = gson.fromJson(contacts.toString(), listType);

//                    String json = gson.toJson(student, Student.class);

                    String json = gson.toJson(students);
                    Log.e(json,"aaaa");


//                    GeneralInfo generalInfoObject = gson.fromJson(students, GeneralInfo.class);


//                    HashMap<String, String> contact = new HashMap<>();

                    // adding each child node to HashMap key => value
//                        contact.put("students",student);
//                    for (int i = 0; i < contacts.length(); i++) {
//                        JSONObject c = contacts.getJSONObject(i);
//                        String id = c.getString("id");
//                        String name = c.getString("name");
//                        String surname = c.getString("surname");
//                        String age = c.getString("age");
//
//                        contact.put("id", id);
//                        contact.put("name", name);
//                        contact.put("surname", surname);
//                        contact.put("age", age);
//
//                        // adding contact to contact list
//                        contactList.add(contact);

//                    }

//                    Toast.makeText(getApplicationContext(),"123" + json,Toast.LENGTH_LONG).show();


//                    contactList.toArray().equals(student);
//                    contactList.add("id",id);
//                    contactList.toArray();

                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(), "Json parsing error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });

                }

            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "Couldn't get json from server. Check LogCat for possible errors!", Toast.LENGTH_LONG).show();
                    }
                });
            }

            return null;
        }



        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            ListAdapter adapter = new SimpleAdapter(UpdateActivity.this, contactList,
                    R.layout.list_item, new String[]{"name", "surname", "age"}, new int[]{R.id.namecol, R.id.lnamecol, R.id.agecol});
            lv.setAdapter(adapter);
        }
    }
}