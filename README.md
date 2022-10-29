# ***Course Chance***
### Personal Project - CPSC 210
##  **Project Proposition**

In today's world the education sector relies greatly on modern adaptive technologies for educating their students.
Most institutions have moved all their courses to online learning as a preventive measure to COVID-19. To aid with 
the registrations and course load management, the students need a robust application to help them create worklist 
with enough information to let the student know if they really have a chance getting into the course i.e. is the 
course competitive or not. This application will help the students to do so and deduce their chance of getting into
the course with realistic expectation. This application aims to remove the Pre- Course Registration doubt and frustration 
students have regarding the chances that they'll be able to register themselves in a particular course.  
 
#### Application's  **functionalities** include:
>- The application provides an easy to use Console user interface.
>- The application allows the student to login/sign up to the application in order to view and create worklist.
 >- The application will let the student see the status of availability of the courses the students registers in.
 >- The application will allow the admin to login and create/delete courses as per the requirements of their 
  institution.
 >- The application will let the admin decide the number of seats, and the credits that pertain to a selected course.
 >- The application will also provide information to the students about how many students have already registered that 
 particular course into their worklist and let them know , how competitive the course is to get in.
>- The application suggests the likelihood of the user getting into the course depending on the number of students that
 registered the course into their worklist as compared to the number of seats in the course. 

This application is something that can benefit many students who register into courses without knowing the competition 
in that course and decide their future plans based on their prediction that they will get into the course or not. Many 
students who do not get in to a course is because of late registration and this application will help the student prevent
some of those mistakes by anticipating the number of students that will be selecting the course. The application will act
as an alarm for the students that they need to register into the course as soon as the registration opens as well as an 
indication that student receives when registering into the course.   

## User Stories
**a)** As a user, I want to be able to login or sign up my student account and create worklists.   
**b)** As a user, I want to be able to view the available courses.   
**c)** As a user, I want to be able to add and remove courses from my worklists.
**d)** As a user, I want to be able to get an idea of how many students have registered a particular course in their worklist.    
**e)** As a user, I want to be able to login to admin account and create/delete the courses available.  
**f)** As an admin, I want to be able to provide the number of seats and number of credits in a particular
 course.  
**g)** As a user, I want to be able to use the Console interface easily and efficiently  
**h)** As a user, I want to see my courses together, in the form of a list.
**i)** As a user, I want to be able to save my personal information and registered courses in a file.
**i)** As a user, I want to be able to load my personal information and registered courses from a file.
**j)** As an admin, I want to be able to save the courses which are being generated in a file.
**k)** As an admin, I want to be able to load the courses generated from a file.

**Note**
Admin Portal is an exclusive functionality provided only to the admin predefined by the institution. Please login as an 
admin using the following details:

**E-mail: admin@ubc.ca  
Password: admin** 

## Phase 4: Task 2

Implemented Task 2 on CourseStorage class.
addCourse() method in CourseStorage class throws DuplicateCourseException. 
Necessary test cases implemented.
 


