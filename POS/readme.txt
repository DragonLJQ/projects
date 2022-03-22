POS project is a point-of-sale system. This file introduces the format of the input files of POS. More information please refer to the requirement of assignment 1.
userPasswordFile.txt
	The first line indicates the currency type, the second line indicates the tax strategy.
	The third line and below:
	username password

productListFile.txt
	The first line indicates the event discount, the second line indicates the membership discount.
	The third line and below:
	itemID itemName price number [specialDiscount]
	Note: At the end of each product line, discount number can be added to indicate the discount of a specific product. No discount number means the product does not have a special discount.