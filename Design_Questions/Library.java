/**
	Question: Library Management System.

	Logic: 
		- Classes are Librarian, Memebers, Books, Transaction, Bill

	Classes:
		Librarian 	= Name, Password, searchBook(..), issueBook(..), returnBook(..), calculateBill(), calculateFine()
		Members 	= Name, id, member_start_date, member_end_date, max_book_limit, booksIssuedSoFar, finesSoFar, returnBook(), getBook()
		Books 		= Name, id, price, edition, isAvailable()
		Transaction	= id, date, memeber_id, book_id, due_date
		Bill 		= id, date, amount, member_id, book_id

	Flow:
		- Members asks for a book to librarian.
		- Librarian checks whether the book is available or not. Also checks whether the member has reached the max limit or not. If both these are okay then Librarian will issue the book.
		- Librarian first creates a trnasaction for the book and creates a bill for the book.	
*/

class Library {

}