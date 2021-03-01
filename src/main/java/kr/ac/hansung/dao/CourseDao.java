package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Course;

@Repository
public class CourseDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int getRowCount() {
		String sqlStatement = "select count(*) from course";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
	}

	// 연도와 학기에 맞춘 출력.
	public List<Course> getSemesterCourses(String year, String semester) {
		String sqlStatement = "select * from course WHERE year=" + year + " and semester =" + semester;

		return jdbcTemplate.query(sqlStatement, new RowMapper<Course>() {

			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {

				Course course = new Course();
				course.setYear(rs.getInt("year"));
				course.setSemester(rs.getInt("semester"));
				course.setCoursename(rs.getString("coursename"));
				course.setClassification(rs.getString("classification"));
				course.setProfessor(rs.getString("professor"));
				course.setCredit(rs.getInt("credit"));

				return course;
			}

		});
	}

	// 그냥 그룹 단위로 출력해주는 함수
	public List<Course> getGroupCourses() {
		String sqlStatement = "select year, semester, sum(credit) from course group by year, semester order by year";
		return jdbcTemplate.query(sqlStatement, new RowMapper<Course>() {

			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				Course course = new Course();
				course.setYear(rs.getInt("year"));
				course.setSemester(rs.getInt("semester"));
				course.setCredit(rs.getInt("sum(credit)"));
				return course;
			}
		});
	}

	// 전체출력해주는 함수.
	public List<Course> getCourses() {
		String sqlStatement = "select * from Course";
		return jdbcTemplate.query(sqlStatement, new RowMapper<Course>() {

			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {

				Course course = new Course();
				course.setYear(rs.getInt("year"));
				course.setSemester(rs.getInt("semester"));
				course.setCoursename(rs.getString("coursename"));
				course.setClassification(rs.getString("classification"));
				course.setProfessor(rs.getString("professor"));
				course.setCredit(rs.getInt("credit"));

				return course;
			}
		});
	}

	// 수강 신청 연산자. - 2021년 1월
	// Crud method
	public boolean insert(Course course) {

		int year = course.getYear();
		int semester = course.getSemester();
		String coursename = course.getCoursename();
		String classification = course.getClassification();
		String professor = course.getProfessor();
		int credit = course.getCredit();
		String sqlStatement = "INSERT INTO `course` (`year`, `semester`, `coursename`, `classification`, `professor`, `credit`)"
				+ "	 VALUES (?, ?, ?, ?, ?, ?)";
		return (jdbcTemplate.update(sqlStatement,
				new Object[] { year, semester, coursename, classification, professor, credit }) == 1);
	}
}
