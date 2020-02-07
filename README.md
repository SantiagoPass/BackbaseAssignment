# Santiago`s BackbaseAssignment

## How to execute the tests

#### Configure connected device
To execute the Automated test cases is recommended to turn off system animations on the device or emulator we will be using. Since Espresso is a UI testing framework, system animations can introduce flakiness in our tests. Under Settings => Developer options disable the following 3 settings and restart the device:

![](https://raw.githubusercontent.com/SantiagoPass/BackbaseAssignment/master/images/device_config.png)

#### Run all the tests through Gradle:

* Open the Gradle window and find connectedDebugAndroidTest under Tasks => verification.

* Right click and select Run

![](https://raw.githubusercontent.com/SantiagoPass/BackbaseAssignment/master/images/execution_from_gradle.png)

## Automation report

This will generate an html test result report at app/build/reports/androidTests/connected/index.html

![](https://raw.githubusercontent.com/SantiagoPass/BackbaseAssignment/master/images/report.png)

## QA Deliverables

The complete information is available into "QA Deliverables" folder, the main file there is the **Backbase Mobile Assignement Overall App Evaluation Report** . It provides a summary of the application status and also the links to the other deliverables, the following contents in this file is:
+ Purpose
+ Overview
+ Test Results
	+ Link to the Last execution Test Report
	+ Link to the Last execution Automation Report
+ Test Cases
	+ Link to each Test Case
+ Bugs Found
	+ Link to each Bug
+ Suggested Actions
+ Risk

**Note:** The **Test Report Execution (02-05-2020)**  provides a summary of the results of test performed at 02-05-2020 as outlined within this document. The Table of contents include:
+ Purpose
+ Overview
+ Test Type (Functional UI TESTING)
+ TEST ASSESSMENT
+ TEST RESULTS
	+ Sumary Results
	+ Test cases details
	+ Automation Report
	+ Bugs details
+ SUGGESTIONS for the feature tested
