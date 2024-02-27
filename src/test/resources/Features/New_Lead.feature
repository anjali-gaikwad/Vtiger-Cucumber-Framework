Feature: New Lead creation

Background: User should be on lead page


@TC11
Scenario: Create lead with mandatory fields and save
When User fills marked fields
And  click save button
Then User should be able to see saved details

@TC12
Scenario: Create lead without mandatory fields
When User leaves marked fileds blank
And  clicks save button
Then Pop up should appear 
And  User should able to accept pop up

@TC13
Scenario: Create lead with details and cancel
When User fills all fields
And  click cancel button
Then User should be able to see home page

