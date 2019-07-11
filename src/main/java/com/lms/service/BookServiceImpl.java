package com.lms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lms.models.Book;
import com.lms.repository.BooksRepo;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BooksRepo bookRepository;

	@Override
	public Book getBook(Integer idBooks) {
		return bookRepository.getOne(idBooks);
	}

	@Override
	public Book createOrUpdateBook(Book book) {
		if (book.getIdBooks() == null) {
			return bookRepository.save(book);
		} else {
			Optional<Book> currBook = bookRepository.findById(book.getIdBooks());
			if (currBook.isPresent()) {
				Book newBook = currBook.get();
				newBook.setBookTitle(book.getBookTitle());
				newBook.setBooksGenre(book.getBooksGenre());
				newBook.setBooksAuthor(book.getBooksAuthor());
				newBook.setBookYear(book.getBookYear());
				newBook.setBookDescription(book.getBookDescription());
				newBook.setBookPicture(book.getBookPicture());
				newBook.setBookFile(book.getBookFile());
				newBook.setBookStatus(book.getBookStatus());
				return bookRepository.save(newBook);
			} else {
				return bookRepository.save(book);
			}
		}
	}

	@Override
	public void deleteBook(Integer idBooks) {
		bookRepository.deleteById(idBooks);// .getOne(idBooks).setBookStatus(false);
	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

}
