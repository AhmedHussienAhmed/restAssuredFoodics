Foodics API Testing Example

This repository contains examples of API testing using Rest Assured for Foodics, 
 The code is written in Java and uses the Rest Assured library for API testing.

Prerequisites
To run these tests, you'll need the following:

Java Development Kit (JDK) installed on your system.
A Java IDE like Eclipse or IntelliJ (optional but recommended).
Maven installed (optional but recommended for managing project dependencies).


Getting Started
Clone this repository to your local machine:
git clone <repository-url>
Open the project in your Java IDE or navigate to the project directory in your terminal.

Ensure that you have the required dependencies (Rest Assured) in your project. 
If you're using Maven, it will automatically download the dependencies when you build the project.

Running the Tests
This project contains three test cases:

loginSuccessfullyToFoodicsWebsite: This test case sends a POST request to log in to the Foodics website and asserts that a valid token is returned.

checkWhomiUserResponseId: This test case logs in, extracts the token, and then sends a GET request to check the user's ID. It asserts that the user's ID is not null and matches a predefined value.

checkWhomiUserResponseUserName: Similar to the previous test, this one checks the user's name instead of the ID.

you can Run Test via TestNG annotations for all test cases or single one
