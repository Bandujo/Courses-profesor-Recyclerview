package es.uniovi.imovil.jcgranda.courses;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

	private CourseRecyclerViewAdapter adapter = null;
	private RecyclerView recyclerView = null;
	private RecyclerView.LayoutManager layoutManager = null;

    public static int posicion = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Configurar la lista
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_courses);

		String [] courses = getResources().getStringArray(R.array.courses);
		String [] teachers = getResources().getStringArray(R.array.teachers);

        adapter = new CourseRecyclerViewAdapter(this, createCourseList(courses, teachers));
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Descomentar esta linea y comentar la anterior para cambiar el aspecto del
        // Recyclerview y convertirlo en un array de 2 columnas
        //recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

	}

	private List<Course> createCourseList(String[] names, String[] teachers) {
		
		if (names.length != teachers.length) {
			throw new IllegalStateException();
		}
			
		ArrayList<Course> courses = new ArrayList<Course>(names.length);
		for (int i = 0; i < names.length; i++) {
			courses.add(new Course(names[i], teachers[i]));
		}
		return courses;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflar el men� y a�adir acciones al action bar si existe
		getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
			    
	    switch (item.getItemId()) {
	        case R.id.action_add_course:
	            addCourse();
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

	private void addCourse() {

        String orden = Integer.toString(posicion);
		Course course = new Course("Asignatura "+orden, "Profesor "+orden);
        posicion++;

		adapter.addCourse(course);
	}
}
