/**
 * College
 *
 * Represents an abstraction of a college. Each college may have courses, professors, students, and teachers.
 *
 * @author You
 *
 * @version date of completion
 *
 */

public class College {

    /**
     * Maximum number of Courses allowed to be added to a College
     */
    protected static final int MAX_COURSES = 10;

    /**
     * Maximum number of Professors allowed to be hired by a College
     */
    protected static final int MAX_PROFESSORS = 5;

    /**
     * Maximum number of Teachers allowed to be hired by a College
     */
    protected static final int MAX_TEACHERS = 25;

    /**
     * Maximum number of Students allowed to be enrolled to a College
     */
    protected static final int MAX_STUDENTS = 500;


    private int tuition;				// cost to attend the College

    private String name;				// name of the College
    private Professor[] professors;		// array of the professors at the College
    private Teacher[] teachers;			// array of the teachers   at the College
    private Student[] students;			// array of the students   at the College
    private Course[] courses;			// array of the courses    at the College

    public College(String name, int tuition) {
    	/**
         * Constructs a new College object with the corresponding parameters as field values, and new arrays of Professors,
         * Students, Teachers, and Courses limited by the corresponding MAX variables.
         *
         * @param name Name of the College to be created.
         * @param tuition Cost for students to attend.
         */
    	this.name = name;
    	this.tuition = tuition;
    	
    	this.professors = new Professor[MAX_PROFESSORS];
    	this.teachers   = new Teacher[MAX_TEACHERS];
    	this.students   = new Student[MAX_STUDENTS];
    	this.courses    = new Course[MAX_COURSES];
    }
    public void addCourse(Course course) 
    {
    	/**
         * Adds course to the College's array of courses. If the course is null, the course is already available at the
         * College, or the College cannot add more courses, nothing changes.
         *
         * @param course A course object to be added to the College's array of courses.
         */
    	int i = 0;
    	for(;i < this.courses.length; i++)
    	{
    		if( this.courses[i] == null )		// find the last avaible slot in the courses	
    		{
    			this.courses[i] = course;
    		}
    	}
    	// if there is no room nothing happens
    }
    public void hireProfessor(Professor professor) 
    {
    	/**
         * Adds professor to the College's array of Professors. If the Professor is null, the College cannot add more
         * Professors, or the Professor is already employed by the College, nothing changes.
         *
         * @param professor Professor to be added to the College's array of Professors
         */
    	if( professor == null )
    		return;											// someone dumb sent a null parameter
    		
    	for(int i = 0; i < this.professors.length; i++ )
    	{
    		if( this.professors[i].equals(professor) )
    		{
    			return;										// professor already exits 
    		}
    		if( this.professors[i] == null )
    		{
    			this.professors[i] = professor;				// adds the professor
    		}
    	}
    	// the College can not hire more professors
    }
    public void hireTeacher(Teacher teacher)
    {
    	/**
         * Adds teacher to the College's array of Teachers. If teacher is null, the College cannot add more Teachers,
         * or teacher is already employed by the College, nothing changes.
         *
         * @param teacher Teacher to be added to the College's array of teachers
         */
    	if( teacher == null )
    		return;											// someone dumb sent a null parameter
    		
    	for(int i = 0; i < this.teachers.length; i++ )
    	{
    		if( this.teachers[i].equals(teacher) )
    		{
    			return;										// teacher already exits 
    		}
    		if( this.teachers[i] == null )
    		{
    			this.teachers[i] = teacher;				// adds the teacher
    		}
    	}
    	// the College can not hire more professors
    }
    public void addStudent(Student student)
    {
    	/**
         * Adds student to the College's array of students. If the student is null, the student is already enrolled at the
         * College, or the College cannot add more students, nothing changes.
         *
         * @param student A Student object to be added to the College's array of students.
         */
    	if( student == null )
    		return;											// someone dumb sent a null parameter
    		
    	for(int i = 0; i < this.students.length; i++ )
    	{
    		if( this.students[i].equals(student) )
    		{
    			return;										// student already exits 
    		}
    		if( this.students[i] == null )
    		{
    			this.students[i] = student;					// adds the student
    		}
    	}
    	// the College can not enroll more students
    }
    public void dropStudent(Student student) 
    {
    	/**
         * Removes student from the College's array of Students. If the student is enrolled in any Courses, they should be
         * removed from these courses. If student is null or the student is not currently enrolled, nothing changes.
         *
         * *HINT* If you try to remove a student from a Course, an exception is thrown. Consider using a try-catch block.
         *
         * @param student Student to be removed from the College's array of students
         */
    }

    /**
     * Returns the net change in the colleges budget. Tuition per student will increase the net change, and payments for
     * Professors and Teachers according to both their base and per course salaries will decrease the net change.
     *
     * @return Net change in the College's funds
     */
    public int calculateNetBudgetChange() {
        //TODO: Calculate the change in budget (Total tuition - Professor Salaries - Teacher Salaries)
        return 0;
    }

    /**
     * @return A reference to the array of courses offered by this College.
     */
    public Course[] getCourses()
    {
        //TODO: Return the array of Courses.
        return null;
    }

    /**
     * @return A reference to the array of Teachers employed by this College.
     */
    public Teacher[] getTeachers()
    {
        //TODO: Return the array of Teachers
        return null;
    }

    /**
     * @return A reference to the array of Professors employed by this College.
     */
    public Professor[] getProfessors()
    {
        //TODO: Return the array of Professors
        return null;
    }

    /**
     * @return A reference to the array of Students enrolled at this College.
     */
    public Student[] getStudents()
    {
        //TODO: Return the array of Professors
        return null;
    }

    /**
     * @return The name of the College object
     */
    public String getName() {
        //TODO: Return the name of the College object
        return null;
    }

    /**
     * @return The tuition charged per student
     */
    public int getTuition() {
        //TODO: Return the tuition of the College object
        return 0; // I wish
    }
}
