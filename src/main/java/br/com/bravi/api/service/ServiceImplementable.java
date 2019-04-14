package br.com.bravi.api.service;

import java.util.List;


public interface ServiceImplementable<T> {
	public List<T> getAll();
	public T getId(Long id);
	public T create(T sourceRequest);
	public T update(Long id, T sourceRequest);
	public void delete(Long id);
}
