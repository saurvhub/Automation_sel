Narrative:
Google search

Scenario: Search on Google
Given User is on Google page
When User enters '<searchText>' in search field
When User clicks on search button
Then user clicks '<link>' Link

Examples:
|searchText|link|
|deep learning|deep learning|
|Machine learning|Machine learning|