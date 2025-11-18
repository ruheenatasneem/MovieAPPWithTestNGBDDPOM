# MovieAPPWithTestNGBDDPOM
Movie web pages testing using POM , TestNG, BDD  
🎬 MOVIE WEB APPLICATION – AUTOMATION TESTING EXPLANATION

This automation project is designed to test a Movie Web Application where users can:

Search for movies

View details (title, rating, Description, Sensor, Year of release.)

Navigate through pages.

Account and Log out page.

⭐ 1. POM (Page Object Model)
What is POM?

POM is a design pattern where each web page is represented as a separate Java class.

Example:

HomePage.java

MovieDetailsPage.java

LoginPage.java (if needed)

Why use POM?

✔ Clean & organized code
✔ Reusable page functions
✔ Easy maintenance 

How POM works here

Example:
HomePage.java contains:

Locators for search box, search button, movie cards

Methods like searchMovie(), selectFirstMovie()

MovieDetailsPage.java contains:

Movie title

Rating

Methods like getMovieTitle() 

2. TestNG (Testing Framework)

TestNG is used to run automation tests with:

@Test

@BeforeClass

@AfterClass

Assertions

TestNG Purpose

✔ Organizes test execution
✔ Gives reporting & grouping
✔ Helps run tests easily
✔ Works well with Selenium 

⭐ 3. BDD (Behavior Driven Development)
Why BDD?

BDD makes test cases understandable for non-technical people using plain English.

We use:

Cucumber

Gherkin syntax

How BDD Works Here
Step 1: Write Feature File

Describes what the user does.

Step 2: Implement Step Definitions

Connect Gherkin to code. 
@When("user searches for {string}")
public void search_for_movie(String movie) {
    home.searchMovie(movie);
} 

Step 3: Run Using TestRunner

Cucumber + TestNG execution.
⭐ 4. Driver Factory
Purpose

Controls WebDriver in one place.

public static WebDriver initDriver() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    return driver;
}

⭐ 5. Hooks (For BDD)

Before and After scenarios:

@Before
public void init() {
    DriverFactory.initDriver();
}

@After
public void quit() {
    DriverFactory.driver.quit();
}


This ensures:

✔ Browser opens before scenario
✔ Browser closes after scenario

⭐ 6. Test Flow (Complete Workflow)
User perspective:

Open the movie website

Search for a movie

Open first movie

Check title

Automation does the same:
Step 1: Initialize driver
Step 2: Load home page
Step 3: Search movie
Step 4: Select movie
Step 5: Validate movie details

Everything is modular:

Pages in /pages

Step definitions in /stepDefinitions

Test scripts in /tests

Features in /features

⭐ 7. Why This Framework Is Good

✔ Uses Page Object Model for maintainability
✔ Uses TestNG for strong testing features
✔ Uses Cucumber for readable test cases
✔ Reusable classes (DriverFactory, Hooks)
✔ Clear structure for large automation projects
✔ Easy to scale (more pages, more tests)

✔ Reduces duplication

