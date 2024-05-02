import java.util.ArrayList;
import java.util.Scanner;

class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private int schedule;

    public Course(String code, String title, String description, int capacity, int schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSchedule() {
        return schedule;
    }
}

class Student {
    private int id;
    private String name;
    private ArrayList<Course> courses;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void registerCourse(Course course) {
        if (courses.size() < 5) {
            courses.add(course);
            System.out.println("Course registered successfully.");
        } else {
            System.out.println("You have already registered for the maximum number of courses.");
        }
    }

    public void removeCourse(Course course) {
        courses.remove(course);
        System.out.println("Course removed successfully.");
    }
}

class CourseRegistrationSystem {
    private ArrayList<Course> courses;
    private ArrayList<Student> students;

    public CourseRegistrationSystem() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void displayCourses() {
        System.out.println("Available Courses:");
        for (Course course : courses) {
            System.out.println("Course Code: " + course.getCode());
            System.out.println("Title: " + course.getTitle());
            System.out.println("Description: " + course.getDescription());
            System.out.println("Capacity: " + course.getCapacity());
            System.out.println("Schedule: " + course.getSchedule());
            System.out.println("-------------------------");
        }
    }

    public void registerStudent(Student student) {
        students.add(student);
    }

    public Student findStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CourseRegistrationSystem system = new CourseRegistrationSystem();

        Course course1 = new Course("CS101", "Introduction to Computer Science", "Fundamentals of programming", 50, 1);
        Course course2 = new Course("MATH101", "Calculus I", "Limits, derivatives, and integrals", 40, 2);
        Course course3 = new Course("ENG101", "English Composition", "Writing and communication skills", 60, 3);

        system.addCourse(course1);
        system.addCourse(course2);
        system.addCourse(course3);

        boolean running = true;
        while (running) {
            System.out.println("1. Display Available Courses");
            System.out.println("2. Register Student");
            System.out.println("3. Register for Course");
            System.out.println("4. Remove Course");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    system.displayCourses();
                    break;
                case 2:
                    System.out.print("Enter Student ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter Student Name: ");
                    scanner.nextLine(); // consume newline
                    String name = scanner.nextLine();
                    Student student = new Student(id, name);
                    system.registerStudent(student);
                    break;
                case 3:
                    System.out.print("Enter Student ID: ");
                    int studentId = scanner.nextInt();
                    System.out.print("Enter Course Code: ");
                    String code = scanner.next();
                    Student std = system.findStudent(studentId);
                    if (std != null) {
                        for (Course course : system.courses) {
                            if (course.getCode().equals(code)) {
                                std.registerCourse(course);
                                break;
                            }
                        }
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Student ID: ");
                    int stdId = scanner.nextInt();
                    System.out.print("Enter Course Code: ");
                    String courseCode = scanner.next();
                    Student studentToRemove = system.findStudent(stdId);
                    if (studentToRemove != null) {
                        for (Course course : studentToRemove.getCourses()) {
                            if (course.getCode().equals(courseCode)) {
                                studentToRemove.removeCourse(course);
                                break;
                            }
                        }
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
        scanner.close();
    }
}
