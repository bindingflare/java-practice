package day26.school;

public class SubjectList {
	private static Subject[] subjectList = { new Subject("Maths 1", "MATNO1-001", SubjectType.MATH),
			new Subject("Maths 2", "MATNO2-101", SubjectType.MATH),
			new Subject("Korean Basic Lvl", "KORBSC-002", SubjectType.KOREAN),
			new Subject("Korean Advanced Lvl", "KORADV-102", SubjectType.KOREAN),
			new Subject("English Basic Lvl", "ENGBSC-003", SubjectType.ENGLISH),
			new Subject("English Advanced Lvl", "ENGADV-103", SubjectType.ENGLISH) };

	public static Subject getSubject(String ID) {
		for (Subject subject : subjectList) {
			if (subject.getID().equals(ID)) {
				return subject;
			}
		}

		return null;
	}

	public static boolean has(String ID) {
		for (Subject subject : subjectList) {
			if (subject.getID().equals(ID)) {
				return true;
			}
		}

		return false;
	}

	public static String[] getIDs() {
		String[] IDs = new String[subjectList.length];

		for (int i = 0; i < subjectList.length; i++) {
			IDs[i] = subjectList[i].getID();
		}

		return IDs;
	}
}
