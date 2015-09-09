package com.rationalresolution.dah.service;

import java.util.List;

public interface CRUDService<T> {
	
	public static class NotFoundException extends Exception {
		private Class<?> type;
		private int ID;

		public NotFoundException(Class<?> type, int ID) {
			super("No " + type.getSimpleName() + " found with ID " + ID + ".");

			this.type = type;
			this.ID = ID;
		}

		public Class<?> getType() { return type;	}
		public int getID() { return ID;	}
	}

	public static class ConflictException extends Exception {
		private Object candidate;
		private int ID;

		public ConflictException(Object candidate, int ID) {
			super("There is already a " + candidate.getClass().getSimpleName() + " with ID " + ID + ".");

			this.candidate = candidate;
			this.ID = ID;
		}

		public Object getCandidate() { return candidate; }
		public int getID() { return ID;	}
	}
}