package android.reedbyford.studentscheduler.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.reedbyford.studentscheduler.R;
import android.reedbyford.studentscheduler.database.Repository;
import android.reedbyford.studentscheduler.entities.Course;
import android.reedbyford.studentscheduler.entities.Term;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, TermList.class);
                startActivity(intent);
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addSampleData:
                Term term=new Term(0, "Term 1", "09-01-2022", "02-28-2023");
                Repository repository=new Repository(getApplication());
                repository.insert(term);
                Course course=new Course(0, "Introduction to IT - C182", "09-01-2022", "09-04-2023", "Completed", 0);
                repository.insert(course);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}