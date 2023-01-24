Feature: Search the produact and Add to the cart

Scenario Outline: search the products in home and top deals page and verify it.

Given Land on Green cart home page 
When Enter the <Name> in search bar extract the name 
And Enter the same name <Name> in Top deals page
Then Verify both the names

Examples:
|Name|
|Tomato|
|cucumber|

Scenario: add to the cart verify the product in checkout page
Given Land on Green cart home page 
When Seach the product "tomato" and add on cart
Then verify the product in checkout page

Scenario Outline: add 4 product to the cart and verify them
Given Land on Green cart home page 
When add <count> <Name> in cart page
Then verify the <count> added quantity of product in checkout page

Examples:
|count|Name|
| 4	  |Tomato|
| 3   |cucumber|


Scenario: total no of links, it's text and link url of the greenkart.
Given Land on Green cart home page 
When total no of links
Then it's text and link url of the greenkart.


Scenario Outline: Place the oder of tomoato - 20 qty
Given Land on Green cart home page 
When add <count> <Name> in cart page
Then verify the <count> added quantity of product in checkout page

Examples:
|count|Name|
|20|Tomato|


Scenario: Go to Top deals and sort the page by 10 and print all the 10 item details
Given Land on Green cart home page 
When switch to top deals page and sort the page by 10 
Then print all the 10 item details

@cart
Scenario: Search flight from Bangalore to Hyderbad for the 25th March with 2 adults
Given Land on dropdown practise home page 
When select the from and To place
Then enter the month and date and select  two adult passangers



