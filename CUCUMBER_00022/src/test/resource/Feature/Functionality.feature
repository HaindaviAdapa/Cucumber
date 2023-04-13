
Feature: Iam doing automation functionality of Add Skills and Add Nationality and Add Jobs in Orange HRM



Background: Common Steps
Given User launch chrome browser
Then User launch application URL"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"


@Regression @Smoke
Scenario: Add Jobs
    And User enters username as "Admin" and password as "admin123"
    Then Create Job Record
					|Sales10000011|Sales10000011 Descr|Sales10000011 Note|
					|Sales20000011|Sales20000011 Descr|Sales20000011 Note|
					|Sales30000011|Sales30000011 Descr|Sales30000011 Note|
    When Click on logout button
    Then Close Browser
    
    @Regression @Progression
    Scenario: Add nationality
    And User enters username as "Admin" and password as "admin123"
    Then Creating Nationality Record1
    			|NationalityText|
					|Indian2530001|
					|Indian2540001|
					|Indian2550001|
    When Click on logout button
    Then Close Browser
    
    @Progression @Smoke
    Scenario: Add Skills
    And User enters username as "Admin" and password as "admin123"
    Then Creating Skills Record1
        	|SkillName|SkillDescr|
					|Sales60010000112|Sales60010000112 descr|
					|Sales60020000112|Sales60020000112 descr|
					|Sales60030000112|Sales60030000112 descr|
    When Click on logout button
    Then Close Browser
  





