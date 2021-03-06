#Navigate to:  http://automationpractice.com/index.php
#Click on sign in button
#Click on the my addresses
#Click on the add a new address
#Enter all the fields (Choose random items from the dropdown)
#Click on save button
#Verify your address is displayed in the website
#Click on the update button
#Change the first name and last name
#Click on the save button
#Verify first name and last name is updated
#Click on the delete button
#Click on the okay
#Verify address is removed from the website

Feature: Practice1, verify address operations
  @SmokeTest
  Scenario: Successful login to the website
    Given navigate to "http://automationpractice.com/index.php"
    Then user is on "Login Page"
    When click on "Sign In link"
    And enter username and password
    And click on "Sign In button"
    Then user should login successfully

    ############################################################################

  Scenario: Verify the new address added to the account
    Given user is on "My Account Page"
    When click on "My addresses button"
    Then user is on "My Addresses Page"
    When click on "Add a new address button"
    Then "YOUR ADDRESSES" form should display
    When fill the form text fields as below:
      | First Name | Umed         |
      | Last Name  | Murodov      |
      | Address    | 3849 4th ave |
      | City       | Brooklyn     |
    And randomly select an option from the "State" dropdown list
    And fill the form text fields as below:
      | Zip/Postal Code | 11218        |
      | Home phone      | 929999277    |
      | Address title   | New Address2 |
    And click on "Save Button"
    Then new address with Address title "New Address2" should display

    ############################################################################

  Scenario: Verify the first name and last name is updated
    Given user is on "My Addresses Page"
    When under "New Address2" address click on "Update"
    Then "YOUR ADDRESSES" form should display
    When fill the form text fields as below:
      | First Name | Hakim   |
      | Last Name  | Salimov |
    And click on "Save Button"
    Then under "New Address2" block "Hakim Salimov" should display

    ############################################################################

  Scenario: Delete an address and verify its removed from the website
    Given user is on "My Addresses Page"
    When under "New Address2" address click on "Delete"
    And click on "OK" on alert
    Then address block "New Address2" should be removed from the page


