package com.callor.todo.service;

import com.callor.todo.persistance.TodoDao;


// Generic 에 선언된 기본 CRUD 메서드와 TodoDao 에 선언된 findByUsername 메서드를 상속
public interface TodoService extends TodoDao{

}
