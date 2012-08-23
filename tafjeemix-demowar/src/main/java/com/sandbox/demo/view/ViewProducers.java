package com.sandbox.demo.view;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import com.sandbox.tafjeemix.demoejb.SchoolDao;
import com.sandbox.tafjeemix.demoejb.TeacherCourseCount;
import com.sandbox.tafjeemix.demojar.Course;
import com.sandbox.tafjeemix.demojar.Teacher;

/**
 * This class is used to hold producer methods for view related items in the
 * application. This bean is only used when an item is requested that is
 * produced by one of these methods.
 * 
 * @author Andy Gibson
 * 
 */
public class ViewProducers {

	@Inject
	private SchoolDao schoolDao;

	/**
	 * Returns a list of JSF {@link SelectItem} objects for the teachers in the
	 * application based on ID and Name.
	 * 
	 * @return List of JSF select items for teachers
	 */
	@Produces
	@Named("teacherItems")
	@RequestScoped
	public List<SelectItem> generateTeacherItems() {
		List<Teacher> teachers = schoolDao.getTeachers();
		return ViewUtil.wrapInSelectItems(teachers, "Select Teacher");
	}

	/**
	 * Returns a list of JSF {@link SelectItem} objects for the courses in the
	 * application based on ID and Name.
	 * 
	 * @return List of JSF select items for teachers
	 */
	@Produces
	@Named("courseItems")
	@RequestScoped
	public List<SelectItem> generateCourseItems() {
		List<Course> courses = schoolDao.getCourses();
		return ViewUtil.wrapInSelectItems(courses, "Select Teacher");
	}
	
	@Produces
	@Named("teacherCourseCounts")
	@RequestScoped
	public List<TeacherCourseCount> generateTeacherCountList() {
		return schoolDao.getTeachCourseCounts();
	}

	/**
	 * Generates the demo data.
	 */
	@Produces
	@Named("dataStatus")
	public String getDataStatus() {
		return schoolDao.getDataStatus();
	}
	
}
