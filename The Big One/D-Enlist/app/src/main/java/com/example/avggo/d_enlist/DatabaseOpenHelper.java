package com.example.avggo.d_enlist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kevin on 4/5/2016.
 */
public class DatabaseOpenHelper  extends SQLiteOpenHelper{

    final static String SCHEMA = "courses";

    public DatabaseOpenHelper(Context context) {
        super(context, SCHEMA, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + Course.TABLE_NAME + " (" +
                Course.COLUMN_CLASS_NUMBER + " INTEGER PRIMARY KEY, " +
                Course.COLUMN_COURSE_NAME + " TEXT, " +
                Course.COLUMN_SECTION + " TEXT, " +
                Course.COLUMN_DAYS + " TEXT, " +
                Course.COLUMN_START_TIME + " TEXT, " +
                Course.COLUMN_END_TIME + " TEXT, " +
                Course.COLUMN_ROOM + " TEXT, " +
                Course.COLUMN_PROFESSOR + " TEXT, " +
                Course.COLUMN_ENROLL_CAPACITY + " INTEGER, " +
                Course.COLUMN_ENROLLED + " INTEGER);";

        db.execSQL(sql);

        insertCourse(new Course("367", "COMPRO1", "S17A", "MW", "9:15", "10:45", "G302A", "LIMOANGCO, TESSIE", 25, 0));
        insertCourse(new Course("367", "COMPRO1", "S17B", "MW", "9:15", "10:45", "G302A", "SALVADOR, FLORANTE", 25, 0));
    }

    public Course queryCourse(String classNumber) {
        SQLiteDatabase db = getReadableDatabase();

        Cursor c = db.query(Course.TABLE_NAME, null, Course.COLUMN_CLASS_NUMBER + " = ?", new String[]{classNumber}, null, null, null);

        Course newCourse;

        if (c.moveToFirst()) {
            newCourse = new Course();
            newCourse.setClassNumber(c.getString(c.getColumnIndex(Course.COLUMN_CLASS_NUMBER)));
            newCourse.setCourseName(c.getString(c.getColumnIndex(Course.COLUMN_COURSE_NAME)));
            newCourse.setSection(c.getString(c.getColumnIndex(Course.COLUMN_SECTION)));
            newCourse.setDays(c.getString(c.getColumnIndex(Course.COLUMN_DAYS)));
            newCourse.setStartTime(c.getString(c.getColumnIndex(Course.COLUMN_START_TIME)));
            newCourse.setEndTime(c.getString(c.getColumnIndex(Course.COLUMN_END_TIME)));
            newCourse.setRoom(c.getString(c.getColumnIndex(Course.COLUMN_ROOM)));
            newCourse.setProfessor(c.getString(c.getColumnIndex(Course.COLUMN_PROFESSOR)));
            newCourse.setEnrollCapacity(c.getInt(c.getColumnIndex(Course.COLUMN_ENROLL_CAPACITY)));
            newCourse.setEnrolled(c.getInt(c.getColumnIndex(Course.COLUMN_ENROLLED)));
        }
        else {
            newCourse = null;
        }

        return newCourse;
    }

    public Cursor queryCourseName(String courseName) {
        SQLiteDatabase db = getReadableDatabase();

        Cursor c = db.query(Course.TABLE_NAME, null, Course.COLUMN_COURSE_NAME + " = ?", new String[]{courseName}, null, null, null);

        return c;
    }

    public Cursor queryAllCourses() {
        SQLiteDatabase db = getReadableDatabase();

        Cursor c = db.query(Course.TABLE_NAME, null, null, null, null, null, null);

        return c;
    }

    public long insertCourse(Course c) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(Course.COLUMN_CLASS_NUMBER, c.getClassNumber());
        cv.put(Course.COLUMN_COURSE_NAME, c.getCourseName());
        cv.put(Course.COLUMN_SECTION, c.getSection());
        cv.put(Course.COLUMN_DAYS, c.getDays());
        cv.put(Course.COLUMN_START_TIME, c.getStartTime());
        cv.put(Course.COLUMN_END_TIME, c.getEndTime());
        cv.put(Course.COLUMN_ROOM, c.getRoom());
        cv.put(Course.COLUMN_PROFESSOR, c.getProfessor());
        cv.put(Course.COLUMN_ENROLL_CAPACITY, c.getEnrollCapacity());
        cv.put(Course.COLUMN_ENROLLED, c.getEnrolled());

        return db.insert(Course.TABLE_NAME, null, cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
