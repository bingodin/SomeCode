/*author:conowen
* date:2012.4.2
* DataHelper
*/
package com.qjjc.test;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DataHelper extends SQLiteOpenHelper {

@Override
public synchronized void close() {
// TODO Auto-generated method stub
super.close();
}

public DataHelper(Context context, String name, CursorFactory factory,
int version) {
super(context, name, factory, version);
// TODO Auto-generated constructor stub

}

@Override
public void onCreate(SQLiteDatabase db) {
// TODO Auto-generated method stub

String sql = "CREATE TABLE JobChecker (_id INTEGER PRIMARY KEY , department VARCHAR, job VARCHAR,teacher VARCHAR,address VARCHAR,student VARCHAR,isworking VARCHAR)";
db.execSQL(sql);

}

@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
// TODO Auto-generated method stub

}

}