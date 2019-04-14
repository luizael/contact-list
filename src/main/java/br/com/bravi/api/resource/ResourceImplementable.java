package br.com.bravi.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface ResourceImplementable<T> {
	public List<T> getAll();
	public ResponseEntity<T> getId(Long id);
	public ResponseEntity<T> create(T request, HttpServletResponse response);
	public ResponseEntity<T> update(Long id, T request);
	public void delete(Long id);
}
