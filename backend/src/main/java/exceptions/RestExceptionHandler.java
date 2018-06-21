package exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
                                                                     HttpHeaders headers, HttpStatus status, WebRequest request) {
		return new ResponseEntity<Object>("JSON expexted, got " + headers.getContentType(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler({CustomHttpException.class})
	public ResponseEntity<Object> handleCustomHttpException(CustomHttpException ex, WebRequest web) {
		return new ResponseEntity<Object>(ex.getMessage(), ex.getStatusCode());
	}

	@ExceptionHandler({Exception.class})
	public ResponseEntity<Object> handleAll(Exception ex, WebRequest web) {
		return new ResponseEntity<Object>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}