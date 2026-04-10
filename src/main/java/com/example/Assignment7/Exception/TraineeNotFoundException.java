package com.example.Assignment7.Exception;

public class TraineeNotFoundException extends RuntimeException{
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public TraineeNotFoundException(){
        super("TraineeNotFound");
	    }
}
