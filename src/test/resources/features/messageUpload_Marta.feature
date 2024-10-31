@upload
Feature: Upload Files and Images as Messages

Background: user logged into the application
  Given the user logged in as "marketing"
  And user click on "Send Message" input field


Scenario Outline: User uploads a supported file type successfully
  When user uploads a file named  "<file_name>"
  Then the file "<file_name>" should be successfully attached to the message

Examples:
|file_name|
|sample-city-park-400x300.jpg|
|sample1.txt|
|sample1.pdf|
|failed_glue.png|
|demo.docx|
|day39 presentation slides.pdf|
|day39 class notes.txt|
|cukes_glue.png|


Scenario Outline: User uploads and inserts a supported file or image into the message text
  When user uploads a file named  "<file_name>"
  And user click insert in text button
  Then file "<file_name>" should be successfully attached to the message text area

Examples:
|file_name|
|day39 class notes.txt|
|sample1.txt|
|failed_glue.png|
|sample-city-park-400x300.jpg|
|demo.docx|
|sample1.pdf|

###Verify that the user can remove files and images at any time before sending.

Scenario Outline: User remove uploded file before sending message
  When user uploads a file named  "<file_name>"
  Then the file "<file_name>" should be successfully attached to the message
  Then user remove file by clicking on Remove Icon

Examples:
|file_name|
|sample1.txt|
|sample-city-park-400x300.jpg|



Scenario Outline: User successfully sends a message with attached files
  When user uploads a file named  "<file_name>"
  And the file "<file_name>" should be successfully attached to the message
  And user click Send Button
  Then user see file in Activity Stream

Examples:
|file_name|
|sample-city-park-400x300.jpg|