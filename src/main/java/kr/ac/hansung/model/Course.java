package kr.ac.hansung.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Course {

	private int year;
	private int semester;

	// size작동함.
	@Size(min = 2, max = 30, message = "필수 항목입니다.")
	private String coursename;

	@Size(min = 2, max = 10, message = "필수 항목입니다.")
	private String classification;

	@Size(min = 2, max = 10, message = "필수 항목입니다. ")
	private String professor;

	@Min(value = 1, message = "최소학점 1학점입니다.")
	@Max(value = 3, message = "최대학점 3학점입니다.")
	private int credit;
}
