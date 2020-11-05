package application.mob.service;

import application.mob.exception.CustomException;

public class MobServiceImpl implements MobService {

	@Override
	public int fibonacci(int number) throws CustomException {
		/* F(i) is not defined for negative integers */
		if (number <= 23) {
			if (number == 0)
				return 0;
			if (number <= 1)
				return 1;
			return fibonacci(number - 1) + fibonacci(number - 2);
		} else {
			throw new CustomException("Number too high.");
		}
	}

}
