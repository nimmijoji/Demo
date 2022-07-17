#Author: Nimmi Joji
@raspberrypi
Feature: Testing of raspberry pi url changes
  
  @gblinks  
    Scenario: Verify raspberry pi
    Given web site is launched successfully and user "does" accept the cookies
    And user for wait for "2" seconds
    And user scroll down the page by pixels "300"
    And user take screenshot of GB links section
    And user get URL of "RaspberryPi.gb_link" as "raspberry-pi/rpi4-modbp-"
   And user open "RaspberryPi.gb_link" by keyboardEvent
   Then user click on "RaspberryPi.gb_link" without wait
   And user navigates back in the browser
    
    
    