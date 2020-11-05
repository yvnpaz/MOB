package application.mob.service;

import application.mob.exception.CustomException;

public interface MobService {
	public int fibonacci(int number) throws CustomException;
}
