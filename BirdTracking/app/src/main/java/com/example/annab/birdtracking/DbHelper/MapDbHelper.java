package com.example.annab.birdtracking.DbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.*;
import android.content.ContentValues;
import android.database.Cursor;
import android.util.Log;

import com.example.annab.birdtracking.model.LocData;


/**
 * @Author - Pooja Mishra
 * @Desc - Add POJO objects to the database
 */

public class MapDbHelper extends SQLiteOpenHelper {
    // Database Version - change accordingly
    private static final int DATABASE_VERSION = 1;
    // Database Name - change accordingly
    private static final String DATABASE_NAME = "BirdDB";

    public MapDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL statement to create LocData table
        String CREATE_LOC_TABLE = "CREATE TABLE locs ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "lat TEXT, "+
                "lon TEXT, "+
                "locality TEXT )";

        // create LocDatas table
        db.execSQL(CREATE_LOC_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older LocDatas table if existed
        db.execSQL("DROP TABLE IF EXISTS locs");

        // create fresh LocDatas table
        this.onCreate(db);
    }

    //---------------------------------------------------------------------

    /**
     * CRUD operations (create "add", read "get", update, delete)
     */

    //  table name
    private static final String TABLE_LOCS = "locs";

    //  Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_LON = "lon";
    private static final String KEY_LAT = "lat";
    private static final String KEY_LOC = "locality";
    private static final String[] COLUMNS = {KEY_ID,KEY_LON,KEY_LAT,KEY_LOC};


    // Get All LocDatas
    public List<LocData> getAllLocDatas() {
        List<LocData> locDatas = new LinkedList<LocData>();

        // 1. build the query
        String query = "SELECT  * FROM " + TABLE_LOCS;

        // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // 3. go over each row, build LocData and add it to list
        LocData locData = null;
        if (cursor.moveToFirst()) {
            do {
                locData = new LocData();
                locData.setId(Integer.parseInt(cursor.getString(0)));
                locData.setLat(cursor.getString(1));
                locData.setLon(cursor.getString(2));
                locData.setLocality(cursor.getString(3));
                // Add LocData to LocDatas
                locDatas.add(locData);
            } while (cursor.moveToNext());
        }

        Log.d("getAllLocDatas()", locDatas.toString());

        // return LocDatas
        return locDatas;
    }

    public void addLoc(LocData locData){
        Log.d("addLocData", locData.toString());
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_LAT, locData.getLat()); // get title
        values.put(KEY_LON, locData.getLon()); // get author
        values.put(KEY_LOC,locData.getLocality());
        // 3. insert
        db.insert(TABLE_LOCS, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values

        // 4. close
        db.close();
    }

    // Deleting single Loc
    public void deleteLocData(LocData locData) {

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. delete
        db.delete(TABLE_LOCS,
                KEY_ID+" = ?",
                new String[] { String.valueOf(locData.getId()) });

        // 3. close
        db.close();

        Log.d("deleteLocData", locData.toString());

    }
}


